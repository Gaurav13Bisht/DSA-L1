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
}
