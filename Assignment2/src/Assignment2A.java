
/*
Class: CSE 1321L
Section: J07
Term: Fall 2021
Instructor: Maneesha Penmetsa
Name: Raehyeong Lee
Lab#: Assignment2A
 */

import java.util.Scanner;

public class Assignment2A {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int second;

        System.out.print("How much time has passed (in seconds)?: ");
        second = scan.nextInt();

        int totalsec = second;
        int minute = second / 60;
        second = second % 60;
        int hour = second / 3600;
        second = second % 3600;

        System.out.println("Now Converting...");
        System.out.println(totalsec + " seconds is " + hour + " hour(s), " + minute + " minute(s), and " + second + " second(s).");
    }
}
