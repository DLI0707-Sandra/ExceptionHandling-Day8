package basicexceptionhandling;

import java.util.Scanner;

public class ExceptionHierarchy
{
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter an integer:");
        try
        {
            int divisor=scanner.nextInt();
            int result=100/divisor;
            System.out.println("100/"+divisor+"="+result);
            String string=null;
            System.out.println(string.length());
        }catch (NullPointerException e)
        {
            e.printStackTrace();
        }catch (ArithmeticException e)
        {
            System.out.println("Division by zero!");
        }
        catch (Exception e)
        {
            e.getMessage();
        }

    }
}
