package claimprocessingsystem;

import java.time.LocalDate;
import java.util.Scanner;

class FraudulentClaimException extends Exception
{

}

class InvalidClaimAmountException extends Exception
{

}

public class ClaimProcessingSystem
{

    public static void processClaim(Policy policy,long claim) throws FraudulentClaimException,InvalidClaimAmountException
    {
        LocalDate thirtyDaysfromStart=policy.start_date.plusDays(30);
        if(LocalDate.now().isBefore(thirtyDaysfromStart))
            throw new FraudulentClaimException();
        if(claim>policy.amount)
            throw new InvalidClaimAmountException();
        System.out.println("Claim processed!");
    }
    public static void main(String[] args)
    {
        Policies policies=new Policies();
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("1.Add new policy\n2.Claim policy\n3.Exit");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter policy details:");
                    System.out.println("Policy number:");
                    String policyNumber = scanner.next();
                    System.out.println("Policy holder name:");
                    scanner.nextLine();
                    String policyHolder = scanner.nextLine();
                    System.out.println("Type:");
                    String policyType = scanner.next();
                    System.out.println("Expiry date(yyyy-mm-dd):");
                    scanner.nextLine();
                    String date=scanner.nextLine();
                    LocalDate expiry_date= LocalDate.parse(date);
                    System.out.println("Coverage:");
                    long policyCoverage = scanner.nextLong();
                    System.out.println("Start Date(yyyy-mm-dd):");
                    LocalDate start_date=LocalDate.parse(scanner.next());
                    Policy policy = new Policy(policyNumber, policyHolder, policyType,expiry_date, policyCoverage,start_date);
                    policies.addPolicy(policy);
                    break;
                case 2:
                    System.out.println("Enter thr policy number :");
                    String policynumber = scanner.next();
                    System.out.println("Enter the amount:");
                    long claim=scanner.nextInt();
                    Policy policy1=policies.findPolicy(policynumber);
                    try
                    {
                        processClaim(policy1,claim);
                    }catch (FraudulentClaimException e)
                    {
                        System.out.println("Amount can be claimed only after 30 days from start date!");
                    }catch (InvalidClaimAmountException e)
                    {
                        System.out.println("Invalid claim amount!");
                    }
                    break;
                case 3:
                    System.out.println("Exiting!");
                    break;

            }

        } while (choice != 3);

    }
}
