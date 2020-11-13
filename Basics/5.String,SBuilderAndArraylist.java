import java.io.*;
import java.util.*;

public class Main {

    static Scanner scn = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        solved();
        unsolved();
    }

    public static void solved() {
        basics();
        useOfequalsKeyword();
        palindromeAndSubSPalin();         // Palindrome And Sub String Palindrome
        stringBuilderUse();
        modifyString();
    }

    public static void unsolved() {

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




}
