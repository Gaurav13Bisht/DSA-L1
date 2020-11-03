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
        pattern6();
        pattern7();
        pattern8();
        pattern9();
        pattern10();
        pattern11();
        pattern12();


    }


    public static void pattern1() {
        /*    5
              *
              * *
              * * *
              *	* * *
              * * * * *
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
     	      *		*	*	*	*
			*	*	*	*
				*	*	*
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


      public static void pattern6() {
	 /*  5
             *	*  *	*  *  *
	     *	*	   *  *
	     *		      *
	     *	*          *  *
	     *	*  *    *  *  *
         */


          int n = scn.nextInt();
          int st = n / 2 + 1, sp = 1;
          for (int i = 1; i <= n; i++) {
              for (int j = 1; j <= st; j++)
                  System.out.print("*	");

            for (int j = 1; j <= sp; j++)
                System.out.print("	");

            for (int j = 1; j <= st; j++)
                System.out.print("*	");


            System.out.println();
            if (i <= n / 2) {
                st--;
                sp += 2;
            } else {
                st++;
                sp -= 2;
            }
          }


      }


      public static void pattern7() {
	   /*   5
	        *
		    *
		 	*
			    *
				*
           */
          int n = scn.nextInt();
          int sp = 0;
          for (int i = 1; i <= n; i++) {
              for (int j = 1; j <= sp; j++)
                  System.out.print("	");

              System.out.println("*");
                sp++;
          }
     }


     public static void pattern8() {
	/*  5
	    					*
					*
				*
			*
		*
	*/

          int n = scn.nextInt();
          int sp = n - 1;
          for (int i = 1; i <= n; i++) {
              for (int j = 1; j <= sp; j++)
                  System.out.print("	");

              System.out.println("*	");
              sp--;
        }

     }


     public static void pattern9() {
	/*   5
	   *				*
		*		*
			*
	 	*        	*
	   *				*
	*/
          int n = scn.nextInt(), st = 0;
          for (int i = 1; i <= n; i++) {
              for (int j = 1; j <= n; j++)
                  if (i == j || i + j == n + 1) {
                      System.out.print("*	");
                      st++;
                      if (st == 2)
                          break;

                }
                else
                  System.out.print("	");

                  System.out.println();


         }
     }


     public static void pattern10() {
        /*   5
		     	*
		*		*
	*				*
		*		*
			*
	*/

        int n = scn.nextInt();
        int os = n / 2, is = -1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= os; j++)
               System.out.print("	");
            System.out.print("*	");

           if (i == 1 || i == n) {} else {
               for (int j = 1; j <= is; j++)
                   System.out.print("	");
               System.out.print("*");

           }
           if (i <= n / 2) {
               os--;
               is += 2;
           } else {
               os++;
               is -= 2;
           }
           System.out.println();
       }


     }


     public static void pattern11() {
	/*   5
                1
		2	3
		4	5	6
		7	8	9	10
		11	12	13	14	15
	*/

          int n = scn.nextInt(), prin = 0;
          for(int i = 1; i<= n ;i++){
            for(int j = 1 ; j<=i ; j ++){
              prin++;
              System.out.print(prin + "	");

            }
            System.out.println();
          }

    }


    public static void pattern12() {

          int n = scn.nextInt(), a = 0 , b = 1,c;
          for(int i = 1; i<= n ;i++){
            for(int j = 1 ; j<=i ; j ++){
              System.out.print(a + "	");
              c = a + b;
              a = b;
              b = c;

            }
            System.out.println();
         }

    }


    















}
