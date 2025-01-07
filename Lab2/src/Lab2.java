/*
Class: CSE 1322L
Section: J04
Term: Spring 2022
Instructor: Yamini Hanisha Talluri
Name: Raehyeong Lee
Lab#: Lab2
*/

import java.util.Scanner;

class StockItem{
    String description;
    int id;
    double price;
    int quantity;
    int Num=0;

    StockItem() {
        this.description="";
        this.id=Num++;
        this.price=0;
        this.quantity=0;
    }

    StockItem(String description,double price,int quantity)
    {
        this.description=description;
        this.id=Num++;
        this.price=price;
        this.quantity=quantity;
    }

    public String toString() {
        return ("Item number: "+id+" is "+description+" has price "+price+" we currently have "+quantity+" in stock");
    }

    String getDescription() {
        return description;
    }
    double getPrice(){
        return price;
    }
    int getId(){
        return id;
    }
    int getQuantity(){
        return quantity;
    }
    public int getNum() {
        return Num;
    }

    void setPrice(double price){
        if(price<0)
            System.out.println("Error: new price below 0.");
        else
            this.price=price;
    }
    void setQuantityL(int quantity){
        if(this.quantity-quantity<0)
            System.out.println("Error: quantity drop below 0.");
        else
            this.quantity-=quantity;
    }
    void setQuantityR(int quantity){
        this.quantity+=quantity;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public void setNum(int num) {
        Num = num;
    }
}


public class Lab2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        StockItem milk = new StockItem("1 Gallon of Milk",3.60,15);
        StockItem bread = new StockItem("1 Loaf of Bread",1.98,30);

        int choice = -1;

        do {
            System.out.println("1. Sold One Milk");
            System.out.println("2. Sold One Bread");
            System.out.println("3. Change price of Milk");
            System.out.println("4. Change price of Bread");
            System.out.println("5. Add Milk to Inventory");
            System.out.println("6. Add Bread to Inventory");
            System.out.println("7. See Inventory");
            System.out.println("8. Quit");

            choice=scan.nextInt();

            if(choice==1) {
                milk.setQuantityL(1);
                System.out.println();
            }

            else if(choice==2) {
                bread.setQuantityL(1);
                System.out.println();
            }

            else if(choice==3) {
                System.out.print("Enter new price of milk: \n");
                double price;
                price=scan.nextDouble();
                milk.setPrice(price);
                System.out.println();
            }

            else if(choice==4) {
                System.out.print("Enter new price of bread: \n");
                double price;
                price=scan.nextDouble();
                bread.setPrice(price);
                System.out.println();
            }

            else if(choice==5) {
                System.out.print("Enter quantity of milk: \n");
                int quantity;
                quantity=scan.nextInt();
                milk.setQuantityR(quantity);
                System.out.println();
            }

            else if(choice==6) {
                System.out.print("Enter quantity of bread: \n");
                int quantity;
                quantity=scan.nextInt();
                bread.setQuantityR(quantity);
                System.out.println();
            }

            else if(choice==7) {
                System.out.println("Milk: "+milk.toString());
                System.out.println("Bread: "+bread.toString());
                System.out.println();
            }
        }
        while(choice!=8);

    }
}