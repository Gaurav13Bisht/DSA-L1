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
        getValueIndecimal();
        anyBaseToDecimal();
        getSum();



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


      public static void getValueIndecimal() {

          int n = scn.nextInt();
          int b = scn.nextInt();
          int d = getValueIndecimalFunc(n, b);
          System.out.println(d);
        }

     public static int getValueIndecimalFunc(int n, int b){
          int rem, val = 0, i = 0;
          while( n != 0) {
            rem = n % 10;
            val += rem * Math.pow(b,i);
            i++;
            n = n / 10;
          }
          return val;
     }

//---------------------------------------------------------------


      public static void anyBaseToDecimal() {

          int n = scn.nextInt();
          int sourceBase = scn.nextInt();
          int  destBase= scn.nextInt();
          int nIntoDec = anyBaseToDecimalFunc(n, sourceBase);
          int decIntoDestBase = decimalToAnyBase(nIntoDec, destBase);
          System.out.print(decIntoDestBase);
      }

      public static int anyBaseToDecimalFunc(int n, int b){
          int rem, val1 = 0, i = 0;
          while( n != 0) {
            rem = n % 10;
            val1 += rem * Math.pow(b,i);
            i++;
            n = n / 10;
          }
          return val1;
      }

      public static int decimalToAnyBase(int n, int b) {
          int rem, val2 = 0, i = 0;
          while(n != 0) {
            rem = n % b;
            val2 += rem * Math.pow(10,i);
            i ++;
            n = n / b;
          }
          return val2;

    }

//---------------------------------------------------------------


    public static void getSum() {
          int b = scn.nextInt();
          int n1 = scn.nextInt();
          int n2 = scn.nextInt();

          int  d = getSumFunc(b, n1, n2);
          System.out.println(d);
    }

    public static int getSumfunc(int b, int n1, int n2) {
          int rem1, rem2, carry = 0, i = 0, added, addval = 0;

          while (n1 != 0 || n2 != 0) {
            rem1 = n1 % 10;
            rem2 = n2 % 10;
            if (carry + rem1 + rem2 < b) {
            added = carry + rem1 + rem2;
            addval += added * Math.pow(10, i);
            i++;
            carry = 0;
        } else {
            added = carry + (rem1 + rem2) - b;
            carry = 1;
            addval += added * Math.pow(10, i);
            i++;
        }

          n1 = n1/10;
          n2 = n2/10;

          if(n1 == 0 && n2 == 0 && carry == 1)
              addval += carry * Math.pow(10, i);
       }

          return addval;
    }

//---------------------------------------------------------------








}
