package basicexceptionhandling;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MultipleCatch
{
    public static void main(String[] args)
    {
        String number1;
        String number2;
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter the first number:");
        number1=scanner.next();
        System.out.println("Enter the second number:");
        number2=scanner.next();
        int result=0;
        try
        {
            result=Integer.parseInt(number1)/Integer.parseInt(number2);

        }catch (ArithmeticException e)
        {
            System.out.println("Division by zero not possible.Make second number greater than 0");
        }
        catch (NumberFormatException | InputMismatchException e)
        {
            System.out.println("Input should be integer");
        }

        if(result!=0)
            System.out.println("Result:"+result);

    }
}
