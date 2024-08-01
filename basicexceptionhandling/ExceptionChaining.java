package basicexceptionhandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ExceptionChaining
{
    public static void ioExceptionMethod(String filename) throws IOException
    {
        System.out.println("Trying to open"+filename);
        BufferedReader reader=new BufferedReader(new FileReader(filename));
    }
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter the file name:");
        String filename=scanner.next();
        try
        {
            ioExceptionMethod(filename);
        }catch (IOException e)
        {
            System.out.println("File not found.");
            System.out.println("The exception is:"+e);
            System.out.println("Exception thrown by method handled in main!");
        }
    }
}
