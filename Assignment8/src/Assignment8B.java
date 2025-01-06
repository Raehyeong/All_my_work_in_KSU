/*
Class: CSE 1321L
Section: J07
Term: Fall 2021
Instructor: Maneesha Penmetsa
Name: Raehyeong Lee
Lab#: Assignment8B
 */

import java.util.Scanner;

class Players {
    private int width, height, XPositions, YPositions;

    public Players(int width, int height, int XPositions, int YPositions) {
        this.width = width;
        this.height = height;
        this.XPositions = XPositions;
        this.YPositions = YPositions;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getXPositions() {
        return XPositions;
    }

    public int getYPositions() {
        return YPositions;
    }

    public void MoveHorizontal(int xdelta) {
        this.XPositions += xdelta;
    }

    public void MoveVertical(int ydelta) {
        this.YPositions += ydelta;
    }

    public boolean DidTheyCollide(Players otherPlayer) {
        if (this.XPositions < (otherPlayer.width + otherPlayer.XPositions) && (this.width + this.XPositions) > otherPlayer.XPositions
                && this.YPositions < (otherPlayer.height + otherPlayer.YPositions)
                && (this.height + this.YPositions) > otherPlayer.YPositions) {
            System.out.println("They collided!");
            return true;
        }
        return false;
    }
}
public class Assignment8B {
    public static void main(String[] args) {
        System.out.println("[Collision Tester]");

        Players player1, player2;
        Scanner scan = new Scanner(System.in);

        System.out.println("Create Player 1");
        System.out.print("Enter X position: ");
        int xPositions = scan.nextInt();
        System.out.print("Enter Y position: ");
        int yPositions = scan.nextInt();
        System.out.print("Enter Player Hitbox Width: ");
        int width = scan.nextInt();
        System.out.print("Enter Player Hitbox Height: ");
        int height = scan.nextInt();
        player1 = new Players(width, height, xPositions, yPositions);
        System.out.println();

        System.out.println("Create player 2");
        System.out.print("Enter X position: ");
        xPositions = scan.nextInt();
        System.out.print("Enter Y position: ");
        yPositions = scan.nextInt();
        System.out.print("Enter Player Hitbox Width: ");
        width = scan.nextInt();
        System.out.print("Enter Player Hitbox Height: ");
        height = scan.nextInt();
        player2 = new Players(width, height, xPositions, yPositions);
        System.out.println();

        System.out.print("Player 1 is at (" + player1.getXPositions() + "," + player1.getYPositions() + ") and ");
        System.out.println("Player 2 is at (" + player2.getXPositions() + "," + player2.getYPositions() + ")");


        while (!player1.DidTheyCollide(player2)) {

            System.out.println("Which one do you want to move?");
            int move = scan.nextInt();
            System.out.println("Which direction should Player " + move + " move (up, down, left, or right)?");
            String direction = scan.next();
            System.out.println("How far should Player " + move + " move?");
            int distance = scan.nextInt();

            Players player = move == 1 ? player1 : player2;

            int multiplier = (direction.compareToIgnoreCase("down") == 0 || direction.compareToIgnoreCase("left") == 0)
                    ? -1
                    : 1;
            if (direction.compareToIgnoreCase("up") == 0 || direction.compareToIgnoreCase("down") == 0) {
                player.MoveVertical(multiplier * distance);
            } else {
                player.MoveHorizontal(multiplier * distance);
            }
            System.out.println();
            System.out.print("Player 1 is at (" + player1.getXPositions() + "," + player1.getYPositions() + ") and ");
            System.out.println("Player 2 is at (" + player2.getXPositions() + "," + player2.getYPositions() + ")");
        }

        System.out.println("Program Ends");
    }

}
