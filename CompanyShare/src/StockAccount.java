import java.io.*;
import java.util.*;
import java.time.format.DateTimeFormatter;

public class StockAccount {

    private ArrayList<CompanyShare> stockList = new ArrayList<>();

    // Constructor → load from file
    public StockAccount(String filename) {
        load(filename);
    }

    // Load existing data
    private void load(String filename) {
        try {
            File file = new File(filename);
            if (!file.exists()) return;

            Scanner sc = new Scanner(file);

            while (sc.hasNext()) {
                String symbol = sc.next();
                int shares = sc.nextInt();
                stockList.add(new CompanyShare(symbol, shares));
            }

            sc.close();

        } catch (Exception e) {
            System.out.println("Error loading file");
        }
    }

    // Total value (simple version)
    public double valueOf() {
        double total = 0;

        for (CompanyShare cs : stockList) {
            total += cs.shares * 100; // assume fixed price (you can improve)
        }

        return total;
    }

    //BUY stock
    public void buy(int amount, String symbol) {

        for (CompanyShare cs : stockList) {
            if (cs.symbol.equalsIgnoreCase(symbol)) {
                cs.shares += amount;
                cs.dateTime = java.time.LocalDateTime.now();
                return;
            }
        }

        // if not found → create new
        stockList.add(new CompanyShare(symbol, amount));
    }

    // SELL stock
    public void sell(int amount, String symbol) {

        for (CompanyShare cs : stockList) {
            if (cs.symbol.equalsIgnoreCase(symbol)) {

                if (cs.shares >= amount) {
                    cs.shares -= amount;
                    cs.dateTime = java.time.LocalDateTime.now();
                } else {
                    System.out.println("Not enough shares to sell");
                }
                return;
            }
        }

        System.out.println("Stock not found");
    }

    // SAVE to file
    public void save(String filename) {

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename));

            for (CompanyShare cs : stockList) {
                writer.write(cs.symbol + " " + cs.shares);
                writer.newLine();
            }

            writer.close();

        } catch (Exception e) {
            System.out.println("Error saving file");
        }
    }

    // PRINT REPORT
    public void printReport() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        System.out.println("Stock Report:");

        for (CompanyShare cs : stockList) {
            System.out.println(cs.symbol + " | Shares: " + cs.shares +
                    " | Last Updated: " + cs.dateTime.format(formatter));
        }

        System.out.println("Total Value: " + valueOf());
    }
}