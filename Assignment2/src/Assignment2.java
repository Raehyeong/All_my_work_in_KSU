/*
Class: CSE 1322L
Section: J04
Term: Spring 2022
Instructor: Yamini Hanisha Talluri
Name: Raehyeong Lee
Lab#: Assignment2
*/


import java.util.Scanner;
import java.util.ArrayList;

class Encryption {

    ArrayList<Character> symbols = new ArrayList<>();
    ArrayList<Character> alphabets = new ArrayList<>();

    public Encryption() {
        symbols.add('!');
        symbols.add('@');
        symbols.add('#');
        symbols.add('$');
        symbols.add('^');
        symbols.add('&');
        symbols.add('*');
        symbols.add('(');
        symbols.add(')');
        symbols.add('_');
        symbols.add('-');
        symbols.add('+');
        symbols.add('=');
        symbols.add('?');
        symbols.add(',');
        symbols.add('{');
        symbols.add('}');
        symbols.add('[');
        symbols.add(']');
        symbols.add('/');
        symbols.add('|');
        symbols.add(';');
        symbols.add(':');
        symbols.add('.');
        symbols.add('<');
        symbols.add('>');

        for (char letter='a';letter<='z';letter++){
            alphabets.add(letter);
        }
    }

    public char return_alphabet(int index){
        return alphabets.get(index);
    }

    public int return_alphabet_index(char character){
        return alphabets.indexOf(character);
    }

    public char return_symbol(int index){
        return symbols.get(index);
    }

    public int return_symbol_index(char symbol){
        return symbols.indexOf(symbol);
    }

    public String encrypt_message(String str){
        String toLower = str.toLowerCase();
        char[] character = toLower.toCharArray();
        char[] encrypted = new char[character.length];
        int i = 0;

        for (char c : character){
            if (alphabets.contains(c)){
                encrypted[i] = return_symbol(return_alphabet_index(c));
                i++;
            }else {
                return "Error. Invalid Character";
            }
        }
        return toString(encrypted);
    }

    public  String decrypt_message(String message){

        char[] symbol = message.toCharArray();
        char[] decrypted = new char[symbol .length];
        int i = 0;

        for (char s : symbol ){
            if (symbols.contains(s)){
                decrypted[i] = return_alphabet(return_symbol_index(s));
                i++;
            }else {
                return "Error. Invalid Symbol";
            }
        }
        return toString(decrypted);
    }

    public static String toString(char[] a)
    {
        return new String(a);
    }
}

public class Assignment2 {
    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);

        Encryption encryption = new Encryption();
        int choice;

        System.out.println("1 Encrypt a message");
        System.out.println("2 Decrypt a message");
        System.out.println("3 Quit");

        do {
            System.out.print("\nEnter Choice:\n");
            choice = scan.nextInt();
            scan.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.println("Enter the plain text message:");
                    String str = scan.nextLine();
                    System.out.println("Encrypted Msg: " + encryption.encrypt_message(str));
                }
                case 2 -> {
                    System.out.println("Enter the encrypted message:");
                    String symbol = scan.nextLine();
                    encryption.decrypt_message(symbol);
                    System.out.println("Decrypted Msg: " + encryption.decrypt_message(symbol));
                }
                case 3 -> System.exit(1);
                default -> System.out.println("Error. Please enter valid input");
            }
        }while (true);
    }
}

