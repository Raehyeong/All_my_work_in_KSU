/*
Class: CSE 1321L
Section: J07
Term: Fall 2021
Instructor: Maneesha Penmetsa
Name: Raehyeong Lee
Lab#: Assignment4B
 */

import java.util.Scanner;

public class Assignment4B {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int num;
        int space;

        System.out.print("Enter the diamond's width: ");
        num = scan.nextInt();

        while(num < 3) {
            System.out.println("Please enter a width of at least 3.");
            System.out.print("Enter the diamond's width: ");
            num = scan.nextInt();
        }

        if(num % 2 == 0) {
            num++;
            System.out.println("To make a diamond, we’ll use " + num +" as the width instead.");
        }

        space = (num-1)/2;

        for (int i = 0; i < num; i+=2){
            for (int j = 0; j < space; j++) {
                System.out.print(" ");
            }

            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }
            System.out.print("\n");
            space--;
        }

        space = 1;

        for (int i = num-2; i > 0; i--,i--) {
            for (int j = 0; j < space; j++) {
                System.out.print(" ");
            }

            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.print("\n");
            space++;
        }
    }
}
