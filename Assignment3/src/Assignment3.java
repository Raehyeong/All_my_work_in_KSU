/*
Class: CSE 1322L
Section: J04
Term: Spring 2022
Instructor: Yamini Hanisha Talluri
Name: Raehyeong Lee
Lab#: Assignment3
*/

import java.util.ArrayList;
import java.util.Scanner;

class Employee {
    private String Name;
    private int ID;
    private static int numberOfEmployees =0;

    public Employee() {
        Name="new employee";
        ID=++numberOfEmployees;
    }

    public Employee(String name) {
        this.Name=name;
        ID=++numberOfEmployees;
    }

    public String getName() {
        return Name;
    }
    public int getID() {
        return ID;
    }

    public void setName(String Name) {
        this.Name = Name;
    }
    public void setID(int ID) {
        this.ID = ID;
    }

    public static int getNumberOfEmployees()
    {
        return numberOfEmployees;
    }
    public static void decreaseNumberOfEmployees()
    {
        numberOfEmployees--;
    }
}

class Faculty extends Employee {
    private double weeklySalary;
    private double weeklyStipend;
    private double weeklyPay;

    public Faculty(String name,double weeklySalary, double weeklyStipend) {
        super(name);
        this.weeklySalary = weeklySalary;
        this.weeklyStipend = weeklyStipend;
    }

    public double getWeeklySalary() {
        return weeklySalary;
    }
    public void setWeeklySalary(double weeklySalary) {
        this.weeklySalary = weeklySalary;
    }

    public double getWeeklyStipend() {
        return weeklyStipend;
    }
    public void setWeeklyStipend(double weeklyStipend) {
        this.weeklyStipend = weeklyStipend;
    }

    public double getWeeklyPay() {
        return weeklyPay;
    }
    public void setWeeklyPay(double weeklyPay) {
        this.weeklyPay = weeklyPay;
    }

    public void calculateWeeklyPay() {
        weeklyPay=weeklySalary+weeklyStipend;
    }

    @Override
    public String toString() {
        return "Name: "+super.getName()+", Salary: " + weeklySalary + ", Stipend: " + weeklyStipend + ", Weekly Pay: " + weeklyPay;
    }

}


public class Assignment3 {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);

        ArrayList<Faculty> faculties=new ArrayList<>();
        int choice;

        do {
            System.out.println("1 – Add Faculty");
            System.out.println("2 – Delete Faculty");
            System.out.println("3 – Calculate Faculty Pay");
            System.out.println("4 – Print Faculty");
            System.out.println("5 – Exit\n");
            System.out.print("Enter Choice: ");

            choice = scan.nextInt();
            switch(choice) {
                case 1:
                    addFaculty(faculties);
                    System.out.println("");
                    break;
                case 2:
                    deleteFaculty(faculties);
                    System.out.println("");
                    break;
                case 3:
                    calculateFacultyPay(faculties);
                    System.out.println("");
                    break;
                case 4:
                    printFaculty(faculties);
                    break;
                case 5:
                    System.out.println("\nGood Bye!!");
                    break;
                default:
                    System.out.println("Error: Please Enter Valid Input.");
                    System.out.println("");
                    break;
            }
        }while(choice!=5);
    }

    public static void addFaculty(ArrayList<Faculty> faculties) {
        Scanner scan=new Scanner(System.in);

        String name;
        double weeklySal;
        double weeklySti;

        System.out.println("Enter Faculty name: ");
        name= scan.nextLine();

        System.out.println("Enter weekly salary: ");
        weeklySal=Double.parseDouble(scan.nextLine());

        System.out.println("Enter weekly stipend: ");
        weeklySti=Double.parseDouble(scan.nextLine());
        faculties.add(new Faculty(name, weeklySal, weeklySti));
    }

    public static void deleteFaculty(ArrayList<Faculty> faculties) {
        Scanner scan=new Scanner(System.in);

        String name;

        System.out.print("Enter Faculty name to delete: ");
        name= scan.nextLine();

        for(int i=0;i<faculties.size();i++) {
            if(name.equalsIgnoreCase(faculties.get(i).getName())) {
                faculties.remove(i);
                Faculty.decreaseNumberOfEmployees();
                return;
            }
        }
        System.out.println("Faculty with name "+name+" is not in the list.");
    }

    public static void calculateFacultyPay(ArrayList<Faculty> faculties) {
        for(int i=0;i<faculties.size();i++) {
            faculties.get(i).calculateWeeklyPay();
        }
    }

    public static void printFaculty(ArrayList<Faculty> faculties) {
        for(int i=0;i<faculties.size();i++) {
            System.out.println(faculties.get(i)+"\n");
        }
    }
}