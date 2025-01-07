/*
Class: CSE 1322L
Section: J04
Term: Spring 2022
Instructor: Yamini Hanisha Talluri
Name: Raehyeong Lee
Lab #: Lab12
*/

import java.util.Random;

class Baby implements Runnable {
    private int time;
    private String name;

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Baby(String name) {
        Random random = new Random();
        this.name = name;
        this.time = random.nextInt(5000);
    }

    @Override
    public void run() {
        System.out.println("My name is " + this.getName() + " I am going to sleep for " + this.getTime() + "ms");
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("My name is " + this.getName() + " and I'm awake, feed me!!!");
    }
}
public class Lab12 {
    public static void main(String args[]) {
        Thread b1 = new Thread(new Baby("Noah"));
        Thread b2 = new Thread(new Baby("Olivia"));
        Thread b3 = new Thread(new Baby("Amelia"));
        Thread b4 = new Thread(new Baby("Emma"));
        Thread b5 = new Thread(new Baby("Liam"));

        b1.start();
        b2.start();
        b3.start();
        b4.start();
        b5.start();

    }
}
