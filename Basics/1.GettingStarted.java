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
        rotateNum();
        gcdLcm();
        primeFactors();
        pythagoreanTriplets();
        benjaminBulbs();

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


    public static void rotateNum() {

        int n = scn.nextInt();
        int k = scn.nextInt();
        int n1 = n, digits = 0;

           while (n1 >= 1) {
               digits++;
               n1 /= 10;}
           k %= digits;

           /* MY APPROACH!!!!!!!!!!!!
           int mult = (int) Math.pow(10, digits - 1);
           if (k > 0)
            for (int i = 1; i <= k; i++) {

               if (k % digits == 0)
                   break;
               else {
                   int rem = n % 10;
                   n /= 10;
                   n += rem * mult;
                  }
             }

           else
           for (int i = 1; i <= -k; i++) {

               if (-k % digits == 0)
                   break;
               else {
                   int quot = n / mult;
                   n %= mult;
                   n = n * 10 + quot;
               }
           }

           System.out.print(n);
           */

           //SIR's APPROACH!!!!!!!!!!!!!!!!

       if(k<0){
             k = digits - (-k);
       }

       int forSplit = (int)Math.pow(10,k);
       int forAdd   = (int)Math.pow(10, digits - k);

       int rem = n % forSplit;
       int quot = n / forSplit;

       n = quot + rem * forAdd;

       System.out.print(n);


   }


   public static void gcdLcm() {

       int n1 = scn.nextInt();
       int n2 = scn.nextInt();

       int divd = n1;
       int divs = n2;

       while( divd % divs != 0){

           int rem = divd % divs;
           divd = divs;
           divs = rem;

       }

       int gcd = divs;

       int lcm = (n1 * n2)/gcd;   // lcm*gcd = n1*n2

       System.out.println(gcd);
       System.out.println(lcm);
   }


   public static void primeFactors() {

        int n = scn.nextInt();
        int rem, i = 2;
        if (n == 1)
            System.out.print(1);
        else
            while (n != 1) {
                rem = n % i;
                if (rem == 0) {
                    n /= i;
                    System.out.print(i + " ");
                } else
                    i++;
            }

    }


    public static void pythagoreanTriplets() {

         int n1 = scn.nextInt();
         int n2 = scn.nextInt();
         int n3 = scn.nextInt();

         if (n1 > n2) {
             int temp = n2;
             n2 = n1;
             n1 = temp;
         }
         if (n2 > n3) {
             int temp = n3;
             n3 = n2;
             n2 = temp;

         }

        /* if (n3 * n3 == n2 * n2 + n1 * n1)
            System.out.print("true");
        else
            System.out.print("false");
        */

        //USING BOOLEAN dataType

             boolean result = ((n3 * n3) == (n2 * n2 + n1 * n1));

                System.out.print(result);

    }


    public static void benjaminBulbs() {

        int n = scn.nextInt();

        for(int i = 1; i * i <= n ; i++) {
                System.out.println(i * i);

        }

   }




}
