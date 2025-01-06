/*
Class: CSE 1321L
Section: J07
Term: Fall 2021
Instructor: Maneesha Penmetsa
Name: Raehyeong Lee
Lab#: Assignment1A
 */
import java.util.Scanner;

public class Assignment1A {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a red value (0-255): ");
        double red = sc.nextInt();

        System.out.print("Enter a green value (0-255): ");
        double green = sc.nextInt();

        System.out.print("Enter a blue value (0-255): ");
        double blue = sc.nextInt();

        System.out.print("Enter an alpha value (0-100): ");
        float alpha = sc.nextInt();

        System.out.print("New color is ");
        System.out.printf("red=%.3f", red/ 255.0);
        System.out.printf(", green=%.3f", green/ 255.0);
        System.out.printf(", blue=%.3f", blue/ 255.0);
        System.out.printf(", alpha=%.2f", alpha/ 100.0);

    }
}
