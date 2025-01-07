/*
Class: CSE 1322L
Section: J04
Term: Spring 2022
Instructor: Yamini Hanisha Talluri
Name: Raehyeong Lee
Lab #: Lab6
*/

import java.util.Scanner;

interface FindFib {
    int calculate_fib(int num);
}

class FibIteration implements FindFib {
    public int calculate_fib(int num) {
        if (num == 1 || num == 2) {
            return 1;
        }
        int f[] = new int[num + 2];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i <= num; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f[num - 1];
    }
}

class FibFormula implements FindFib {

    public int calculate_fib(int num) {
        double a = (1 + Math.sqrt(5)) / 2;
        return (int) Math.round(Math.pow(a, num) / Math.sqrt(5));
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int num;

        System.out.println("Enter the number you want to find the Fibonacci Series for:");
        num = scan.nextInt();

        FibIteration obj1 = new FibIteration();
        FibFormula obj2 = new FibFormula();
        System.out.println("Fib of 10 by iteration is: " + obj1.calculate_fib(num));

        System.out.println("Fib of 10 by formula is: " + obj2.calculate_fib(num));
    }

}