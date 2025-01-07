/*
Class: CSE 1322L
Section: J04
Term: Spring 2022
Instructor: Yamini Hanisha Talluri
Name: Raehyeong Lee
Lab#: Lab9B
*/

import java.util.Scanner;

public class Lab9B {
    public static String repeatNTimes(String str,int N) {
        if(N==0) {
            return "";
        }
        return repeatNTimes(str,N-1)+str;
    }
    public static boolean isReverse(String str1,String str2) {
        if(str1.length()!=str2.length()) {
            return false;
        }

        if(str1.length()==1 && str2.length()==1 || str1.length()==0 && str2.length()==0) {
            return str1.equals(str2);
        }

        if(str1.charAt(0)==str2.charAt(str2.length()-1)) {
            return isReverse(str1.substring(1,str1.length()),str2.substring(0,str2.length()-1));
        }

        return false;
    }
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);

        System.out.println(repeatNTimes("I must study recursion until it makes sense\n",100));

        System.out.println("Enter the first string");
        String str1=scan.nextLine();

        System.out.println("Enter the second string");
        String str2=scan.nextLine();

        if(isReverse(str1,str2)){
            System.out.println(str1+" is the reverse of "+str2);
        }
        else{
            System.out.println(str1+" is not the reverse of "+str2);
        }
    }
}
