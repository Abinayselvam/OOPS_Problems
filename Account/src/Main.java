import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        Account account=new Account(1000);
        System.out.println("Initial balance: "+account.getBalance());
        System.out.println("Enter debit Amount:");
        double amount=sc.nextDouble();
        account.debit(amount);
        System.out.println("Enter the credit Amount:");
        double amount1=sc.nextDouble();
        account.credit(amount1);
        System.out.println("Final Balance:"+account.getBalance());
        sc.close();

    }
}