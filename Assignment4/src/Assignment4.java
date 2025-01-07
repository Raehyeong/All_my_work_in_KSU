/*
Class: CSE 1322L
Section: J04
Term: Spring 2022
Instructor: Yamini Hanisha Talluri
Name: Raehyeong Lee
Lab#: Assignment4
*/

import java.util.ArrayList;
import java.util.Scanner;

class Loan {
    private String customerName;
    private int accountNumber;
    private double loanBalance;
    private double monthlyPayment;
    private double interestRate;
    private int numberOfMonthlyPayments;
    private static int numberOfLoans = 0;

    public Loan(String name, double amount, double rate,int months) {
        this.customerName = name;
        this.loanBalance = amount;
        this.interestRate = rate;
        this.numberOfMonthlyPayments = months;
        this.accountNumber = ++numberOfLoans;
    }

    public static int getNumberOfLoans() {
        return numberOfLoans;
    }
    public String getCustomerName() {
        return customerName;
    }
    public int getAccountNumber() {
        return accountNumber;
    }
    public double getLoanBalance() {
        return loanBalance;
    }
    public double getMonthlyPayment() {
        return monthlyPayment;
    }
    public double getInterestRate() {
        return interestRate;
    }
    public int getNumberOfMonthlyPayments() {
        return numberOfMonthlyPayments;
    }


    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }
    public void setLoanBalance(double loanBalance) {
        this.loanBalance = loanBalance;
    }
    public void setMonthlyPayment(double monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }
    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }
    public void setNumberOfMonthlyPayments(int numberOfMonthlyPayments) {
        this.numberOfMonthlyPayments = numberOfMonthlyPayments;
    }


    public static void decreaseNumberOfLoans() {
        numberOfLoans--;
    }
    public void calculateMonthlyPayment() {
        double r = this.interestRate;
        double pv = this.loanBalance;
        double n = this.numberOfMonthlyPayments;
        double temp = Math.pow((1+r), -n);
        this.monthlyPayment = (r*pv)/(1-temp);
    }

    @Override
    public String toString() {
        return "Customer Name: " + customerName + ", Account Number: " + accountNumber + ", Loan Balance: "
                + loanBalance + ", Monthly Payment: " + monthlyPayment + ", Interest Rate: " + interestRate
                + ", Number Of Monthly Payments: " + numberOfMonthlyPayments;
    }
}
class StudentLoan extends Loan {

    private boolean isDeferred;
    public StudentLoan(String name, double amount, double rate, int months, boolean isDef) {
        super(name, amount, rate, months);
        this.isDeferred = isDef;
    }

    public boolean isDeferred() {
        return isDeferred;
    }
    public void setDeferred(boolean isDeferred) {
        this.isDeferred = isDeferred;
    }
    @Override
    public void calculateMonthlyPayment() {
        if(this.isDeferred) {
            this.setMonthlyPayment(0);
        } else {
            super.calculateMonthlyPayment();
        }
    }

    @Override
    public String toString() {
        return super.toString()+" Is Deferred = " + isDeferred;
    }
}

class AutoLoan extends Loan {

    private double downPayment;
    public AutoLoan(String name, double amount, double rate, int months, double down) {
        super(name, amount, rate, months);
        this.downPayment = down;
    }

    public double getDownPayment() {
        return downPayment;
    }
    public void setDownPayment(double downPayment) {
        this.downPayment = downPayment;
    }

    @Override
    public void calculateMonthlyPayment() {
        double r = this.getInterestRate();
        double pv = this.getLoanBalance() - this.downPayment;
        double n = this.getNumberOfMonthlyPayments();
        double temp = Math.pow((1+r), -n);
        this.setMonthlyPayment((r*pv)/(1-temp));
    }

    @Override
    public String toString() {
        return super.toString()+ "Enter Amount of Down Payment: " + downPayment;
    }
}

public class Assignment4 {
    public void addLoan(ArrayList<Loan> list) {

        int loanType;
        String customerName;
        double loanBalance;
        double interestRate;
        int numberOfMonthlyPayments;
        boolean isDeferred;

        Scanner scan = new Scanner(System.in);

        System.out.println("\nEnter Loan Type (1 – Student, 2 – Auto): ");
        loanType = scan.nextInt();
        scan.nextLine();
        System.out.println("Enter Customer Name: ");
        customerName = scan.nextLine();
        System.out.println("Enter Loan Amount: ");
        loanBalance = scan.nextDouble();
        System.out.println("Enter Interest Rate: ");
        interestRate = scan.nextDouble();
        System.out.println("Enter Number Of Monthly Payments: ");
        numberOfMonthlyPayments = scan.nextInt();

        if(loanType == 1) {
            scan.nextLine();
            System.out.println("Is Loan Deferred? (Y/N): ");
            String isDef = scan.nextLine();
            if(isDef.equalsIgnoreCase("Y")) {
                isDeferred = true;
            } else {
                isDeferred = false;
            }
            StudentLoan sl = new StudentLoan(customerName, loanBalance, interestRate, numberOfMonthlyPayments, isDeferred);
            list.add(sl);
        }
        else if(loanType == 2) {
            System.out.println("Enter Down Payment: ");
            double down = scan.nextDouble();

            AutoLoan al = new AutoLoan(customerName, loanBalance, interestRate, numberOfMonthlyPayments, down);
            list.add(al);
        }
    }

    public void deleteLoan(ArrayList<Loan> list) {

        String name;

        Scanner scan = new Scanner(System.in);

        System.out.println("Enter Customer Name: ");
        name = scan.nextLine();
        for(int i=0; i<list.size(); i++) {
            if(list.get(i).getCustomerName().equalsIgnoreCase(name)) {
                list.remove(i);
                Loan.decreaseNumberOfLoans();
            }
        }
    }

    public void calculateMonthlyLoanPayment(ArrayList<Loan> list) {
        for(int i=0; i<list.size(); i++) {
            list.get(i).calculateMonthlyPayment();
        }
    }

    public void printLoans(ArrayList<Loan> list) {
        for(int i=0; i<list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        Assignment4 d = new Assignment4();
        ArrayList<Loan> loans = new ArrayList<Loan>();
        int choice = 0;
        do {
            System.out.println("\n1 – Add Loan \n2 - Delete Loan \n3 - Calculate Monthly Payments \n4 - Print Loans \n5 - Exit\n");       //display the menu
            System.out.print("Enter Choice: ");
            choice = scan.nextInt();
            if(choice == 1) {
                d.addLoan(loans);
            }
            else if(choice == 2) {
                d.deleteLoan(loans);
            }
            else if(choice == 3) {
                d.calculateMonthlyLoanPayment(loans);
            }
            else if(choice == 4) {
                d.printLoans(loans);
            }
            else if(choice == 5) {
                return ;
            }
            else
                System.out.println("Error: Please Enter Valid Input");
        } while(choice != 5);
    }
}