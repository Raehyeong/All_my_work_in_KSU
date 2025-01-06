/*
Class: CSE 1321L
Section: J07
Term: Fall 2021
Instructor: Maneesha Penmetsa
Name: Raehyeong Lee
Lab#: Assignment4C
 */

import java.util.Scanner;
import java.util.Random;

public class Assignment4C {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Random random = new Random();

        int head=0;
        int tail=0;
        int num;
        int result;
        double headper;
        double tailper;

        System.out.print("How many times do you want to flip the coin?: ");
        num = scan.nextInt();
        for(int i = 0; i < num; i++) {
            result = random.nextInt(2);

            if (result == 0) {
                head = head + 1;
            } else {
                tail = tail + 1;
            }
        }
        System.out.println("After flipping the coin "+num+" time(s), we found that it lands on:");


        headper= (double)head/(double)num;
        tailper= (double)tail/(double)num;

        System.out.println("Heads – "+head+" times ("+headper+"%)");
        System.out.println("Tails – "+tail+" times ("+tailper+"%)");

        if(head>tail) {
            System.out.println("The coin lands on heads more often than tails!");
        } else if(tail>head) {
            System.out.println("The coin lands on tails more often than heads!");
        } else {
            System.out.println("The coin is perfectly fair!");
        }
    }
}