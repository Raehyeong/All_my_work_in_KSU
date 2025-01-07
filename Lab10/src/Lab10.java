
/*
Class: CSE 1322L
Section: J04
Term: Spring 2022
Instructor: Yamini Hanisha Talluri
Name: Raehyeong Lee
Lab#: Lab10
*/

import java.util.Scanner;

class InvalidTimeException extends Exception {
    public InvalidTimeException() {
    }
    public InvalidTimeException(String message) {
        super(message);
    }
}

public class Lab10 {
    public static int convertTime(String time) throws InvalidTimeException {
        String array[] = time.split(":");
        if (array.length != 3) {
            throw new InvalidTimeException("Enter a valid time");
        }
        int hours = Integer.parseInt(array[0]);
        int minutes = Integer.parseInt(array[1]);
        int seconds = Integer.parseInt(array[2]);
        if (hours > 23) throw new InvalidTimeException("Hours must be below 24.");
        if (minutes > 59) throw new InvalidTimeException("Minutes must be less than 60.");
        if (seconds > 59) throw new InvalidTimeException("Seconds must be less than 60.");
        return hours * 60 * 60 + minutes * 60 + seconds;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String time;
        int time1Sec, time2Sec, diff;
        try {
            System.out.println("Enter time 1 in 24hr format as follows (HH:MM:SS)");
            time = scanner.nextLine();
            time1Sec = convertTime(time);

            System.out.println("Enter time 2 in 24hr format as follows (HH:MM:SS)");
            time = scanner.nextLine();
            time2Sec = convertTime(time);

            if (time1Sec > time2Sec) {
                diff = time1Sec - time2Sec;
            } else {
                diff = time2Sec - time1Sec;
            }
            System.out.println("Difference in seconds: " + diff);
        } catch (InvalidTimeException e) {
            System.out.println(e.getMessage());
        }
    }
}