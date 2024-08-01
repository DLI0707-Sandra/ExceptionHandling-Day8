package policyapplicationprocess;

import java.util.Scanner;


class InvalidAgeException extends Exception
{

}
class PoorDrivingRecordException extends Exception
{

}
class HealthIssueException extends Exception
{

}

public class PolicyApplication
{
    int age;
    String driving_record;
    String health;

    public void checkAge(int age) throws InvalidAgeException
    {
        if(age<18)
            throw new InvalidAgeException();
    }

    public void checkDrivingHistory(String driving) throws PoorDrivingRecordException {
        if(driving.equals("Poor"))
            throw new PoorDrivingRecordException();
    }

    public void checkHeakthRecord(String health) throws HealthIssueException
    {
        if(health.equals("Critical"))
            throw new HealthIssueException();
    }

    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter the application:");
        System.out.println("Age:");
        PolicyApplication policyApplication=new PolicyApplication();
        policyApplication.age=scanner.nextInt();
        System.out.println("Driving record:");
        policyApplication.driving_record=scanner.next();
        System.out.println("Health record:");
        policyApplication.health=scanner.next();
        try
        {
            policyApplication.checkAge(policyApplication.age);
            policyApplication.checkDrivingHistory(policyApplication.driving_record);
            policyApplication.checkHeakthRecord(policyApplication.health);
            System.out.println("Passed all checks.Policy Approved!");

        }catch (InvalidAgeException e){
            System.out.println("Age should be greater than 18.");
        }
        catch (PoorDrivingRecordException e)
        {
            System.out.println("Policy declined!Poor driving records.");
        }catch (HealthIssueException e)
        {
            System.out.println("Policy declined!Risk factor high!");
        }

    }
}
