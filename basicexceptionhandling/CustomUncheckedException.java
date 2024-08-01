package basicexceptionhandling;

import java.util.Scanner;

class NegativeNumberException extends RuntimeException
{
    @Override
    public String getMessage() {
        return "Negative number not permissible!";
    }
}

public class CustomUncheckedException
{
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter an integer:");
        try
        {
            int number=scanner.nextInt();
            if(number<0)
                throw new NegativeNumberException();
            System.out.println("Valid integer!");
        }
        catch (NegativeNumberException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
