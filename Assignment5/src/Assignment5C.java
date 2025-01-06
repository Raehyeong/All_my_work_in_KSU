/*
Class: CSE 1321L
Section: J07
Term: Fall 2021
Instructor: Maneesha Penmetsa
Name: Raehyeong Lee
Lab#: Assignment5C
 */

import java.util.Scanner;

public class Assignment5C {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int width;
        int height;
        int length;
        int choice;
        int x;
        int y;
        int xItem;
        int yItem;

        System.out.print("Enter a level map width: ");
        width = scanner.nextInt();
        System.out.print("Enter a level map height: ");
        height = scanner.nextInt();

        String[][] arr = new String[height][width];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                arr[i][j] = "*";
            }
        }
        display(arr, height, width);
        choice = 0;

        do {
            System.out.println("\nOptions");
            System.out.println("1. Clear Level");
            System.out.println("2. Add Platform");
            System.out.println("3. Add Items");
            System.out.println("4. Quit");

            System.out.print("Enter a choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:

                    System.out.println("[Clear Level]");

                    for (int i = 0; i < height; i++) {
                        for (int j = 0; j < width; j++) {
                            arr[i][j] = "*";
                        }
                    }
                    display(arr, height, width);
                    break;
                case 2:

                    System.out.println("\n[Add Platform]");

                    System.out.print("Enter X Coordinate: ");
                    x = scanner.nextInt();
                    System.out.print("Enter Y Coordinate: ");
                    y = scanner.nextInt();
                    System.out.print("Enter Length: ");
                    length = scanner.nextInt();
                    scanner.nextLine();

                    if (x >= width && y >= height || (x + length > height)) {
                        System.out.println("This platform won't fit in the level!");
                    } else {

                        for (int i = x; i < x + length; i++) {
                            arr[y][i] = "=";
                        }
                    }
                    display(arr, height, width);
                    break;

                case 3:
                    System.out.println("\n[Add Item]");

                    System.out.print("Enter X Coordinate: ");
                    xItem = scanner.nextInt();
                    System.out.print("Enter Y Coordinate: ");
                    yItem = scanner.nextInt();

                    if (xItem >= width && yItem >= height) {
                        System.out.println("This is not a valid location!");
                    } else {
                        System.out.println(arr[yItem][xItem] = "O");
                    }

                    display(arr, height, width);
                    break;

                default:
                    display(arr, height, width);
                    System.out.println("Goodbye!");
                    break;
            }
        } while (choice != 4);

    }
    private static void display(String[][] arr, int height, int width) {
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                System.out.print(arr[row][col]);
            }
            System.out.println("");
        }
        System.out.println();
    }
}
