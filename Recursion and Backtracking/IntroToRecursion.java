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
       

    }

    
    public static void printDecreasing(){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        RFprintDecreasing(n);
    }

    public static void RFprintDecreasing(int n){	 //!!! RFfunctionName : RF = Recursive Function !!!
  	if(n == 0)
            return;
        System.out.println(n);
        RFprintDecreasing(n - 1);
    }

//---------------------------------------------------------------

    










}
