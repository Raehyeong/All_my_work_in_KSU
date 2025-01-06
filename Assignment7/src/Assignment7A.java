/*
Class: CSE 1321L
Section: J07
Term: Fall 2021
Instructor: Maneesha Penmetsa
Name: Raehyeong Lee
Lab#: Assignment7A
 */
import java.util.Scanner;

public class Assignment7A {
    public static double Average(double array[],int num) {
        double sum = 0.0f;
        for(int i=0;i<num;i++)
            sum += array[i];
        return sum/num;
    }

    public static double Weight(double average, double percentage) {
        return average*percentage;
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("[CSE 1321L Grade Calculator]");



        System.out.println("Labs");
        double[] lab = new double[13];
        for(int i=0;i<13;i++) {
            System.out.print("Enter Grade #" + (i+1) + ": ");
            lab[i] = scan.nextDouble();
        }
        double avg = Average(lab,13);
        double labWeight= Weight(avg,0.10);
        System.out.println("Weighted Points: " + labWeight + "\n");



        System.out.println("Assignments");
        double[] Assignment = new double[8];
        for(int i=0;i<8;i++) {
            System.out.print("Enter Grade #" + (i+1) + ": ");
            Assignment[i]=scan.nextDouble();
        }

        avg = Average(Assignment,8);
        double AssignmentWeight = Weight(avg,0.40);
        System.out.println("Weighted Points: " + AssignmentWeight + "\n");



        System.out.println("Midterms");
        System.out.print("Enter Grade #1: ");
        double midterm = scan.nextDouble();
        double midtermWeight = midterm *0.20;
        System.out.println("Weighted Points: " + midtermWeight + "\n");



        System.out.println("Exam");
        System.out.print("Enter Grade #1: ");
        double finalexam = scan.nextDouble();
        double finalWeight = finalexam *0.30;
        System.out.println("Weighted Points: " + finalWeight + "\n");



        System.out.println("Your final grade for CSE1321L is: "+(labWeight+AssignmentWeight+midtermWeight+finalWeight));
    }
}

