package basicexceptionhandling;

import java.util.Scanner;
class InsufficientFundsException extends Exception
{

}

class Account
{
    String account_number;
    double amount;

    public String getAccount_number() {
        return account_number;
    }

    public void setAccount_number(String account_number) {
        this.account_number = account_number;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void withdraw(double value) throws InsufficientFundsException {
        if(amount-value<0)
            throw new InsufficientFundsException();
        else
        {
            amount-=value;
        }

    }
}

public class ThrowingExceptions
{

    public static void main(String[] args)
    {
        Account account=new Account();
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter the details:");
        System.out.println("Account number:");
        account.account_number=scanner.next();
        System.out.println("Balance:");
        account.amount=scanner.nextDouble();
        System.out.println("Enter withdrawal amount:");
        double value=scanner.nextDouble();
        try {

            account.withdraw(value);

        }catch (InsufficientFundsException e)
        {
            System.out.println("Insufficient Funds");
        }
        System.out.println("Balance:"+account.amount);

    }
}
