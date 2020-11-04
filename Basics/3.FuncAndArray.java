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

    










}
