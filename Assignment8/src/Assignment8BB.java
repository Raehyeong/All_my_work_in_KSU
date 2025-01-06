import java.util.Scanner;

//This is the class we use to make our objects
class Player{

    //Data attributes
    int x, y, width, height;

    //Explicit default constructor
    public Player(){
        //Example of constructor chaining
        this(0, 0, 0, 0);
    }

    //Overloaded Constructor
    public Player(int x, int y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void MoveHorizontal(int x_delta){
        x += x_delta;
    }

    public void MoveVertical(int y_delta){
        y += y_delta;
    }

    //We can take in a Player object as a parameter,
    //just like ints and Strings. Then we can use
    //its methods and data just like any other object
    public boolean DidTheyCollide(Player otherPlayer){
        //Axis-Aligned Bounding Box code
        if (
                x< (otherPlayer.getX() + otherPlayer.getWidth()) &&
                        (x + width) > (otherPlayer.getX()) &&
                        y < (otherPlayer.getY() + otherPlayer.getHeight()) &&
                        (y + height) > (otherPlayer.getY())
        )
        {
            return true;
        }
        return false;
    }

    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }

    public int getWidth(){
        return width;
    }
    public int getHeight(){
        return height;
    }
}

//Driver class
public class Assignment8BB {
    public static void main(String[] args) {

        System.out.println("[Collision Tester]");

        Scanner sc = new Scanner (System.in);
        Player[] npcs = new Player[2]; //This allows me to loop the user input rather than duplicate input code

        for(int i = 0; i < 2; i++){
            System.out.println("Create Player " + (i + 1));
            System.out.print("Enter X position: ");
            int x = sc.nextInt();
            System.out.print("Enter Y position: ");
            int y = sc.nextInt();
            System.out.print("Enter Player Hitbox Width: ");
            int width = sc.nextInt();
            System.out.print("Enter Player Hitbox Height: ");
            int height = sc.nextInt();

            //Creates a new player, and stores it in an array
            Player newPlayer = new Player(x, y, width, height);
            npcs[i] = newPlayer;
        }


        //We can directly use Player methods from the "npcs" array, since each index contains a Player object
        //E.g. npcs[0].getX(); is the same as newPlayer.getX();
        do{
            System.out.println("Player 1 is at (" + npcs[0].getX() + ", " + npcs[0].getY() + ") and Player 2 is at (" + npcs[1].getX() + ", " + npcs[1].getY() + ")");

            //Sending Player2's object to Player1's DidTheyCollide() method
            //so we can compare values
            if(npcs[0].DidTheyCollide(npcs[1])){
                System.out.println("They collided!");
                break;
            }

            System.out.println("Which one do you want to move?");
            int player = sc.nextInt();

            System.out.println("Which direction should Player " + player + " move (up, down, left, or right)?");
            String direction = sc.next();

            System.out.println("How far should Player " + player + " move?");
            int distance = sc.nextInt();


            //Make it negative if going down or left
            if(direction.equalsIgnoreCase("down") || direction.equalsIgnoreCase("left")){
                distance = Math.abs(distance) * -1;
            }

            //Player1 and Player2's code is duplicated - you could also make a method if you want to make it more efficient
            switch(player){
                case 1:
                    if(direction.equalsIgnoreCase("down") || direction.equalsIgnoreCase("up")){
                        npcs[0].MoveVertical(distance);
                    }
                    else if(direction.equalsIgnoreCase("left") || direction.equalsIgnoreCase("right")){
                        npcs[0].MoveHorizontal(distance);
                    }

                    break;
                case 2:
                    if(direction.equalsIgnoreCase("down") || direction.equalsIgnoreCase("up")){
                        npcs[1].MoveVertical(distance);
                    }
                    else if(direction.equalsIgnoreCase("left") || direction.equalsIgnoreCase("right")){
                        npcs[1].MoveHorizontal(distance);
                    }
            }
        } while(true);


        System.out.println("Program Ends");

    }
}




