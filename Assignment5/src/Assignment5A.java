/*
Class: CSE 1321L
Section: J07
Term: Fall 2021
Instructor: Maneesha Penmetsa
Name: Raehyeong Lee
Lab#: Assignment5A
 */

import java.util.Scanner;

public class Assignment5A {
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        System.out.print("What's the highest number you want to generate?: ");
        int highest = scn.nextInt();

        System.out.print("How long of a number sequence do you want to generate?: ");
        int lengthSequence = scn.nextInt();

        System.out.println("Okay, we'll generate 10 number(s) ranging from 1 to 5!");
        int arr[] = new int[lengthSequence];

        for(int i=0;i<lengthSequence;i++) {
            arr[i] = (int)(Math.random() * ((highest - 1) + 1)) + 1;
            System.out.print(arr[i] + ", ");
        }

        System.out.println("\nFrequency:");

        for(int i=1;i<=highest;i++) {
            int count = 0;
            for(int j=0;j<lengthSequence;j++) {
                if(i == arr[j]) {
                    count++;
                }
            }

            double countPercentage = (count/(lengthSequence*1.0))*100;

            System.out.printf("%d occurs %.2f %% of the time\n",i,countPercentage);
        }
    }
}

