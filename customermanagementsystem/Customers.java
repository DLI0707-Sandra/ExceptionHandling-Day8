package customermanagementsystem;

import java.util.ArrayList;
import java.util.List;

public class Customers
{
    List<Customer> customers=new ArrayList<>();

    public void addCustomer(Customer customer) throws InvalidCustomerDataException
    {
        if(customer.age<18)
            throw new InvalidCustomerDataException();
        customers.add(customer);
    }

    public Customer getByID(String Id) throws CustomerNotFoundException
    {
        Customer customer1=null;
        for(Customer customer:customers)
        {
            if(customer.id.equals(Id))
            {
                customer1=customer;
            }
        }
        if(customer1==null)
            throw new CustomerNotFoundException();
        return customer1;
    }

    public void removeCustomer(String id) throws CustomerNotFoundException
    {
        boolean removed=false;
        for(Customer customer:customers)
        {
            if(customer.id.equals(id))
            {
                customers.remove(customer);
                removed=true;
            }
        }
        if(!removed)
            throw new CustomerNotFoundException();
    }

    public void displayAll()
    {
        for(Customer customer:customers)
        {
            System.out.println(customer);
        }
    }
}
