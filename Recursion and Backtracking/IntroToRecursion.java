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
          printDecInc();
          factorial();
          powerLinear();

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

    public static void printDecInc() {

        int n = scn.nextInt();
        printDecIncRF(n);
    }

    public static void printDecIncRF(int n){
        if(n == 0)
            return;
        System.out.println(n);
        printDecIncRF(n - 1);
        System.out.println(n);

    }

//---------------------------------------------------------------

    public static void factorial() {

        int n = scn.nextInt();
        System.out.print(factorialRF(n));
    }

    public static int factorialRF(int n){

        if(n == 0)
            return 1;
        int tfact = n * factorialRF(n-1);
        return tfact;
    }

//-----------------------------------------------------------------

     public static void powerLinear() {

        int x = scn.nextInt();
        int n = scn.nextInt();
        System.out.print(powerLinearRF(x,n));
    }

    public static int powerLinearRF(int x, int n){
        if(n == 0)
            return 1;
        int tpower = x * powerLinearRF(x, n - 1);
        return tpower;
    }

//-----------------------------------------------------------------

}
