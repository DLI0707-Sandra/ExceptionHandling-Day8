package basicexceptionhandling;

import java.util.Scanner;

class InvalidAgeException extends Exception
{
    @Override
    public String getMessage() {
        return "Age should be 18 or more";
    }
}
public class CustomCheckedException
{
    public static void validateAge(int age) throws InvalidAgeException
    {
        if(age<18)
            throw new InvalidAgeException();

    }

    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter age:");
        int age=scanner.nextInt();
        try
        {
            validateAge(age);
            System.out.println("Welcome!");
        }
        catch (InvalidAgeException e)
        {
            System.out.println(e.getMessage());
        }

    }
}
