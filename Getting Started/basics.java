import java.util.*;

public class Main {
    static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        solved();
       //Unsolved();

    }

    public static void solved() {

        primeCheck();
        primesTillN();
        fibonacciTillN();
        digitsInNum();
        reverseNum();
        inverseNum();

    }


    public static void primeCheck() {

        int t = scn.nextInt();
        for (int i = 1; i <= t; i++) {

            int prime = 0;
            int n = scn.nextInt();
            int limit = (int) Math.pow(n, 0.5);
            for (int j = 2; j <= limit; j++) // ( ; j * j <= n ;)
                if (n % j == 0) {
                    prime++;
                    break;
                }

            if (prime != 0)
                System.out.println("not prime");
            else
                System.out.println("prime");
        }


    }


    public static void primesTillN() {

       int low = scn.nextInt();
       int high = scn.nextInt();

       for (int i = low; i <= high; i++) {

           int Notprime = 0;
           for (int j = 2; j * j <= i; j++)
               if (i % j == 0) {
                   Notprime++;
                   break;
               }

           if (Notprime == 0)
               System.out.println(i);
       }
   }


   public static void fibonacciTillN(){

      int n = scn.nextInt();

      /*  MY APPROACH NAIVE

        int prev = 0;
      int f1 = 0, f2 = 1;
      System.out.println(f1);
      System.out.println(f2);
      for(int i = 3 ; i <= n ; i++ ){

         int current = f1 + f2;
         System.out.println(current);
         f1 = f2;
         f2 = current;
      */


       // SIR's APPROACH
       int a = 0, b = 1, c;
       for(int i = 0 ; i < n ; i++ ){

               System.out.println(a);
               c = a + b;
               a = b;
               b = c;

      }
    }


    public static void digitsInNum() {

        int n = scn.nextInt();
        int digits = 0;
        if(n != 0)
         while(n>=1)
      {
         digits++;
         n/=10;
      }

      System.out.println(digits);

    }


    public static void reverseNum() {

        int num = scn.nextInt();

        while(num != 0){
              int rem = num%10;
              System.out.println(rem);
              num = num/10;
        }
    }


    public static void inverseNum(){

        int num = scn.nextInt();
        int n1 = 0, rem, sum = 0;

        while (num != 0) {
           n1++;
           rem = num % 10;
           sum += n1 * ((int)Math.pow(10, rem - 1));
           num /= 10;

        }
        System.out.print(sum);

    }


















}
