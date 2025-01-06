/*
Class: CSE 1321L
Section: J07
Term: Fall 2021
Instructor: Maneesha Penmetsa
Name: Raehyeong Lee
Lab#: Assignment2B
 */

import java.util.Scanner;

public class Assignment2B {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int x_cord;
        int y_cord;
        int width;
        int height;

        System.out.print("Enter the hit box top-left X coordinate: ");
        x_cord = scan.nextInt();
        System.out.print("Enter the hit box top-left Y coordinate: ");
        y_cord = scan.nextInt();
        System.out.print("Enter the width of the hit box: ");
        width = scan.nextInt();
        System.out.print("Enter the height of the hit box: ");
        height = scan.nextInt();


        System.out.println("[Hit Box Coordinates]");
        System.out.println("Top-Left: "+ x_cord +", "+ y_cord);
        System.out.println("Bottom-Left: "+x_cord +", "+ (y_cord-height));
        System.out.println("Top-Right: "+ (x_cord+width) +", "+ y_cord);
        System.out.println("Bottom-Left: "+ (x_cord+width) +", "+ (y_cord-height));

    }
}
