/*
Class: CSE 1321L
Section: J07
Term: Fall 2021
Instructor: Maneesha Penmetsa
Name: Raehyeong Lee
Lab#: Assignment6B
 */

import java.util.Random;
import java.util.Scanner;

public class Assignment6B {
    private static int[] Random(int size, int max) {

        Random random = new Random();
        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(max);
        }
        return arr;
    }

    private static void Insert(int[] arr) {

        int num = arr.length;

        for (int i = 1; i < num; ++i) {
            int array = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > array) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = array;
        }
    }

    private static void Select(int[] arr) {
        int num = arr.length;
        for (int i = 0; i < num - 1; i++) {
            int min = i;
            for (int j = i + 1; j < num; j++) {
                if (arr[j] > arr[min]) {
                    min = j;
                }
            }
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
    }

    private static void Array(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.print(arr[arr.length - 1]);
        System.out.println("");
    }

    private static void Menu() {
        System.out.print("[Options]\n1) Reset the array" + "\n2) Sort (Smallest to Largest)" + "\n3) Sort (Largest to Smallest)" + "\n4) Quit" + "\nChoice? ");
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int num;
        int max;

        System.out.print("How large should the array be? ");
        num = scanner.nextInt();

        System.out.print("What should be the highest number in the sequence? ");
        max = scanner.nextInt();

        int[] arr = Random(num, max);
        System.out.println();
        Array(arr);

        while (true) {
            System.out.println();
            Menu();
            int choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    arr = Random(num, max);
                    System.out.println("\nResetting the array: ");
                    Array(arr);
                    break;

                case 2:
                    System.out.println("\nUsing Insertion Sort: ");
                    Insert(arr);
                    Array(arr);
                    break;

                case 3:
                    System.out.println("\nUsing Selection Sort: ");
                    Select(arr);
                    Array(arr);
                    break;

                case 4:
                    System.out.println("\nClosing out...");
                    return;

                default:
                    System.out.println("\nInvalid option....");
            }
        }
    }
}
