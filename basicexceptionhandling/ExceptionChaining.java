package basicexceptionhandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

class FileException extends Exception
{
    FileException(String message)
    {
        super(message);
    }
}

public class ExceptionChaining
{
    public static void ioExceptionMethod(String filename) throws FileException
    {
        System.out.println("Trying to open "+filename);
        try
        {
            BufferedReader reader=new BufferedReader(new FileReader(filename));
        }catch (IOException e)
        {
            FileException fileException=new FileException("File not found.");
            fileException.initCause(new IOException());
            throw fileException;
        }

    }
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter the file name:");
        String filename=scanner.next();
        try
        {
            ioExceptionMethod(filename);
        }catch (FileException e)
        {
            System.out.println(e.getMessage());
            System.out.println("Cause:"+e.getCause());
            System.out.println("Exception thrown by method handled in main!");
        }
    }
}
