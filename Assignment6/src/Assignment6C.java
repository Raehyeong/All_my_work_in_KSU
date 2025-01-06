/*
Class: CSE 1321L
Section: J07
Term: Fall 2021
Instructor: Maneesha Penmetsa
Name: Raehyeong Lee
Lab#: Assignment6C
 */

import java.util.Scanner;
import java.util.Random;

public class Assignment6C {
    public static void display(char [][]arr, int size) {
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println("");
        }
    }
    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);
        Random rand = new Random();

        int grid;
        int win;
        win = 1;
        int count;
        count= 0;

        System.out.println("[Minesweeper - DOS Edition]");
        System.out.print("What is the grid size? ");
        grid = scan.nextInt();

        char[][] arr = new char[grid][grid];
        for(int i=0;i<grid;i++){
            for(int j=0;j<grid;j++)
                arr[i][j] = '?';
        }

        int[] mine = new int[grid];

        for(int i=0;i<grid;i++){
            mine[i] = rand.nextInt(grid);
        }

        while(true){
            display(arr,grid);

            System.out.print("Enter your X coordinate: ");
            int x = scan.nextInt();
            System.out.print("Enter your Y coordinate: ");
            int y = scan.nextInt();

            if(mine[y]==x){
                win = 0;
                arr[x][y] = 'X';
                break;
            }
            count++;
            arr[x][y] = '_';

            if(count==grid){
                break;
            }
            System.out.println("");
        }
        System.out.println("");

        display(arr,grid);

        if(win == 1) {
            System.out.print("You win!");
        } else {
            System.out.print("Sorry, you hit a mine!");
        }
        scan.close();
    }
}
