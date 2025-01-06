import java.util.Random;
import java.util.Scanner;

//This is the class we use to make our objects
class LaserDisca{

    //Data attributes - notice they are private per encapsulation
    private String movieTitle;
    private int releaseYear;
    private String genre;
    private float rating;

    //Explicit default constructor
    public LaserDisca(){
        //Example of constructor chaining
        this("Star Wars Holiday Special", 1978, "Science Fiction", 5.0f);
    }

    //Overloaded Constructor
    public LaserDisca(String m, int y, String g, float r){
        movieTitle = m;
        releaseYear = y;
        genre = g;
        rating = r;

        if(y < 1978){
            y = 1978;
        }
        if(rating < 0.0 || rating > 5.0){
            rating = 0;
        }
    }

    public boolean isItGood(){
        if (rating >= 3.0) {
            return true;
        }

        return false;
    }

    //Our four getter methods
    //Only way to access information
    public String getMovieTitle(){
        return movieTitle;
    }
    public int getReleaseYear(){
        return releaseYear;
    }
    public String getGenre(){
        return genre;
    }
    public float getRating(){
        return rating;
    }
}

//Driver class
public class Assignment8AA {
    public static void main(String[] args) {

        Scanner sc = new Scanner (System.in);
        System.out.println("[Laser Disc Collection]");
        System.out.print("How many movies do you have? ");
        int arraySize = sc.nextInt();

        //We create an array of LaserDiscs, just like any other array
        //Currently, each index's value is "null" - nothing
        LaserDisc[] collection = new LaserDisc[arraySize];
        for(int i = 0; i < arraySize; i++) {
            sc = new Scanner (System.in); //Trick to reset the Scanner class after .nextInt() so .nextLine() isn't skipped
            System.out.println("Movie " + (i + 1) + ":");
            System.out.print("*Enter Title: ");
            String s = sc.nextLine();
            System.out.print("*Enter Genre: ");
            String g = sc.nextLine();
            System.out.print("*Enter Release Year: ");
            int y = sc.nextInt();
            System.out.print("*Enter Rating: ");
            float r = sc.nextFloat();

            //Create a new LaserDisc object with this information
            LaserDisc nextDisc = new LaserDisc(s, y, g, r);
            //Then add it to the array in the proper index, like we've done with other data types
            collection[i] = nextDisc;
        }

        int choice = 0;

        do{
            System.out.println("[Main Menu]\n" +
                    "1) Movie Info\n" +
                    "2) Recommend a Good Movie\n" +
                    "3) Log off");
            System.out.print("Choice: ");
            choice = sc.nextInt();

            switch(choice){
                case 1:
                    System.out.print("Which movie do you want? ");
                    int index = sc.nextInt();
                    if(index < 0 || index >= arraySize){
                        System.out.println("Sorry, that’s not a valid Movie index");
                    }
                    else{
                        LaserDisc selection = collection[index];
                        System.out.println(index + ". " + selection.getMovieTitle() + ", " + selection.getReleaseYear());
                        System.out.println("Genre: " + selection.getGenre());
                        System.out.println("Rating: " + selection.getRating()+ "\n");
                    }
                    break;

                case 2:
                    //This is the "easy" way to randomly check for a movie
                    //Randomly generating a number, and keep doing this until
                    //we find a good movie or guess a certain number of times
                    Random rand = new Random();
                    boolean flag = false;
                    for(int i = 0; i < arraySize; i++){

                        int newIndex = rand.nextInt(arraySize);
                        //We can get a movie out of the array like this,
                        //or just directly call it from the array index
                        LaserDisc checkMovie = collection[newIndex];

                        if(checkMovie.isItGood()){
                            System.out.println("You should try: " + checkMovie.getMovieTitle() + "!");
                            System.out.println("It has a rating of " + checkMovie.getRating() + "\n");
                            flag = true;
                            break;
                        }
                    }

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