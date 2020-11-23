import java.io.*;
import java.util.*;

public class Main {
    static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        solved();
        //Unsolved();

    }

    public static void solved() {

        printSubsequence();

    }


    public static void printSubsequence() {

        String str = scn.next();
        printSubsequenceRF(str,"");
    }

    public static void printSubsequenceRF(String ques, String ans) {

        if(ques.length() == 0){
            System.out.println(ans);
            return;
        }

        char ch = ques.charAt(0);

        printSubsequenceRF(ques.substring(1), ans + ch);
        printSubsequenceRF(ques.substring(1), ans + "");


    }

//-------------------------------------------------------------



}
