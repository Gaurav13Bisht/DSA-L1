import java.io.*;
import java.util.*;

public class Main {
    static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        solved();
        // Unsolved();

    }

    public static void solved() {

        floodfill();
        printTargetSumSubsets();
        nQueens();
        knightsTour();
    }

    public static void floodfill() {

        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = scn.nextInt();

            }
        }
        boolean[][] visited = new boolean[n][m];

        floodfillRF(arr, 0, 0, "", visited);

    }

    public static void floodfillRF(int[][] maze, int row, int col, String psf, boolean[][] visited) {
        if (row < 0 || col < 0 || row == maze.length || col == maze[0].length || maze[row][col] == 1
                || visited[row][col] == true) {
            return;
        } else if (row == maze.length - 1 && col == maze[0].length - 1) {
            System.out.println(psf);
            return;
        }

        visited[row][col] = true;
        floodfillRF(maze, row - 1, col, psf + "t", visited);
        floodfillRF(maze, row, col - 1, psf + "l", visited);
        floodfillRF(maze, row + 1, col, psf + "d", visited);
        floodfillRF(maze, row, col + 1, psf + "r", visited);
        visited[row][col] = false;
    }

    // ----------------------------------------------------------------

    public static void printTargetSumSubsets() {

        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int tar = scn.nextInt();
        printTargetSumSubsetsRF(arr, 0, "", 0, tar);

    }

    // set is the subset
    // sos is sum of subset
    // tar is target
    public static void printTargetSumSubsetsRF(int[] arr, int idx, String set, int sos, int tar) {

        /*
         * if (sos > tar) { return; }
         * 
         * if (sos == tar) { if(idx < arr.length){ if(arr[idx] == 0){
         * System.out.println(set + 0 + ", ."); System.out.println(set + "."); return; }
         * printTargetSumSubsetsRF(arr, idx + 1, set, sos, tar); return;
         * 
         * } else { System.out.println(set + "."); return; }
         * 
         * }
         * 
         * 
         * for (int i = idx; idx < arr.length; idx++) { printTargetSumSubsetsRF(arr, idx
         * + 1, set + arr[idx] + ", ", sos + arr[idx], tar); }
         */
        if (sos > tar) {
            return;
        }
        if (idx == arr.length) {
            if (sos == tar) {
                System.out.println(set + ".");
            }
            return;
        }

        printTargetSumSubsetsRF(arr, idx + 1, set + arr[idx] + ", ", sos + arr[idx], tar);
        printTargetSumSubsetsRF(arr, idx + 1, set, sos, tar);
    }

    // ---------------------------------------------------------------------------------------

    public static void nQueens() {

        int n = scn.nextInt();
        int[][] chess = new int[n][n];
        printNQueens(chess, "", 0);

    }

    public static void printNQueens(int[][] chess, String qsf, int row) {

        if (row == chess.length) {
            System.out.println(qsf + ".");
        }

        for (int j = 0; j < chess.length; j++) {
            if (IsPlaceFineforQueen(chess, row, j) == true) {
                chess[row][j] = 1;

                printNQueens(chess, qsf + row + "-" + j + ", ", row + 1);

                chess[row][j] = 0;
            }
        }

    }

    public static boolean IsPlaceFineforQueen(int[][] chess, int row, int col) {

        for (int i = row - 1; i >= 0; i--) {
            if (chess[i][col] == 1)
                return false;
        }

        for (int i = row - 1, j = col + 1; i >= 0 && j < chess.length; i--, j++) {
            if (chess[i][j] == 1)
                return false;

        }

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chess[i][j] == 1)
                return false;

        }

        return true;
    }

    // -------------------------------------------------------------------------------

    public static void knightsTour() {

        int n = scn.nextInt();
        int[][] chess = new int[n][n];
        int row = scn.nextInt();
        int col = scn.nextInt();
        printKnightsTour(chess, 1, row, col);
    }

    public static void printKnightsTour(int[][] chess, int totalvisited, int row, int col) {

        if (row < 0 || col < 0 || row >= chess.length || col >= chess[0].length || chess[row][col] != 0) {
            return;
        } else {

            chess[row][col] = totalvisited;

            if (totalvisited == (chess.length * chess.length)) {

                displayBoard(chess);
                chess[row][col] = 0;
                return;
            }

            printKnightsTour(chess, totalvisited + 1, row - 2, col + 1);
            printKnightsTour(chess, totalvisited + 1, row - 1, col + 2);
            printKnightsTour(chess, totalvisited + 1, row + 1, col + 2);
            printKnightsTour(chess, totalvisited + 1, row + 2, col + 1);
            printKnightsTour(chess, totalvisited + 1, row + 2, col - 1);
            printKnightsTour(chess, totalvisited + 1, row + 1, col - 2);
            printKnightsTour(chess, totalvisited + 1, row - 1, col - 2);
            printKnightsTour(chess, totalvisited + 1, row - 2, col - 1);

            chess[row][col] = 0;
        }
    }

    public static void displayBoard(int[][] chess) {
        for (int i = 0; i < chess.length; i++) {
            for (int j = 0; j < chess[0].length; j++) {
                System.out.print(chess[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
    }

    // ------------------------------------------------------------------------------
}
