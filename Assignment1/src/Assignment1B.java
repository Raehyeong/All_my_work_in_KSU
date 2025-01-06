/*
Class: CSE 1321L
Section: J07
Term: Fall 2021
Instructor: Maneesha Penmetsa
Name: Raehyeong Lee
Lab#: Assignment1B
 */
import java.util.Scanner;

public class Assignment1B {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int weekly_sub;
        int customer_num;

        System.out.print("Enter the weekly subscription fee: ");
        weekly_sub = sc.nextInt();

        System.out.print("Enter the number of customer: ");
        customer_num = sc.nextInt();

        int week_earn = weekly_sub*customer_num;
        int year_earn = week_earn*52;

        System.out.println("This company makes $" + week_earn + " each week");
        System.out.println("This company makes $" + year_earn + " each year");


    }
}