import java.util.*;

public class Main {
    static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        solved();
       //Unsolved();

    }

    public static void solved() {
        pattern1();
        pattern2();
        pattern3();


    }


    public static void pattern1() {
        /*    5
              *
              * *
              * * *
              *	* *	*
              * * *	* *
        */

          int n = scn.nextInt();
          for(int i = 1 ; i <= n ; i++){
              for(int j = 1 ; j <=i ;j++)
              System.out.print("*	");
              System.out.println();

          }

    }



    public static void pattern2() {
          /*    5
                *	*	*	*	*
                *	*	*	*
                *	*	*
                *	*
                *
        */

            int n = scn.nextInt();
            for(int i = 1 ; i <= n ; i++){
              for(int j = n ; j >=i ; j--)
                        System.out.print("*	");
               System.out.println();

           }


     }


     public static void pattern3() {
         /*    5
                        *
                      *	*
                    *	*	*
                  *	*	*	*
                *	*	*	*	*
        */
          
          int n = scn.nextInt();
          for (int i = 1; i <= n; i++) {
              for (int j = 1; j <= n; j++)
                if (j >= n - i + 1)
                    System.out.print("*	");
                else
                    System.out.print("	");

            System.out.println();
        }


    }







}
