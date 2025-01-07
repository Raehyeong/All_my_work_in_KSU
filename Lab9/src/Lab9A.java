/*
Class: CSE 1322L
Section: J04
Term: Spring 2022
Instructor: Yamini Hanisha Talluri
Name: Raehyeong Lee
Lab#: Lab9A
*/

import java.util.Scanner;

public class Lab9A {
    static int rec_mul(int x, int y) {
        if (x < y) {
            return rec_mul(y, x);
        } else if (y != 0) {
            return (x + rec_mul(x, y - 1));
        } else {
            return 0;
        }
    }

    static int rec_div(int x, int y) {
        if (y == 0) {
            return -1;
        }
        if(x<y) {
            return 0;
        }
        return 1 + rec_div(x-y, y);
    }

    static int rec_mod(int x, int y) {
        if (y == 0) {
            return -1;
        }
        if (x >= y) {
            x = rec_mod(x - y, y);
        }
        return x;
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int x;
        int y;
        int choice;

        while(true) {
            System.out.println("Choose from the following: ");
            System.out.println("0. QUit ");
            System.out.println("1. Multiply 2 numbers ");
            System.out.println("2. Div 2 numbers ");
            System.out.println("3. Mod 2 numbers ");
            choice = scan.nextInt();

            if (choice == 0) {
                break;
            }

            if(choice > 0 && choice <= 4) {
                System.out.println("Enter first Number");
                x = scan.nextInt();
                System.out.println("Enter second number");
                y = scan.nextInt();

                if (choice == 1) {
                    System.out.println("Answer: " + rec_mul(x, y));
                }

                else if (choice == 2) {
                    System.out.println("Answer: " + rec_div(x, y));
                }

                else if (choice == 3) {
                    System.out.println("Answer: " + rec_mod(x, y));
                }
            }
        }
    }
}