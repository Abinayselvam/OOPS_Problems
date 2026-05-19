public class Main {
    public static void main(String[] args)
    {
        StockAccount account=new StockAccount("stocks1.txt");

        account.buy(50,"TCS");
        account.sell(70,"Infosys");
        account.buy(80,"PWC");

        account.printReport();
        account.save("stocks1.txt");
    }
}