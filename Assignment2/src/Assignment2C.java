/*
Class: CSE 1321L
Section: J07
Term: Fall 2021
Instructor: Maneesha Penmetsa
Name: Raehyeong Lee
Lab#: Assignment2C
 */

import java.util.Scanner;
public class Assignment2C {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int dallarsUS;
        System.out.println("Welcome to Bisonica!");
        System.out.print("How many US Dollars do you have? ");
        dallarsUS = scan.nextInt();

        double pounds = dallarsUS*0.73;
        double dallarsBison = pounds/5;
        System.out.println(dallarsUS+" US Dollar(s) is "+pounds+ " British Pound(s),");
        System.out.println("which is "+dallarsBison+" Bison Dollar(s)!");

    }

}
