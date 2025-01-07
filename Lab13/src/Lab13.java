/*
Class: CSE 1322L
Section: J04
Term: Spring 2022
Instructor: Yamini Hanisha Talluri
Name: Raehyeong Lee
Lab #: Lab13
*/

import java.util.Scanner;

class BlueRayDisk {
    private String title;
    private String director;
    private int year;
    private double cost;

    public BlueRayDisk(String title, String director, int year, double cost) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.cost = cost;
    }

    public String getTitle() {
        return title;
    }

    public String getDirector() {
        return director;
    }

    public int getYear() {
        return year;
    }

    public double getCost() {
        return cost;
    }

    @Override
    public String toString() {
        String str=String.format("$%.2f %d %s, %s", cost,year,title,director);
        return str;
    }


}

class BlueRayCollection {

    Node head;

    class Node {
        BlueRayDisk data;
        Node next;

        public Node(BlueRayDisk data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public void add(BlueRayDisk data) {
        Node newNode = new Node(data, null);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void printList() {
        Node currNode = head;
        while (currNode != null) {
            System.out.println(currNode.data);
            currNode = currNode.next;
        }
        System.out.println("");
    }

    public void printMenu() {
        System.out.println("0. Quit");
        System.out.println("1. Add BlueRay to collection");
        System.out.println("2. See collection");
    }
}

public class Lab13 {
    public static void main(String[] args) {
        BlueRayCollection collection = new BlueRayCollection();
        boolean flag = true;

        Scanner scan = new Scanner(System.in);
        while (flag) {
            collection.printMenu();
            int option = scan.nextInt();
            scan.nextLine();
            switch (option) {
                case 1:
                    System.out.println("What is the title?");
                    String title = scan.nextLine();
                    System.out.println("What is the director?");
                    String director = scan.nextLine();
                    System.out.println("What is the year of release?");
                    int year = scan.nextInt();
                    System.out.println("What is the cost?");
                    double cost = scan.nextDouble();
                    BlueRayDisk blueRay = new BlueRayDisk(title, director, year, cost);
                    collection.add(blueRay);
                    System.out.println("");
                    break;
                case 2:
                    collection.printList();
                    break;
                case 0:
                    flag = false;
                    break;
                default:
                    System.out.println("Wrong Input");
                    break;

            }
        }
    }
}
