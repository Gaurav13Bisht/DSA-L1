import java.io.*;
import java.util.*;

public class Main {
    static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        solved();
       //Unsolved();

    }

    public static void solved() {
        getDigitFrequency();
        getValueInBase();


    }


    public static void getDigitFrequency() {
        int n = scn.nextInt();
        int d = scn.nextInt();
        int f = getDigitFrequencyFunc(n, d);
        System.out.println(f);
    }

    public static int getDigitFrequencyFunc(int n, int d) {

        int freq = 0;
        if (n == 0)
            return 0;
        else {
            while (n != 0) {
                if (n % 10 == d)
                    freq++;
                n /= 10;
            }
        }
        return freq;

    }

//---------------------------------------------------------------


      public static void getValueInBase() {

          int n = scn.nextInt();
          int b = scn.nextInt();
          int dn = getValueInBaseFunc(n, b);
          System.out.println(dn);
      }

      public static int getValueInBaseFunc(int n, int b) {
          int rem, val = 0, i = 0;
          while(n != 0) {
            rem = n % b;
            val += rem * Math.pow(10,i);
            i ++;
            n = n / b;
          }
          return val;

      }

//---------------------------------------------------------------


      








}
