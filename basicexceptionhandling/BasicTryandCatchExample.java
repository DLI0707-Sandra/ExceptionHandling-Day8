package basicexceptionhandling;

import java.util.Scanner;

public class BasicTryandCatchExample
{
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter the divisor:");
        int divisor=scanner.nextInt();
        int quotient=0;
        try
        {
            quotient=100/divisor;
        }catch (ArithmeticException arithmeticException)
        {
            System.out.println("Divisor cannot be zero!");
        }
        if(quotient!=0)
            System.out.println("100/"+divisor+"="+quotient);
    }
}
