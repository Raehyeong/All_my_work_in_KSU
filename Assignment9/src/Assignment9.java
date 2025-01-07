/*
Class: CSE 1322L
Section: J04
Term: Spring 2022
Instructor: Yamini Hanisha Talluri
Name: Raehyeong Lee
Lab #: Assignment9
*/

import java.util.Scanner;
class Bank_Account {
    private String Name;
    private int AccountID;
    private static int NumAccount = 0;
    private String UserID;
    private String UserPassword;
    private double AccountBalance;

    public Bank_Account(String name, String userID, String userPassword) {
        Name = name;
        UserID = userID;
        UserPassword = userPassword;
        AccountID = NumAccount++;
    }
    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }
    public String getUserID1() {
        return UserID;
    }
    public void setUserID(String userID) {
        UserID = userID;
    }
    public String getUserPassword() {
        return UserPassword;
    }
    public void setUserPassword(String userPassword) {
        UserPassword = userPassword;
    }
    public double getAccountBalance1() {
        return AccountBalance;
    }
    public void setAccountBalance(double accountBalance) {
        AccountBalance = accountBalance;
    }
    public int getAccountID() {
        return AccountID;
    }
    public static int getNumAccount() {
        return NumAccount;
    }
    public static void decrementNumAccount() {
        NumAccount--;
    }
}

class InvalidPasswordFormatException extends Exception {
    public InvalidPasswordFormatException(String message) {
        super(message);
    }
}
class NegativeDollarAmountException extends Exception {
    public NegativeDollarAmountException(String message) {
        super(message);
    }
}
class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}
class CustomerAccountNotFoundException extends Exception {
    public CustomerAccountNotFoundException(String message) {
        super(message);
    }
}

public class Assignment9 {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        int n = 0;
        int dollar = 0;
        String password = "";
        String id = "";

        while (n != 6) {
            System.out.println("1 - Create An Account\n2 - Delete An Account\n3 - Make An Account Deposit\n4 - Make An Account Withdrawal\n5 - Check An Account Balance\n6 - Exit");
            System.out.print("Enter Choice: ");
            n = scan.nextInt();
            try {
                switch (n) {
                    case 1:
                        if (password.length() < 8 || !password.contains("*"))
                            throw new InvalidPasswordFormatException("Invalid password format. Password must be at least 8 characters long and must contain at least one asterisk(*) character");
                        break;
                    case 2:
                        if (id == "do not exist") {
                            throw new CustomerAccountNotFoundException("Customer not found");
                        }
                        break;
                    case 3:
                        if (id == "do not exist") {
                            throw new CustomerAccountNotFoundException("Customer not found");
                        }
                        if (dollar < 0) {
                            throw new NegativeDollarAmountException("Dollar amount cannot be negative");
                        }
                        break;
                    case 4:
                        if (id == "do not exist") {
                            throw new CustomerAccountNotFoundException("Customer not found");
                        }
                        if (dollar < 0) {
                            throw new NegativeDollarAmountException("Dollar amount cannot be negative");
                        }
                        int balance = 0;
                        if (dollar > balance) {
                            throw new InsufficientFundsException("Withdrawal amount is greater than the account balance");
                        }
                        break;
                    case 5:
                        if (id == "do not exist") {
                            throw new CustomerAccountNotFoundException("Customer not found");
                        }
                        break;
                    case 6:
                        break;
                }

            } catch (InvalidPasswordFormatException ex) {
                System.out.println(ex.getMessage());
            } catch (NegativeDollarAmountException ex) {
                System.out.println(ex.getMessage());
            } catch (InsufficientFundsException ex) {
                System.out.println(ex.getMessage());
            } catch (CustomerAccountNotFoundException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
