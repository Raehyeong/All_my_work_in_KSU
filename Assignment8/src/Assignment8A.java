/*
Class: CSE 1321L
Section: J07
Term: Fall 2021
Instructor: Maneesha Penmetsa
Name: Raehyeong Lee
Lab#: Assignment8A
*/

import java.util.Scanner;

class LaserDisc {
    private String movieTitle;
    private int releaseYear;
    private String genre;
    float rating;

    public LaserDisc() {
        movieTitle = "Star Wars Holiday Special";
        releaseYear = 1978;
        genre = "Science Fiction";
        rating = 5;
    }

    public LaserDisc(String movieTitle, int releaseYear, String genre, float rating) {
        if (rating < 0 || rating > 5) {
            rating = 0;
        }

        if (releaseYear < 1978) {
            releaseYear = 1978;
        }

        this.movieTitle = movieTitle;
        this.releaseYear = releaseYear;
        this.genre = genre;
        this.rating = rating;
    }

    boolean isItGood() {
        return rating >= 3.0;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public String getGenre() {
        return genre;
    }

    public float getRating() {
        return rating;
    }
}

public class Assignment8A {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("How many movies do you have? ");
        int numMovies = Integer.parseInt(scan.nextLine());

        LaserDisc[] laserDiscs = new LaserDisc[numMovies];

        for (int i = 0; i < laserDiscs.length; i++) {
            System.out.print("\nMovie #"+ (i + 1));

            System.out.print("\n*Enter Title: ");
            String movieTitle = scan.nextLine();

            System.out.print("*Enter Genre: ");
            String genre = scan.nextLine();

            System.out.print("*Enter Release Year: ");
            int releaseYear = Integer.parseInt(scan.nextLine());

            System.out.print("*Enter Rating(0.0 - 5.0): ");
            float rating = Float.parseFloat(scan.nextLine());


            laserDiscs[i] = new LaserDisc(movieTitle, releaseYear, genre, rating);
        }


        int choice;
        do {

            System.out.println("\n[Main Menu]");
            System.out.println("1) Movie Info");
            System.out.println("2) Recommend a Good Movie");
            System.out.println("3) Log off");
            System.out.print("Choice: ");


            choice = Integer.parseInt(scan.nextLine());
            System.out.println();

            int[] indexes = new int[laserDiscs.length];
            for (int i = 0; i < indexes.length; i++) {
                indexes[i] = i;
            }

            switch(choice) {
                case 1:

                    System.out.print("Which movie do you want? ");
                    int index = Integer.parseInt(scan.nextLine());


                    if (index < 0 || index >= laserDiscs.length) {
                        System.out.print("Sorry, that’s not a valid Movie index");
                    } else {
                        LaserDisc disc = laserDiscs[index];
                        System.out.print(index+". " + disc.getMovieTitle()+", "+disc.getReleaseYear()+ "\nGenre: "+disc.getGenre()+"\nRating: "+ disc.getRating());
                    }
                    break;
                case 2:

                    for (int i = indexes.length - 1; i > 0; i--) {
                        int j = (int)Math.floor(Math.random() * (i + 1));
                        int temp = indexes[i];
                        indexes[i] = indexes[j];
                        indexes[j] = temp;
                    }

                    for (int i = 0; i < indexes.length; i++) {
                        if (laserDiscs[indexes[i]].isItGood()) {

                            LaserDisc disc = laserDiscs[indexes[i]];
                            System.out.println("You should try: "+disc.getMovieTitle()+" ("+disc.getReleaseYear()+")!");
                            System.out.print("It has a rating of "+ disc.getRating());
                            break;
                        }
                    }
                    break;

                case 3:
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.print("Sorry, that’s not a valid Movie index");
            }
            System.out.println();
        } while (choice != 3);
    }
}
