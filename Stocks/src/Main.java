import java.io.File;
import java.util.Scanner;

public  class Main
{
    public static void main(String[] args)
    {
        System.out.println("Welcome to Stock Account Management");
        Portfolio portfolio=new Portfolio();
        try
        {
             File file=new File("stocks.txt");
            Scanner sc=new Scanner(file);
            while (sc.hasNext())
            {
                String name=sc.next();
                int shares=sc.nextInt();
                double price=sc.nextDouble();
                portfolio.addStock(new Stocks(name,shares,price));
            }
            sc.close();
        }
        catch (Exception e)
        {
            System.out.println("Error reading file."+e.getMessage());
        }
        portfolio.printReport();
    }
}
