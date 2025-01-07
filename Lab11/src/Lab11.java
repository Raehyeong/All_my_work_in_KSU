
/*
Class: CSE 1322L
Section: J04
Term: Spring 2022
Instructor: Yamini Hanisha Talluri
Name: Raehyeong Lee
Lab #: Lab11
*/

import java.util.Scanner;
import java.io.*;

public class Lab11 {
    public static void main(String[] args) {
        File fileA = new File("fileA.txt");
        File fileB = new File("fileB.txt");

        int lineNumber = 1;

        try {
            Scanner scanA = new Scanner(fileA);
            Scanner scanB = new Scanner(fileB);

            String line1;
            String line2;

            while (scanA.hasNextLine() && scanB.hasNextLine()) {
                line1 = scanA.nextLine();
                line2 = scanB.nextLine();

                if (!line1.equals(line2)) {
                    System.out.println("Line " + lineNumber);
                    System.out.println("< " + line1);
                    System.out.println("> " + line2);
                }
                lineNumber++;
            }

            if ((scanA.hasNextLine() && !scanB.hasNextLine()) || (!scanA.hasNextLine() && scanB.hasNextLine())) {
                System.out.println("Files have different number of lines");
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }
}