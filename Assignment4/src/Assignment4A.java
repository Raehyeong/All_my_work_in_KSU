import java.util.Random;
import java.util.Scanner;

public class Assignment4A {
    public static void main(String[] args) {

        Random random = new Random();
        Scanner scan = new Scanner(System.in);

        int uscore = 0;
        int cscore = 0;
        int dice1;
        int dice2;
        int round;
        int score;
        char end = 'Y';
        char stop = 'N';

        do {
            System.out.println("Let’s play Bunco!");

            for (round = 1; round < 7; round++) {

                dice1 = random.nextInt(10)%6+1;
                dice2 = random.nextInt(10)%6+1;

                if(dice1 == dice2) {
                    if(dice1 == round) {
                        score = (21 + dice1 + dice2);
                    }
                    else {
                        score =  (5 + dice1 + dice2);
                    }
                }
                else if(dice1 == round || dice2 == round) {
                    score = (1 + dice1 + dice2);
                }
                else {
                    score = (dice1 + dice2);
                }
                System.out.print("Round " + (round) + ": ");

                System.out.println("You rolled " + dice1 + " and " + dice2 + ".");
                uscore = score;


                if(round != 6)
                    System.out.print("Your score is " + uscore + ". Do you want to stop?: ");
                else
                    System.out.println("Your score is " + uscore + ". You’ve played all six rounds ");

                if(round != 6) {
                    stop = scan.nextLine().charAt(0);
                    if(stop == 'Y') {
                        break;
                    }
                }

                dice1 = random.nextInt(10)%6 + 1;
                dice2 = random.nextInt(10)%6 + 1;
                if(dice1 == dice2) {
                    if(dice1 == round) {
                        score = (21 + dice1 + dice2);
                    }
                    else {
                        score =  (5 + dice1 + dice2);
                    }
                }
                else if(dice1 == round || dice2 == round) {
                    score = (1 + dice1 + dice2);
                }
                else {
                    score = (dice1 + dice2);
                }
                cscore = score;
            }

            System.out.println("\nOkay, the computer’s score is... " + cscore + "!");

            if(uscore > cscore) {
                System.out.println("You win!");
            } else {
                System.out.println("Sorry, you lose.");
            }

            System.out.println();
            System.out.print("Do you want to play again?: ");
            end = scan.nextLine().charAt(0);


        }while (end == 'Y');
        System.out.println("Game Over...");
    }

}