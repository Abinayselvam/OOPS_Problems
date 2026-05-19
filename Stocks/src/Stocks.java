public class Stocks {
    private String name;
    private int numberOfShares;
    private double sharePrice;

    public Stocks(String name,int numberOfShares,double sharePrice)
    {
        this.name=name;
        this.numberOfShares=numberOfShares;
        this.sharePrice=sharePrice;
    }

    public double getStockValue()
    {
        return sharePrice*numberOfShares;
    }
    public void display()
    {
        System.out.println("Stock: " + name);
        System.out.println("Shares: " + numberOfShares);
        System.out.println("Price: " + sharePrice);
        System.out.println("Value: " + getStockValue());
        System.out.println("-----------------------");
    }
}
