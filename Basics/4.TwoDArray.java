import java.io.*;
import java.util.*;

public class Main {

    static Scanner scn = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        solved();
        //unsolved();
    }

    public static void solved() {
        matrixMult();
        waveTraversal();
    }

    public static void unsolved() {

    }

    public static void matrixMult() {

        int n1 = scn.nextInt();
        int m1 = scn.nextInt();

        int[][] g1 = new int[n1][m1];

        for (int i = 0; i < n1; i++)
            for (int j = 0; j < m1; j++)
                g1[i][j] = scn.nextInt();

        int n2 = scn.nextInt();
        int m2 = scn.nextInt();

        int[][] g2 = new int[n2][m2];

        for (int i = 0; i < n2; i++)
            for (int j = 0; j < m2; j++)
                g2[i][j] = scn.nextInt();

        if (m1 == n2) {

            int[][] prd = new int[n1][m2];

            for (int i = 0; i < n1; i++) {
                for (int j = 0; j < m2; j++) {
                    for (int k = 0; k < m1; k++)
                        prd[i][j] += g1[i][k] * g2[k][j];

                    System.out.print(prd[i][j] + " ");
                }
                System.out.println();
            }

        } else
            System.out.print("Invalid input");


     }

//-------------------------------------------------------------------


      public static void waveTraversal() {

            int n = scn.nextInt();
            int m = scn.nextInt();

            int[][] g = new int[n][m];

            for(int i = 0; i < n; i++)
              for(int j = 0; j < m; j++)
                g[i][j] = scn.nextInt();

                // My 2 solutions :

          /*  for(int i = 0; i < m; i++) {
                  if(i % 2 == 0){
                  for(int j = 0; j < n; j++){
                    System.out.println(g[j][i]);
                  }
                }
                else
                  for(int j = n - 1; j >= 0; j--){
                    System.out.println(g[j][i]);
                  }
                }
        */
            for(int i = 0; i < m; i++) {
              for(int j = 0; j < n; j++){
                System.out.println(g[j][i]);

              }

              if(i < m -1) {
                  i++;
                  for(int j = n - 1; j >= 0; j--){
                    System.out.println(g[j][i]);
                  }

              }
            }


     }

//------------------------------------------------------------------






}
