/*
Class: CSE 1321L
Section: J07
Term: Fall 2021
Instructor: Maneesha Penmetsa
Name: Raehyeong Lee
Lab#: Assignment6A
 */

import java.util.Random;

public class Assignment6A {
    public static int linear(int[] arr, int target) {
        int s;
        s = arr.length;
        int count;
        count =0;

        for(int i=0; i<s; i++) {
            count += 1;
            if(arr[i]==target) { break; }
        }
        return count;
    }

    public static int binary(int[] arr, int target) {

        int guess;
        guess = 0;
        int low;
        low = 0;
        int mid;
        int high;
        high = arr.length-1;
        int index;
        index = Integer.MAX_VALUE;


        while(low<=high) {
            mid = low + ((high-low)/2);
            guess += 1;

            if(arr[mid]<target) { low = mid+1; }
            else if(arr[mid]>target) { high = mid-1; }
            else if(arr[mid]==target)
            {
                index = mid;
                break;
            }
        }
        return guess;
    }

    public static void main(String[] args) {

        int num = 1000000;
        int[] array = new int[num];

        for(int i=0; i<num; i++) {
            array[i] = i;
        }

        Random rand = new Random();
        int target = rand.nextInt(num);
        int linear = linear(array,target);
        int binary = binary(array,target);

        System.out.println("\nComparing Linear Search and Binary Search:");
        System.out.println("Our target is "+target);
        System.out.println("Linear Search: "+linear+" loop(s)");
        System.out.println("Bianry Search: "+binary+" guess(es)");

        if(linear>binary) { System.out.println("Binary Search is faster this time!"); }
        else { System.out.println("Linear Search is faster this time!"); }
    }
}