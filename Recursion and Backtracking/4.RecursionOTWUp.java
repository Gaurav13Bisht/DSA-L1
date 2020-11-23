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
        printKPC();
        printStairPaths();

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

    public static void printKPC() {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        printKPCRF(str, "");

    }

    static String[] codes = {".;","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};

   // !!!!!!!!!!!!!! THIS APPROACH IS LEVELS AND OPTIONS !!!!!!!!!!!!!!

    public static void printKPCRF(String key, String ans) {

        if(key.length() == 0){
            System.out.println(ans);
            return;
        }

        char ch = key.charAt(0);

        String sCode = codes[ch - '0'];
        for(int i = 0; i < sCode.length(); i++){
            printKPCRF(key.substring(1), ans + sCode.charAt(i));
        }

    }

//------------------------------------------------------------------

    public static void printStairPaths() {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        printStairPathsRF(n, "");
    }

    public static void printStairPathsRF(int n, String path) {

        if(n == 0){
            System.out.println(path);
            return;
        }
        else if(n < 0){
            return;
        }


        printStairPathsRF(n - 1, path + '1');
        printStairPathsRF(n - 2, path + '2');
        printStairPathsRF(n - 3, path + '3');


    }

//------------------------------------------------------------------


}
