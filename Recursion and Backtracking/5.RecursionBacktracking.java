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
}
