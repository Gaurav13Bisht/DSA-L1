import java.io.*;
import java.util.*;

public class Main {

    static Scanner scn = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        solved();
        //unsolved();
    }

    public static void solved() {
        basics();
        useOfequalsKeyword();
        palindromeAndSubSPalin();         // Palindrome And Sub String Palindrome
        stringBuilderUse();
        modifyString();
        toggleChars();
        stringCompression();
        stringPermutations();
        removePrime();
    }


    public static void basics() {

        String s;
        s = "Gaurav";

        intro(s);

        String s1 = scn.nextLine();

        PrintChars(s1);

        substrings(s1);

     }

    public static void intro(String s){

        //s[i] cannot be used in java to access String's character

        // s.charAt(i); is used

        System.out.println("Intro");

        System.out.println(s);

        System.out.println(s.charAt(4));

        System.out.println(s.substring(1,4));

        System.out.println(s.length());  //length is used as a function in strings

        System.out.println(s.substring(4));

     }

     public static void PrintChars(String s) {

        System.out.println("Print Characters : ");

        for(int i = 0; i < s.length(); i++) {
          System.out.println(s.charAt(i));
        }
     }

     public static void substrings(String s) {

        System.out.println("Sub strings :" );

        for(int i = 0; i < s.length(); i++)
          for(int j = i + 1; j <= s.length(); j++)
            System.out.println(s.substring(i,j));

     }

//-----------------------------------------------------------------

      public static void useOfequalsKeyword() {

          String s1 = "Hello";
          String s2 = "Hello";
          // "Hello" will be stored in 1 place only and its address will be
          // given to both s1 and s2

          s1 = s1 + 'e';
          // a new memory will be used where "Hello" will be copied and 'e' will be added to it.
          // THEREFORE TIME COMPLEXITY : O(n)

          s1 = "Hello";
          // To store "Hello" in new place we have to use keyword : new


          String s3 = new String("Hello");

          // == sign only compares the address :

          System.out.println(s1 == s2);    // TRUE

          System.out.println(s1 == s3);    // FALSE

          // to compare the characters we use "equals" :

          System.out.println(s1.equals(s3));  // TRUE

      }

//--------------------------------------------------------------------


      public static palindromeAndSubSPalin() {

          String s = scn.nextLine();
          System.out.println(palindrome(s));
          SubStringsPlndrm(s);

      }

      public static boolean palindrome(String s) {

          int left = 0, right = s.length() - 1 ;
          while(left <= right) {
            if(s.charAt(left) != s.charAt(right)) {
              return false;
            }
            left ++;
            right --;
          }

          return true;
      }

      public static void SubStringsPlndrm(String s) {

          System.out.println("Sub strings :" );
          for(int i = 0; i < s.length(); i++) {
            for(int j = i + 1; j <= s.length(); j++)
              if(palindrome(s.substring(i,j)))
                System.out.println(s.substring(i,j));
          }
      }

//-------------------------------------------------------------------

      public static void stringBuilderUse() {
          StringBuilder s = new StringBuilder("Hello");
          System.out.println(s);

          s.setCharAt(2, 'd');
          System.out.println(s);

          s.deleteCharAt(2);
          System.out.println(s);

          s.insert(2, 'p');
          System.out.println(s);

          s.append('d');
          System.out.println(s);
      }

//----------------------------------------------------------------


      public static void modifyString() {

          String s = scn.nextLine();
          System.out.println(modifyStringFunc(s) + "\n");

      }

      public static String modifyStringFunc(String s) {

          StringBuilder sb = new StringBuilder();
          for(int i = 0; i < s.length(); i++) {
            char ch1 = s.charAt(i);
            sb.append(ch1);
            if(i != s.length() - 1) {
              char ch2 = s.charAt(i + 1);
              int diff = ch2 - ch1;
              sb.append(diff);
            }
          }
          return sb.toString();

      }

//-----------------------------------------------------------------

      public static void toggleChars() {

          String s = scn.nextLine();

          System.out.println(togChars(s) + "\n");

          System.out.println(toggOdEvn(s));

      }

      public static String togChars(String s) {

          StringBuilder sb = new StringBuilder(s);

          for(int i = 0; i < sb.length(); i++) {
            char ch = sb.charAt(i);

            if(ch >= 'a' && ch <= 'z') {
              ch = (char)(ch - 'a' + 'A');
            }
            else if(ch >= 'A' && ch <= 'Z') {
              ch = (char)(ch + 'a' - 'A');
            }

            sb.setCharAt(i, ch);
          }
          return sb.toString();
        }

      public static String toggOdEvn(String s) {

            StringBuilder sb = new StringBuilder(s);
            for(int i = 0; i < sb.length(); i++) {
              char ch = sb.charAt(i);

              if(i % 2 ==0)
              ch = (char)(ch + 1);

              else
              ch = (char)(ch - 1);

              sb.setCharAt(i, ch);
            }
            return sb.toString();
          }
      }

//----------------------------------------------------------------


      public static void stringCompression() {

          String s = scn.nextLine();

          comp1(s);
          System.out.println();
          comp2(s);

      }

      public static void comp1(String s) {

          StringBuilder sb = new StringBuilder(s);
          for(int i = 0; i < sb.length(); i++) {
            char ch1 = sb.charAt(i);
            if(i != sb.length() - 1)
            {
              char ch2 = sb.charAt(i + 1);

              if(ch1 != ch2)
              System.out.print(ch1);
            }
            else
            System.out.print(ch1);
          }


        }

        public static void comp2(String s) {
            StringBuilder sb = new StringBuilder(s);
            int counter = 1;

            for(int i = 0; i < sb.length(); i++) {
              char ch1 = sb.charAt(i);
              if(i != sb.length() - 1)
              {
                char ch2 = sb.charAt(i + 1);

                if(ch1 != ch2) {
                  System.out.print(ch1);
                  if(counter != 1)
                  System.out.print(counter);
                  counter = 1;
                }
                else
                counter ++;
              }
              else
                System.out.print(ch1);
           }
       }

//------------------------------------------------------------------

       public static void stringPermutations() {

            String str = scn.next();
            int leng = str.length();
            int fact = factorial(leng);

            for(int i = 0; i < fact; i++){
              int itemp = i;
              StringBuilder str1 = new StringBuilder(str);

              for(int divs = leng; divs > 0; divs--){
                int rem = itemp % divs;
                System.out.print(str1.charAt(rem));
                str1.deleteCharAt(rem);
                itemp /= divs;
              }
              System.out.println();
            }
          }

       public static int factorial(int n){
            int tfact = 1;
            for(int i = n; i > 1; i--){
              tfact *= i;
            }
            return tfact;
      }

//--------------------------------------------------------------

      public static void removePrime() {

          int n = scn.nextInt();
          ArrayList<Integer> al = new ArrayList<>();
          for(int i = 0 ; i < n; i++){
            al.add(scn.nextInt());
          }
          solution(al);
          System.out.println(al);
        }

      public static void solution(ArrayList<Integer> al){
          int size = al.size();
          for(int i = 0, k = 0; k < size; i++, k++){
            int check = 0;
            for(int j = 2; j * j <= al.get(i); j++){
              if(al.get(i) % j == 0){
                check++;
                break;
              }
              else
              continue;
            }
            if(check == 0){
              al.remove(i);
              i--;
            }

         }

     }


//---------------------------------------------------------------------


}
