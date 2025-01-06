/*
Class: CSE 1321L
Section: J07
Term: Fall 2021
Instructor: Maneesha Penmetsa
Name: Raehyeong Lee
Lab#: Assignment3A
 */

import java.util.Scanner;

public class Assignment3A {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String decision;
        int dolls;
        double cost = 2;
        double discounted;

        System.out.println("Welcome to the KSU Bookstore!");
        System.out.print("Do you want to purchase Scrappy dolls?: ");
        decision = scan.nextLine();

        if (decision.equals("No")) {
            System.out.println("Have a nice day!");
        } else if (decision.equals("Yes")) {
            System.out.print("How many Scrappy dolls do you want to buy?: ");
            dolls = scan.nextInt();
            if (dolls == 0) {
                System.out.println("Have a nice day!");
            } else if (dolls > 5) {
                discounted = (dolls * cost) - (dolls * cost * 0.1);
                System.out.println("You earned a 10% discount for buying in bulk!");
                System.out.println(dolls + " Scrappy dolls cost $" + discounted + ". Thank you!");
                System.out.println("Have a nice day!");
            } else if (dolls <= 5) {
                System.out.println(dolls + " Scrappy dolls cost $" + (dolls * cost) + ". Thank you!");
                System.out.println("Have a nice day!");
            }
        }
    }
}