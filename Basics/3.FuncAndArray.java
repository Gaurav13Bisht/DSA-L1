import java.io.*;
import java.util.*;

public class Main {
    static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        solved();
        Unsolved();

    }

    public static void solved() {
        // Function Based
        getDigitFrequency();
        getValueInBase();
        getValueIndecimal();
        anyBaseToDecimal();
        getSum();
        getDifference();

        // Array Based
        spanOfArray();   // max - min
        findElement();
        barchart();
        sumOfArrays();
        diffOfArrays();
        reverseArray();
        rotateArray();
        inverseArray();
        subArrays();
        subsetsOfArray();
        ceilAndFloor();

    }

    public static void Unsolved() {

        //getProduct();
    }


    public static void getDigitFrequency() {
        int n = scn.nextInt();
        int d = scn.nextInt();
        int f = getDigitFrequencyFunc(n, d);
        System.out.println(f);
    }

    public static int getDigitFrequencyFunc(int n, int d) {

        int freq = 0;
        if (n == 0)
            return 0;
        else {
            while (n != 0) {
                if (n % 10 == d)
                    freq++;
                n /= 10;
            }
        }
        return freq;

    }

//---------------------------------------------------------------


      public static void getValueInBase() {

          int n = scn.nextInt();
          int b = scn.nextInt();
          int dn = getValueInBaseFunc(n, b);
          System.out.println(dn);
      }

      public static int getValueInBaseFunc(int n, int b) {
          int rem, val = 0, i = 0;
          while(n != 0) {
            rem = n % b;
            val += rem * Math.pow(10,i);
            i ++;
            n = n / b;
          }
          return val;

      }

//---------------------------------------------------------------


      public static void getValueIndecimal() {

          int n = scn.nextInt();
          int b = scn.nextInt();
          int d = getValueIndecimalFunc(n, b);
          System.out.println(d);
        }

     public static int getValueIndecimalFunc(int n, int b){
          int rem, val = 0, i = 0;
          while( n != 0) {
            rem = n % 10;
            val += rem * Math.pow(b,i);
            i++;
            n = n / 10;
          }
          return val;
     }

//---------------------------------------------------------------


      public static void anyBaseToDecimal() {

          int n = scn.nextInt();
          int sourceBase = scn.nextInt();
          int  destBase= scn.nextInt();
          int nIntoDec = anyBaseToDecimalFunc(n, sourceBase);
          int decIntoDestBase = decimalToAnyBase(nIntoDec, destBase);
          System.out.print(decIntoDestBase);
      }

      public static int anyBaseToDecimalFunc(int n, int b){
          int rem, val1 = 0, i = 0;
          while( n != 0) {
            rem = n % 10;
            val1 += rem * Math.pow(b,i);
            i++;
            n = n / 10;
          }
          return val1;
      }

      public static int decimalToAnyBase(int n, int b) {
          int rem, val2 = 0, i = 0;
          while(n != 0) {
            rem = n % b;
            val2 += rem * Math.pow(10,i);
            i ++;
            n = n / b;
          }
          return val2;

    }

//---------------------------------------------------------------


    public static void getSum() {
          int b = scn.nextInt();
          int n1 = scn.nextInt();
          int n2 = scn.nextInt();

          int  d = getSumFunc(b, n1, n2);
          System.out.println(d);
    }

    public static int getSumfunc(int b, int n1, int n2) {
          int rem1, rem2, carry = 0, i = 0, added, addval = 0;

          while (n1 != 0 || n2 != 0) {
            rem1 = n1 % 10;
            rem2 = n2 % 10;
            if (carry + rem1 + rem2 < b) {
            added = carry + rem1 + rem2;
            addval += added * Math.pow(10, i);
            i++;
            carry = 0;
        } else {
            added = carry + (rem1 + rem2) - b;
            carry = 1;
            addval += added * Math.pow(10, i);
            i++;
        }

          n1 = n1/10;
          n2 = n2/10;

          if(n1 == 0 && n2 == 0 && carry == 1)
              addval += carry * Math.pow(10, i);
       }

          return addval;
    }

//---------------------------------------------------------------


      public static void getDifference(); {

          int b = scn.nextInt();
          int n1 = scn.nextInt();
          int n2 = scn.nextInt();

          int d = getDifferenceFunc(b, n1, n2);
          System.out.println(d);
      }

      public static int getDifferenceFunc(int b, int n1, int n2) {
          int borrow = 0, p = 1, rem2, rem1, fval = 0;
          while (n1 != 0 || n2 != 0 || borrow != 0) {
            rem2 = n2 % 10;
            rem1 = n1 % 10;
            rem2 -= borrow;
            if (rem2 >= rem1) {
              fval += (rem2 - rem1) * p;
              p *= 10;
              borrow = 0;
            } else {
                fval += ((rem2 + b) - rem1) * p;
                p *= 10;
                borrow = 1;
              }
            n2 /= 10;
            n1 /= 10;
          }
          return fval;

     }

//---------------------------------------------------------------
//---------------------------------------------------------------


      public static void spanOfArray() {

          int n = scn.nextInt();
          int[] garray = new int[n];
          for (int i = 0; i < n; i++) {
              garray[i] = scn.nextInt();
          }

          int max = garray[0], min = garray[0];

          for (int i = 1; i < n; i++) {
              if (garray[i] > max)
                  max = garray[i];
              else
                  if (garray[i] < min)
                  min = garray[i];

          }
          System.out.println(max - min);

      }

//---------------------------------------------------------------


      public static void findElement() {

          int n = scn.nextInt();
          int[] garray = new int[n];
          for (int i = 0; i < garray.length; i++) {
            garray[i] = scn.nextInt();
          }

          int d = scn.nextInt();
          int pos = -1;

          for (int i = 0; i < garray.length; i++) {
              if (d == garray[i]) {
                pos = i;
                break;
              }
          }
          System.out.println(pos);

     }

//---------------------------------------------------------------


      public static void barchart() {

          int n = scn.nextInt();
          int[] garray = new int[n];
          for(int i = 0; i < n; i++) {
              garray[i] = scn.nextInt();
          }

          int max = garray[0];

          for(int i = 0; i < n; i++)
            if(garray[i] > max)
              max = garray[i];

              // MY SOLUTION
              /*    int[] Sparray = new int[n];
                    for(int i = 0; i < n; i++) {
                    Sparray[i] = max - garray[i];
                  }

                    for(int i = 0; i < max; i++) {
                    for(int j = 0; j < n; j++) {
                    if(Sparray[j] != 0){
                    System.out.print("	");
                    Sparray[j]--;
                  }
                  else
                      System.out.print("*	");
                }
                if(i != max-1)
                System.out.println();
              }

              */

              // SIR's BETTER APPROACH WITH LESS SPACE COMPLEXITY


           for(int curfloor = max; curfloor > 0; curfloor--) {
                for(int i = 0; i < n; i++){
                  if(garray[i] >= curfloor) {
                    System.out.print("*	");
                  }
                  else
                      System.out.print("	");
                  }
                  if(curfloor != 0)
                     System.out.println();
          }
     }

//---------------------------------------------------------------


     public static void sumOfArrays() {

            int n1 = scn.nextInt();
            int[] ga1 = new int[n1];
            for (int m = 0; m < n1; m++)
                ga1[m] = scn.nextInt();

            int n2 = scn.nextInt();
            int[] ga2 = new int[n2];
            for (int m = 0; m < n2; m++)
                ga2[m] = scn.nextInt();

            int[] sum = new int[n1 > n2 ? n1 : n2];

            int i = ga1.length - 1;
            int j = ga2.length - 1;
            int k = sum.length - 1;
            int c = 0;
            int tempsum = 0;

            while (k >= 0) {
              tempsum = c;
              if(i >= 0)
                tempsum += ga1[i];

              if(j >= 0)
                tempsum += ga2[j];

              sum[k] = tempsum % 10;
              c = tempsum / 10;

              i--;
              j--;
              k--;
            }
            if(c != 0)
                System.out.println(c);


            for(int val : sum)
                System.out.println(val);

     }

//---------------------------------------------------------------


      public static void diffOfArrays() {

            int n1 = scn.nextInt();
            int[] ga1 = new int[n1];
            for (int m = 0; m < n1; m++)
            ga1[m] = scn.nextInt();

            int n2 = scn.nextInt();
            int[] ga2 = new int[n2];
            for (int m = 0; m < n2; m++)
            ga2[m] = scn.nextInt();



            int[] diff = new int[n1>n2?n1: n2];

            int i = ga1.length - 1;
            int j = ga2.length - 1;
            int k = diff.length - 1;
            int b = 0;
            int tempdiff = 0;

            while (k >= 0) {
                tempdiff = b;
                if (i >= 0) {
                  if(n2 > n1)
                  ga1[i] = -ga1[i];

                  tempdiff += ga1[i];
            }
            if (j >= 0){
                if(n2 > n1)
                ga2[j] = -ga2[j];

                tempdiff -= ga2[j];
            }
            if (tempdiff < 0) {
                b = -1;
                tempdiff += 10;
            }
            else
              b = 0;

            diff[k] = tempdiff;

            i--;
            j--;
            k--;
          }

          int frontzerocheck = 0;
          for (int z = 0; z < diff.length; z++) {
              if (diff[z] == 0 && frontzerocheck == 0) {
                continue;
          } else {
              System.out.println(diff[z]);
              frontzerocheck = 1;
            }
     }

//---------------------------------------------------------------

     public static void reverseArray() {
       // Faster input
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

       int n = Integer.parseInt(br.readLine());
       int[] a = new int[n];
       for (int i = 0; i < n; i++) {
           a[i] = Integer.parseInt(br.readLine());
       }

        reverseArrayFunc(a);
    }

    public static void reverseArrayFunc(int[] a) {
          // using two pointers
          int i = 0, j = a.length - 1;
          while(i < j) {
              int temp = a[i];
              a[i] = a[j];
              a[j] = temp;
              i++;
              j--;
          }

          StringBuilder sb = new StringBuilder();
          for (int val: a) {
            sb.append(val + " ");
          }
          System.out.println(sb);

     }

//---------------------------------------------------------------

      public static void rotateArray() {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            int n = Integer.parseInt(br.readLine());
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
              a[i] = Integer.parseInt(br.readLine());
              }
              int k = Integer.parseInt(br.readLine());

              rotateArrayFunc(a, k);
        }

      public static void rotateArrayFunc(int[] a, int k) {
               k %= a.length;
               if(k < 0)
               k = k + a.length;

               reverseArrayFunc(a,0,a.length - k - 1);
               reverseArrayFunc(a,a.length - k, a.length - 1);
               reverseArrayFunc(a,0,a.length - 1);

               StringBuilder sb = new StringBuilder();

               for (int val: a) {
                 sb.append(val + " ");
               }
               System.out.println(sb);

           }




     public static void reverseArrayFunc(int[] b, int i, int j){
          while(i < j){
              int temp = b[i];
              b[i] = b[j];
              b[j] = temp;
              i++;
              j--;
            }
    }

//---------------------------------------------------------------
      public static void inverseArray() {
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

          int n = Integer.parseInt(br.readLine());
          int[] a = new int[n];
          for(int i = 0; i < n; i++){
              a[i] = Integer.parseInt(br.readLine());
          }

          int[] inv = inverseArrayFunc(a);

          StringBuilder sb = new StringBuilder();
            for(int val: inv){
            sb.append(val + "
            ");
          }
          System.out.println(sb);
        }

      public static int[] inverseArrayFunc(int[] a){
            int[] inv = new int[a.length];
            for(int i = 0; i < a.length; i++){
              int v = a[i];
              inv[v] = i;

            }
            return inv;
    }

//---------------------------------------------------------------

    public static void subArrays() {

      /*    3 10 20 30

            10
            10	20
            10	20	30
            20
            20	30
            30
      */

        int n1 = scn.nextInt();
        int[] ga1 = new int[n1];
        for (int m = 0; m < n1; m++)
            ga1[m] = scn.nextInt();

        for(int i = 0; i < n1; i++){
            for(int j = i ; j < n1; j++){
                for(int k = i; k <= j ; k++){
                    System.out.print(ga1[k] + "	");
                }
                System.out.println();
            }
         }
     }

//---------------------------------------------------------------


     public static void subsetsOfArray() {

         /*   3 10 20 30

              -	-	-
              -	-	30
              -	20	-
              -	20	30
              10	-	-
              10	-	30
              10	20	-
              10	20	30
        */

          int n1 = scn.nextInt();
          int[] ga1 = new int[n1];
          for (int m = 0; m < n1; m++)
            ga1[m] = scn.nextInt();

          for(int i = 0; i < (int)Math.pow(2,ga1.length); i++){
              int temp = i;
              String store = "";
              for(int j = ga1.length - 1; j >= 0; j--){
                if(temp % 2 == 0)
                  store = "-	" + store;
                else
                  store = ga1[j] + "	" + store;
                temp/=2;
              }
              System.out.println(store);
           }
     }

//---------------------------------------------------------------

      public static void ceilAndFloor() {

            int n = scn.nextInt();
            int[] g = new int[n];
            for(int i = 0; i < n; i++){
              g[i] = scn.nextInt();
            }
            int key = scn.nextInt();

            int l, h;
                  //MY APPROACH
            /*    l = 0;
                  h = g.length - 1;
                  int mid = 0;
                  while(l + 1 < h){
                    mid = (l + h)/2;

                    if(g[mid] < key)
                    l = mid;
                    else
                    if(g[mid] > key)
                    h = mid;

                    else{
                    System.out.print(g[mid] + "
                    " + g[mid]);
                    break;
                  }

                  if(g[l + 1] == g[h]){
                    System.out.print(g[h] + "
                    " + g[l]);
                    break;
                  }
                }
                */

                //SIR's APPROACH

                l = 0;
                h = g.length - 1;
                int mid = 0;
                int ceil = h , floor = l;
                while(l <= h){
                  mid = (l + h)/2;

                  if(g[mid] < key){
                    l = mid + 1;
                    floor = mid;

                  }
                  else
                  if(g[mid] > key){
                    h = mid - 1;
                    ceil = mid;
                  }

                  else{
                    ceil = mid;
                    floor = mid;
                    break;
                  }

                }
                System.out.print(g[ceil] + "
                " + g[floor]);
      }

//---------------------------------------------------------------











}
