import java.io.*;
import java.util.*;

public class Main {
    static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        solved();
        // Unsolved();

    }

    public static void solved() {

        printSubsequence();
        printKPC();
        printStairPaths();
        printMazePaths();
        printMPathsWithJumps();
    }

    public static void printSubsequence() {

        String str = scn.next();
        printSubsequenceRF(str, "");
    }

    public static void printSubsequenceRF(String ques, String ans) {

        if (ques.length() == 0) {
            System.out.println(ans);
            return;
        }

        char ch = ques.charAt(0);

        printSubsequenceRF(ques.substring(1), ans + ch);
        printSubsequenceRF(ques.substring(1), ans + "");

    }

    // -------------------------------------------------------------

    public static void printKPC() {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        printKPCRF(str, "");

    }

    static String[] codes = { ".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz" };

    // !!!!!!!!!!!!!! THIS APPROACH IS LEVELS AND OPTIONS !!!!!!!!!!!!!!

    public static void printKPCRF(String key, String ans) {

        if (key.length() == 0) {
            System.out.println(ans);
            return;
        }

        char ch = key.charAt(0);

        String sCode = codes[ch - '0'];
        for (int i = 0; i < sCode.length(); i++) {
            printKPCRF(key.substring(1), ans + sCode.charAt(i));
        }

    }

    // ------------------------------------------------------------------

    public static void printStairPaths() {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        printStairPathsRF(n, "");
    }

    public static void printStairPathsRF(int n, String path) {

        if (n == 0) {
            System.out.println(path);
            return;
        } else if (n < 0) {
            return;
        }

        printStairPathsRF(n - 1, path + '1');
        printStairPathsRF(n - 2, path + '2');
        printStairPathsRF(n - 3, path + '3');

    }

    // ------------------------------------------------------------------

    public static void printMazePaths() {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        printMazePathsRF(1, 1, n, m, "");
    }

    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    public static void printMazePathsRF(int sr, int sc, int dr, int dc, String psf) {
        if (sr == dr && sc == dc) {
            System.out.println(psf);
            return;
        } else if (sr > dr || sc > dc) {
            return;
        }
        printMazePathsRF(sr, sc + 1, dr, dc, psf + 'h');
        printMazePathsRF(sr + 1, sc, dr, dc, psf + 'v');
    }

    // -----------------------------------------------------------------------

    public static void printMPathsWithJumps() {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        printMPathsWithJumpsRF(1, 1, n, m, "");

    }
    // LEVELS AND OPTIONS APPROACH

    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    public static void printMPathsWithJumpsRF(int sr, int sc, int dr, int dc, String psf) {
        if (sr == dr && sc == dc) {
            System.out.println(psf);
            return;
        }

        for (int hz = 1; hz <= dc - sc; hz++)
            printMPathsWithJumpsRF(sr, sc + hz, dr, dc, psf + "h" + hz);

        for (int vr = 1; vr <= dr - sr; vr++)
            printMPathsWithJumpsRF(sr + vr, sc, dr, dc, psf + "v" + vr);

        for (int dg = 1; dg <= dr - sr && dg <= dc - sc; dg++)
            printMPathsWithJumpsRF(sr + dg, sc + dg, dr, dc, psf + "d" + dg);

    }

    // ----------------------------------------------------------------------------
}
