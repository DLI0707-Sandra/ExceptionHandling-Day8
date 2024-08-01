package claimprocessingsystem;

import java.util.ArrayList;


public class Policies
{
    ArrayList<Policy> policies=new ArrayList<>();
    public void addPolicy(Policy policy)
    {
        policies.add(policy);
    }

    public void removePolicy(String policyNumber)
    {
        for(int i=0;i<policies.size();i++)
        {
            if(policies.get(i).policynumber.equals(policyNumber))
                policies.remove(i);
        }
    }

    public Policy findPolicy(String policyNumber)
    {
        for(int i=0;i<policies.size();i++)
        {
            if(policies.get(i).policynumber.equals(policyNumber))
                return policies.get(i);
        }
        return null;
    }

    public void viewAll()
    {
        for (int i=0;i<policies.size();i++)
        {
            System.out.println(policies.get(i));
        }
    }

}
