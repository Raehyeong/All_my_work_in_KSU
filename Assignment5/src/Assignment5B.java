/*
Class: CSE 1321L
Section: J07
Term: Fall 2021
Instructor: Maneesha Penmetsa
Name: Raehyeong Lee
Lab#: Assignment5B
 */

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Assignment5B {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        System.out.print("How many games do you want to play?: ");
        int round = sc.nextInt();

        ArrayList<String> computer = new ArrayList<String>();
        String[] comArray = {"ROCK", "PAPER", "SCISSORS"};

        for(int i = 1;i <= round; i++) {
            System.out.print("Round " + i + " what do you want to throw?: ");
            String player = sc.next();
            player = player.toLowerCase();

            int random = rand.nextInt(3) + 0;
            String comAnswer = comArray[random].toLowerCase();

            System.out.println("Computer threw " + comAnswer + "!");

            if (player.equals(comAnswer)) {
                computer.add("Round " + i + " tie");
            } else if (player.equals("rock")) {
                if(comAnswer.equals("paper")) {
                    computer.add("Computer won Round " + i);
                } else {
                    computer.add("Player won Round " + i);
                }
            } else if(player.equals("paper")) {
                if(comAnswer.equals("scissors")) {
                    computer.add("Computer won Round " + i);
                } else {
                    computer.add("Player won Round " + i);
                }
            } else {
                if(comAnswer.equals("rock")) {
                    computer.add("Computer won Round " + i);
                } else {
                    computer.add("Player won Round " + i);
                }
            }
        }

        System.out.println("Game Over....");
        System.out.println("\nHere's the recap:");
        for(String recap : computer) {
            System.out.println(recap);
        }
    }
}