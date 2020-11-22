import java.io.*;
import java.util.*;

public class Main {
    static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        solved();
        //Unsolved();

    }

    public static void solved() {
        getSubsequence();
        getKPC();
        getStairPaths();
        getMazePaths();
        getMazePathsWithJumps();
    }



    public static void getSubsequence() {

        String str = scn.next();
        ArrayList<String> str1 = gss(str);
        System.out.print(str1);
    }

    public static ArrayList<String> gss(String str) {

        if(str.length() == 0){
            ArrayList<String> bcase = new ArrayList<String>();
            bcase.add("");
            return bcase;
        }

        ArrayList<String> str1 = gss(str.substring(1));
        char ch = str.charAt(0);

        ArrayList<String> str2 = new ArrayList<String>(); // to avoid duplicacy

        for(String prevstring : str1){
            str2.add("" + prevstring);
        }


        for(String prevstring : str1){
            str2.add(ch + prevstring);
        }

        return str2;

    }

//--------------------------------------------------------------------------

    public static void getKPC() {

        String str = scn.next();
        ArrayList < String > res = getKPCRF(str);
        System.out.print(res);

    }
    static String[] codes = {".;","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};
    public static ArrayList < String > getKPCRF(String str) {
        if (str.length() == 0) {
            ArrayList < String > bcase = new ArrayList < > ();
            bcase.add("");
            return bcase;
        }
        char ch = str.charAt(0);
        ArrayList < String > str1 = getKPCRF(str.substring(1));
        ArrayList < String > str3 = new ArrayList < > ();

        String curr = codes[ch - '0'];

        for(int i = 0; i < curr.length(); i++){
            for(String st : str1)
                str3.add(curr.charAt(i) + st);
        }

        return str3;

    }

//---------------------------------------------------------------------

    public static void getStairPaths() {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        ArrayList<String> str = getStairPathsRF(n,0);
        System.out.print(str);
    }

    //This is my approach for going from Down to top of the stairs

    public static ArrayList<String> getStairPathsRF(int n,int idx) {
        if(idx == n){
            ArrayList < String > bcase = new ArrayList < > ();
            bcase.add("");
            return bcase;
        }
        else if(idx > n){
            ArrayList < String > bcase = new ArrayList < > ();
            return bcase;
        }

        ArrayList < String > path1 = getStairPathsRF(n, idx + 1);

        ArrayList < String > path2 = getStairPathsRF(n, idx + 2);

        ArrayList < String > path3 = getStairPathsRF(n, idx + 3);

        ArrayList < String > paths =  new ArrayList < > ();


        for(String str1 : path1)
            paths.add(1 + str1);

        for(String str2 : path2)
            paths.add(2 + str2);

        for(String str3 : path3)
            paths.add(3 + str3);



        return paths;
    }

//-----------------------------------------------------------------------

    public static void getMazePaths() {

        int n = scn.nextInt();
        int m = scn.nextInt();
        ArrayList<String> str = getMazePathsRF(1, 1, n, m);
        System.out.print(str);
    }

    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    public static ArrayList<String> getMazePathsRF(int sr, int sc, int dr, int dc) {

        if(sr == dr && sc == dc){
            ArrayList<String> reached = new ArrayList<>();
            reached.add("");
            return reached;
        }

        if(sr > dr || sc > dc){
            ArrayList<String> blank = new ArrayList<>();
            return blank;
        }


        ArrayList<String> hpaths = getMazePathsRF(sr, sc + 1, dr, dc);
        ArrayList<String> vpaths = getMazePathsRF(sr + 1, sc, dr, dc);

        ArrayList<String> paths = new ArrayList<>();

        for(String hpath : hpaths){
            paths.add('h' + hpath);
        }

        for(String vpath : vpaths){
            paths.add('v' + vpath);
        }

        return paths;

    }

//----------------------------------------------------------------------

    public static void getMazePathsWithJumps() {

        int n = scn.nextInt();
        int m = scn.nextInt();
        ArrayList < String > str = getMazePathsWithJumpsRF(1, 1, n, m);
        System.out.print(str);
    }

    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    public static ArrayList < String > getMazePathsWithJumpsRF(int sr, int sc, int dr, int dc) {

        if (sr == dr && sc == dc) {
            ArrayList < String > reached = new ArrayList < > ();
            reached.add("");
            return reached;
        }

        ArrayList < String > paths = new ArrayList < > ();

        for (int hz = 1; hz <= dc - sc; hz++){

            ArrayList < String > hpaths = getMazePathsWithJumpsRF(sr, sc + hz, dr, dc);

            for(String hpath : hpaths){
            paths.add("h" + hz + hpath);
            }

        }
        for (int vr = 1; vr <= dr - sr; vr++){

            ArrayList < String > vpaths = getMazePathsWithJumpsRF(sr + vr, sc, dr, dc);

            for(String vpath : vpaths){
            paths.add("v" + vr + vpath);
            }
        }
         for (int dg = 1; dg <= dr - sr && dg <= dc - sc; dg++){

            ArrayList < String > dpaths = getMazePathsWithJumpsRF(sr + dg, sc + dg, dr, dc);

            for(String dpath : dpaths){
            paths.add("d" + dg + dpath);
            }

        }
        return paths;

    }

//--------------------------------------------------------------------------

}
