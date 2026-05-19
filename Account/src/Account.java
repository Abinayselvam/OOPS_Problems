public class Account {
    private double balance;
    public Account(double balance)
    {
        this.balance=balance;
    }

    //Credit b
    public void credit(double amount)
    {
        balance+=amount;
    }
    //Debit amount
    public void debit(double amount)
    {
      if(balance<amount)
      {
          System.out.println("Debit amount exceeded account balance.");
      }
      else{
          balance-=amount;
      }
      //Getting balance amount

    }
    public double getBalance()
    {
        return balance;
    }
}
