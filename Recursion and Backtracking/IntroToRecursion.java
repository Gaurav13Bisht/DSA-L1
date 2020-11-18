import java.io.*;
import java.util.*;

public class Main {
    static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
          solved();
          //Unsolved();

    }

    public static void solved() {

          printDecreasing();
          printIncreasing();


    }


    public static void printDecreasing(){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        printDecreasingRF(n);
    }

    public static void printDecreasingRF(int n){	 //!!! RFfunctionName : RF = Recursive Function !!!
  	    if(n == 0)
            return;
        System.out.println(n);
        printDecreasingRF(n - 1);
    }

//---------------------------------------------------------------

    public static void printIncreasing() {

        int n = scn.nextInt();
        printIncreasingRF(n);
    }

    public static void printIncreasingRF(int n){
        if(n == 0)
          return;
        printIncreasingRF(n - 1);
        System.out.println(n);

    }

//---------------------------------------------------------------








}
