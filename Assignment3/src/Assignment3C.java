/*
Class: CSE 1321L
Section: J07
Term: Fall 2021
Instructor: Maneesha Penmetsa
Name: Raehyeong Lee
Lab#: Assignment3C
 */
import java.util.Scanner;

public class Assignment3C {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String option;
        double due;

        System.out.println("[KSU Club Suggestions]");
        System.out.print("Do you want an indoor or outdoor club?: ");
        option = scan.next();

        if (option.equals("Indoor") || option.equals("Outdoor")) {
            System.out.print("How much are you willing to pay in dues?: ");
            due = scan.nextDouble();

            if(option.equals("Indoor") && due<=5){
                System.out.println("You could join the Chess club!");
            }else if(option.equals("Indoor") && due>5){
                System.out.println("You could join the Virtual Reality club!");
            }else if(option.equals("Outdoor") && due<=5){
                System.out.println("You could join the Running club!");
            }else if(option.equals("Outdoor") && due>5){
                System.out.println("You could join the Medieval Combat Sports club!");
            }else {
                System.out.println("Sorry, that's not a valid option.");
            }
        } else {
            System.out.println("Sorry, that's not a valid option.");
        }
    }
}
