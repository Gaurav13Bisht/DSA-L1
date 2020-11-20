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
          displayArrRev();
          maxOfArray();
          firstIndex();
          lastIndex();
          allIndices();
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

    public static void displayArrRev() {

          int n = scn.nextInt();
          int[] a = new int[n];
          for(int i = 0; i < n; i++){
              a[i] = scn.nextInt();
          }
          displayArrRevRF(a, n - 1);
    }

    public static void displayArrRevRF(int[] arr, int idx){
          if(idx == -1)
              return;

          System.out.println(arr[idx]);
          displayArrRevRF(arr, idx - 1);

    }

//-------------------------------------------------------------------

    public static void maxOfArray() {

        int n = scn.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = scn.nextInt();
        }
        System.out.print(maxOfArrayRF(a, n - 1));

    }

    public static int maxOfArrayRF(int[] arr, int idx){
        if(idx == 0)
            return arr[0];

        int temp = maxOfArrayRF(arr,idx - 1);
        if(arr[idx] > temp)
            return arr[idx];
        else
            return temp;

    }

//--------------------------------------------------------------

    public static void firstIndex() {

        int n = scn.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = scn.nextInt();
        }

        int key = scn.nextInt();
        System.out.print(firstIndexRF(a, 0, key));

    }

    public static int firstIndexRF(int[] arr, int idx, int x){

        if(idx == arr.length)
            return -1;
        else if(arr[idx] == x)
            return idx;

        int fid = firstIndexRF(arr, idx + 1, x);


        return fid;
    }

//-------------------------------------------------------------------

    public static void lastIndex() {

          int n = scn.nextInt();
          int[] a = new int[n];
          for(int i = 0; i < n; i++){
              a[i] = scn.nextInt();
            }

            int x = scn.nextInt();
            /*   First Approach!!!!!!!!!!!!!!!
            System.out.print(lastIndex(a, n - 1, x));

          }

          public static int lastIndex(int[] arr, int idx, int x){
                if(idx == -1)
                    return -1;
                else if(arr[idx] == x)
                  return idx;

                  int lid = lastIndex(arr, idx - 1, x);

                  return lid;
                }
                */

                //SECOND APPROACH!!!!!!!!!!!!!!!!!!

                System.out.print(lastIndexRF(a, 0, x));

    }

     public static int lastIndexRF(int[] arr, int idx, int x){

          if(idx == arr.length)
              return -1;

              int lidx = lastIndexRF(arr, idx + 1, x);
              if(lidx == -1){
                if(arr[idx] == x)
                  return idx;

                  else
                  return -1;
                }

                else{
                  return lidx;

                }
    }

//---------------------------------------------------------------------

    public static void allIndices() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int x = Integer.parseInt(br.readLine());
        int[] iarr = allIndicesRF(arr, x, 0, 0);

        if(iarr.length == 0){
            System.out.println();
            return;
        }

        for(int i = 0; i < iarr.length; i++){
            System.out.println(iarr[i]);
        }
    }

    public static int[] allIndicesRF(int[] arr, int x, int idx, int fsf) {

        if(idx == arr.length){
            return new int[fsf];
        }

        if(arr[idx] == x){
            int[] indices = allIndicesRF(arr, x, idx + 1, fsf + 1);
            indices[fsf] = idx;
            return indices;

        }
        else{
            int[] indices = allIndicesRF(arr, x, idx + 1, fsf);
            return indices;
        }

    }

//------------------------------------------------------------------------


}
