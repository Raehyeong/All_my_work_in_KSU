/*
Class: CSE 1322L
Section: J04
Term: Spring 2022
Instructor: Yamini Hanisha Talluri
Name: Raehyeong Lee
Lab#: Lab5
*/

import java.util.Scanner;

abstract class Item {
    private String title;
    public Item() {
        this.title = "";
    }

    public Item(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public abstract String getListing();
    @Override
    public String toString() {
        return "Item\nTitle: " + title;
    }
}

class Book extends Item {

    private long isbnNumber;
    private String author;

    public Book() {
        this.isbnNumber = 0;
        this.author = "";
    }

    public Book(String title, long isbnNumber, String author) {
        super(title);
        this.isbnNumber = isbnNumber;
        this.author = author;
    }

    public long getIsbnNumber() {
        return isbnNumber;
    }
    public void setIsbnNumber(long isbnNumber) {
        this.isbnNumber = isbnNumber;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    @Override
    public String getListing() {
        return "Book Name - " + getTitle() + "\nAuthor - " + author + "\nISBN# - " + isbnNumber;
    }
}


class Periodical extends Item {
    private int issueNum;
    public Periodical() {

        this.issueNum = 0;
    }

    public Periodical(String title, int issueNum) {
        super(title);
        this.issueNum = issueNum;
    }

    public int getIssueNum() {
        return issueNum;
    }

    public void setIssueNum(int issueNum) {
        this.issueNum = issueNum;
    }

    @Override
    public String getListing() {
        return "Periodical Title - " + getTitle() + "\nIssue # - " + issueNum;
    }
}


public class Lab5 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Item[] items = new Item[5];

        for (int i = 0; i < items.length; i++) {

            System.out.print("Please enter B for Book or P for Periodical: ");
            String choice = scan.nextLine();
            if (choice.equalsIgnoreCase("b")) {

                System.out.print("Please enter the name of book: ");
                String bookName = scan.nextLine();
                System.out.print("Please enter the author of book: ");
                String author = scan.nextLine();
                System.out.print("Please enter the ISBN of the book: ");
                long isbn = scan.nextLong();
                scan.nextLine();
                items[i] = new Book(bookName, isbn, author);
            } else {

                System.out.print("Please enter the name of Periodical: ");
                String pName = scan.nextLine();
                System.out.print("Please enter issue number: ");
                int issueNumber = scan.nextInt();
                scan.nextLine();
                items[i] = new Periodical(pName, issueNumber);
            }
        }

        System.out.println("Your Items: ");
        for (int i = 0; i < items.length; i++) {

            System.out.println(items[i].getListing());
            System.out.println();
        }
    }
}