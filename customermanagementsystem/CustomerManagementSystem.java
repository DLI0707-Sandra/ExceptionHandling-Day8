package customermanagementsystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class CustomerNotFoundException extends Exception
{

}

class InvalidCustomerDataException extends RuntimeException
{

}

public class CustomerManagementSystem
{

    public static void main(String[] args)
    {
        Customers customers=new Customers();
        Scanner scanner=new Scanner(System.in);
        int choice;
        do {
            System.out.println("1.Add Customer\n2.Update Details\n3.Remove Customer\n4.Display all\n5.Exit");
            choice=scanner.nextInt();
            switch (choice)
            {
                case 1:
                    Customer customer=new Customer();
                    System.out.println("Enter the details:");
                    System.out.println("Customer ID:");
                    customer.setId(scanner.next());
                    System.out.println("Name:");
                    customer.setName(scanner.next());
                    System.out.println("Age:");
                    customer.setAge(scanner.nextInt());
                    try{
                        customers.addCustomer(customer);
                    }
                    catch (InvalidCustomerDataException e)
                    {
                        System.out.println("Age should be 18 or more!");
                    }
                    break;
                case 2:boolean found=true;
                    Customer customer1=new Customer();
                    System.out.println("Enter Customer ID:");
                    String id=scanner.next();
                    try {
                        customer1 = customers.getByID(id);
                    }catch (CustomerNotFoundException e)
                    {
                        found=false;
                        System.out.println("Customer not found!Check given id!");
                    }
                    if(found)
                    {
                        System.out.println("Enter the field to be updated:");
                        String option=scanner.next();
                        switch (option)
                        {
                            case "Id":
                                System.out.println("Enter new Id:");
                                customer1.setId(scanner.next());
                                break;
                            case "Name":
                                System.out.println("Enter new name:");
                                customer1.setName(scanner.next());
                                break;
                            case "Age":System.out.println("Enter new age:");
                                customer1.setAge(scanner.nextInt());
                                break;
                        }
                        System.out.println("Updated successfully!");
                    }
                    break;
                case 3:System.out.println("Enter Customer ID:");
                    String Id=scanner.next();
                    try {
                        customers.removeCustomer(Id);
                    }catch (CustomerNotFoundException e){
                        System.out.println("Customer not found!");
                    }
                    break;
                case 4:customers.displayAll();
                    break;
                case 5:
                    System.out.println("Exiting!");
                    break;
            }

        }while (choice!=5);
    }
}
