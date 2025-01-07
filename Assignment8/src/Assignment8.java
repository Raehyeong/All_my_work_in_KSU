/*
Class: CSE 1322L
Section: J04
Term: Spring 2022
Instructor: Yamini Hanisha Talluri
Name: Raehyeong Lee
Lab#: Assignment8
*/

import java.util.Scanner;

public class Assignment8 {
    public static String decimal2Binary(int num){
        if(num == 0) {
            return "";
        } else {
            int rem = (num%2);
            return decimal2Binary(num/2) + Integer.toString(rem) ;
        }
    }


    public static String decimal2Hexadecimal(int num) {
        int rem = num % 16;

        if(num!=0) {
            switch(rem) {
                case 10:
                    return decimal2Hexadecimal(num/16) + "A";
                case 11:
                    return decimal2Hexadecimal(num/16) + "B";
                case 12:
                    return decimal2Hexadecimal(num/16) + "C";
                case 13:
                    return decimal2Hexadecimal(num/16) + "D";
                case 14:
                    return decimal2Hexadecimal(num/16) + "E";
                case 15:
                    return decimal2Hexadecimal(num/16) + "F";
                default:
                    return decimal2Hexadecimal(num/16) + rem;
            }
        } else {
            return "";
        }
    }


    public static String convertIpAdress(String[] str,int i) {
        if( i == str.length-1) {
            return decimal2Binary(Integer.parseInt(str[i]));
        }

        return decimal2Binary(Integer.parseInt(str[i])) + "." + convertIpAdress(str,++i);
    }

    public static String convertMacAdress(String[] str,int i) {
        if( i == str.length-1) {
            return decimal2Hexadecimal(Integer.parseInt(str[i]));
        }
        return decimal2Hexadecimal(Integer.parseInt(str[i])) + ":" + convertMacAdress(str,++i);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int choice;
        int integer;

        while(true) {
            System.out.println("1 – Convert Decimal Number to Binary Number");
            System.out.println("2 - Convert Decimal Number to Hexadecimal Number");
            System.out.println("3 - Convert Decimal IP Address to Binary IP Address");
            System.out.println("4 - Convert Decimal MAC Address to Hexadecimal MAC Address");
            System.out.println("5 - Exit" + "\n");

            System.out.print("Enter Choice: ");
            choice = scan.nextInt();

            if(choice == 1) {
                System.out.print("\nEnter Decimal Integer: ");
                integer = scan.nextInt();
                String binary = decimal2Binary(integer);

                System.out.println("Decimal Number: " + integer);
                System.out.println("Binary Number: " + binary + "\n");
            } else if(choice == 2) {
                System.out.print("\nEnter Decimal Integer: ");
                integer = scan.nextInt();
                String binary = decimal2Binary(integer);

                System.out.println("Decimal Number: " + integer);
                System.out.println("Binary Number: " + binary + "\n");
            } else if(choice == 3) {
                System.out.print("\nEnter decimal Address(i.e. 192.168.35.10): ");
                scan.nextLine();
                String str = scan.nextLine();

                String[] decimal = str.split("\\.");
                String binaryIP = convertIpAdress(decimal,0);

                System.out.println("Decimal IP Address: " + str);
                System.out.println("Binary IP Address: " + binaryIP + "\n");
            } else if(choice == 4) {
                System.out.print("\nEnter MAC Address(i.e. 203:65:157:93:13:7): ");scan.nextLine();

                String str = scan.nextLine();
                String[] decimal = str.split(":");
                String hexaMAC = convertMacAdress(decimal,0);

                System.out.println("Decimal MAC Address: " + str);
                System.out.println("Hexadecimal MAC Address: " + hexaMAC + "\n");
            } else if(choice == 5){
                break;
            } else {
                System.out.println("\nError : Please Enter Valid Input\n");
            }
        }
    }
}