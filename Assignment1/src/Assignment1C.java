/*
Class: CSE 1321L
Section: J07
Term: Fall 2021
Instructor: Maneesha Penmetsa
Name: Raehyeong Lee
Lab#: Assignment1C
 */


import java.util.Scanner;

public class Assignment1C {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String street;
        String color;
        String food;

        System.out.print("Enter the name of the street you live on: ");
        street = sc.nextLine();
        System.out.print("Enter the name of the your favorite color: ");
        color = sc.nextLine();
        System.out.print("Enter the name of the favorite food: ");
        food = sc.nextLine();
        System.out.println("Your Stage name is: "+ food + " " + color + " " + street + "!");

    }
}