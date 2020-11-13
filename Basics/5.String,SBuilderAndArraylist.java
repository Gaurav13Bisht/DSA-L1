import java.io.*;
import java.util.*;

public class Main {

    static Scanner scn = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        solved();
        unsolved();
    }

    public static void solved() {
        basics();
    }

    public static void unsolved() {

    }


    public static void basics() {

        String s;
        s = "Gaurav";

        intro(s);

        String s1 = scn.nextLine();

        PrintChars(s1);

        substrings(s1);

     }

    public static void intro(String s){

        //s[i] cannot be used in java to access String's character

        // s.charAt(i); is used

        System.out.println("Intro");

        System.out.println(s);

        System.out.println(s.charAt(4));

        System.out.println(s.substring(1,4));

        System.out.println(s.length());  //length is used as a function in strings

        System.out.println(s.substring(4));

     }

     public static void PrintChars(String s) {

        System.out.println("Print Characters : ");

        for(int i = 0; i < s.length(); i++) {
          System.out.println(s.charAt(i));
        }
     }

     public static void substrings(String s) {

        System.out.println("Sub strings :" );

        for(int i = 0; i < s.length(); i++)
          for(int j = i + 1; j <= s.length(); j++)
            System.out.println(s.substring(i,j));

     }

//-----------------------------------------------------------------







}
