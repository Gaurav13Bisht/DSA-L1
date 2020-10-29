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
        pattern4();
        pattern5();


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


      public static void pattern4() {
       /*   5
            *	*	*	*	*
	            * *	*	*
		            * *	*
			            *	*
				            *
       */


          int n = scn.nextInt();
            /* for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++)
                  if (j < i)
                   System.out.print("	");
               else
                   System.out.print("*	");

              System.out.println();


           }
          */
          int sp = 0, st = n;
          for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sp; j++)
               System.out.print("	");

           for (int j = 1; j <= st; j++)
               System.out.print("*	");

           sp++;
           st--;

           System.out.println();
          }

     }


     public static void pattern5() {
       /*  5
                  *
                *	*	*
              *	*	*	*	*
                *	*	*
                  *
      */
        int n = scn.nextInt();
        int st = 1 , sp = n/2;
        for(int i = 1 ; i <= n ; i++){
            for(int j = 1 ; j <= sp ; j++)
                System.out.print("	");

            for(int j = 1 ; j <= st ; j++)
                System.out.print("*	");

                if( i <= n/2){
                    st+=2;
                    sp--;
                }
                else{
                    st-=2;
                    sp++;
                }

                System.out.println();

             }


      }







}
