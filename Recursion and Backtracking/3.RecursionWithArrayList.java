import java.io.*;
import java.util.*;

public class Main {
    static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        solved();
        //Unsolved();

    }

    public static void solved() {
        getSubsequence();

    }



    public static void getSubsequence() {

        String str = scn.next();
        ArrayList<String> str1 = gss(str);
        System.out.print(str1);
    }

    public static ArrayList<String> gss(String str) {

        if(str.length() == 0){
            ArrayList<String> bcase = new ArrayList<String>();
            bcase.add("");
            return bcase;
        }

        ArrayList<String> str1 = gss(str.substring(1));
        char ch = str.charAt(0);

        ArrayList<String> str2 = new ArrayList<String>(); // to avoid duplicacy

        for(String prevstring : str1){
            str2.add("" + prevstring);
        }


        for(String prevstring : str1){
            str2.add(ch + prevstring);
        }

        return str2;

    }

//--------------------------------------------------------------------------

}
