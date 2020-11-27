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
}
