/*
Class: CSE 1321L
Section: J07
Term: Fall 2021
Instructor: Maneesha Penmetsa
Name: Raehyeong Lee
Lab#: Assignment7B
 */
import java.util.Scanner;

public class Assignment7B {
    public static String Encrypt(String msg, int a) {

        StringBuilder encryptedMSG = new StringBuilder(msg);

            for (int i = 0; i < encryptedMSG.length(); i++) {
                char ch = encryptedMSG.charAt(i);

                if (ch!=' ') {
                    ch = (char) ((ch - 'A' + a) % 26 + 'A');
                }
                encryptedMSG.setCharAt(i, ch);
            }
            return encryptedMSG.toString();

        }
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int offset;

        System.out.println("Enter your massage:");
        String line = scan.nextLine();
        line = line.toUpperCase();

        System.out.print("Enter your offset value: ");
        offset = scan.nextInt();

        if ((offset > -1 || offset < 27) && (line.matches("[A-Z ]+"))) {
            System.out.println("\nYour secret message is...");
            System.out.println(Encrypt(line, offset));
        } else {
            System.out.println("\nSorry, we can only process messages with letters and spaces, and the offset must be between 0 and 26.");
        }

        while (true) {
            System.out.print("\nDo you want to encrypt another massage?: ");
            String answer = scan.next();

            if (answer.equals("y") || answer.equals("Y")) {
                main(null);
            } else if (answer.equals("n") || answer.equals("N")) {
                System.out.println("\nClosing out...");
            }
            return;
        }
    }
}
