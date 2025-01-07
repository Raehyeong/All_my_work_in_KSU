
/*
Class: CSE 1322L
Section: J04
Term: Spring 2022
Instructor: Yamini Hanisha Talluri
Name: Raehyeong Lee
Lab#: Lab4
*/
import java.util.Scanner;

class Account {

    private int Account_No;
    private double balance;

    Account(){
        Account_No = 10001;
        this.setBalance(0);
    }
    Account(int accountNo,double balance){
        Account_No = accountNo;
        this.setBalance(balance);
    }

    public int getAccount_No() {
        return Account_No;
    }
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }


    public void withdraw(double amount) {
        setBalance(getBalance()-amount);
    }
    public void deposit(double amount) {
        setBalance(getBalance()+amount);
    }
}

class Checking extends Account {
    Checking(){
        super();
    }

    Checking(int accountNo, double bal){
        super(accountNo,bal);
    }

    @Override
    public void withdraw(double amount) {
        double netBalance = getBalance()-amount;
        if(netBalance < 0) {
            System.out.println("Charging an overdraft of $20 because account is below $0.");
            netBalance = netBalance-20;
            setBalance(netBalance);
        } else {
            setBalance(netBalance);
        }
    }
}

class Savings extends Account{
    public int deposits = 0;

    Savings(){
        super(10002, 0);
    }

    Savings(int accountNo, double bal){
        super(accountNo,bal);
    }

    @Override
    public void withdraw(double amount) {
        double netBalance = getBalance()-amount;

        if(netBalance < 500) {
            System.out.println("Charging a fee of $10 because you are below $500.");
            netBalance = netBalance-10;
            setBalance(netBalance);
        } else {
            setBalance(netBalance);
        }
    }

    @Override
    public void deposit(double amount) {
        double netBalance = getBalance()+amount;

        deposits++;
        System.out.println("This is deposit " + deposits + " to this account.");

        if(deposits > 5) {
            System.out.println("Charging a fee of $10.");
            netBalance = netBalance-10;
            setBalance(netBalance);
        } else {
            setBalance(netBalance);
        }
    }

    public void interest() {
        double yearInt = (getBalance()*1.5)/100;
        System.out.println("Customer earned " + yearInt + " in interest.");

        setBalance(yearInt + getBalance());
    }
}

public class Lab4 {
    public static void main(String[] args) {

        Checking chekingAcc = new Checking();
        Savings savingAcc = new Savings();

        Scanner scan = new Scanner(System.in);

        int choice;

        do {
            System.out.println("1. Withdraw from Checking");
            System.out.println("2. Withdraw from Savings");
            System.out.println("3. Deposit to Checking");
            System.out.println("4. Deposit to Savings");
            System.out.println("5. Balance of Checking");
            System.out.println("6. Balance of Savings");
            System.out.println("7. Award Interest to Savings now");
            System.out.println("8. Quit");
            choice = scan.nextInt();
            switch(choice) {

                case 1:
                    System.out.println("How much would you like to withdraw from Checking?");
                    double amount_1 = scan.nextDouble();
                    chekingAcc.withdraw(amount_1);
                    break;

                case 2:
                    System.out.println("How much would you like to withdraw from Savings?");
                    double amount_2 = scan.nextDouble();
                    savingAcc.withdraw(amount_2);
                    break;

                case 3:
                    System.out.println("How much would you like to deposit into Checking?");
                    double amount1 = scan.nextDouble();
                    System.out.println("Doing default deposit");
                    chekingAcc.deposit(amount1);
                    break;

                case 4:
                    System.out.println("How much would you like to deposit into Savings?");
                    double amount2 = scan.nextDouble();
                    savingAcc.deposit(amount2);
                    break;

                case 5:
                    System.out.println("Your balance for checking " + chekingAcc.getAccount_No() + " is " + chekingAcc.getBalance());
                    break;

                case 6:
                    System.out.println("Your balance for savings " + savingAcc.getAccount_No() + " is " + savingAcc.getBalance());
                    break;

                case 7:
                    savingAcc.interest();
                    break;

                case 8:
                    System.out.println();
                    break;

                default:
                    System.out.println(" You entered a wrong choice!.");
            }
        }while(choice!=8);
    }
}