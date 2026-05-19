import java.util.ArrayList;

public class Portfolio {
    private ArrayList<Stocks> stocks=new ArrayList<>();

    public void addStock(Stocks stock)
    {
        stocks.add(stock);
    }
    public void printReport()
    {
        double totalValue=0;
        for(Stocks stocks1:stocks)
        {
            stocks1.display();
            totalValue+=stocks1.getStockValue();
        }
        System.out.println("Total Portfolio value:"+totalValue);
    }
}
