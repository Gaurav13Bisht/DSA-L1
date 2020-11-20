import java.io.*;
import java.util.*;

public class Main {
    static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
          solved();
          //Unsolved();

    }

    public static void solved() {
          displayArray();



    }


    public static void displayArray() {

          int n = scn.nextInt();
          int[] a = new int[n];
          for(int i = 0; i < n; i++){
              a[i] = scn.nextInt();
          }
          displayArrRF(a, n - 1);
   }

    public static void displayArrRF(int[] arr, int idx){
          if(idx == -1)
              return;
          displayArrRF(arr, idx - 1);
          System.out.println(arr[idx]);
    }

//-------------------------------------------------------------------





}
