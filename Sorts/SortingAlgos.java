import java.util.*;

class SortingAlgos {

    static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        solved();
        // Unsolved();

    }

    public static void solved() {
        sorts1();
    }

    // used for swapping ith and jth elements of array
    public static void swap(int[] arr, int i, int j) {
        System.out.println("Swapping " + arr[i] + " and " + arr[j]);
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // return true if ith element is smaller than jth element
    public static boolean isSmaller(int[] arr, int i, int j) {
        System.out.println("Comparing " + arr[i] + " and " + arr[j]);
        if (arr[i] < arr[j]) {
            return true;
        } else {
            return false;
        }
    }

    // return true if jth element is greater than ith element
    public static boolean isGreater(int[] arr, int j, int i) {
        System.out.println("Comparing " + arr[i] + " and " + arr[j]);
        if (arr[i] < arr[j]) {
            return true;
        } else {
            return false;
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////

    public static void sorts1() {

        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        // bubbleSort(arr);
        // selectionSort(arr);
        // insertionSort(arr);
        print(arr);
    }

    // --------------------------------------------------------------------------------------------

    public static void bubbleSort(int[] arr) {
        int size = arr.length;

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < size - 1; j++) {
                if (!isSmaller(arr, j + 1, j))
                    continue;
                else
                    swap(arr, j + 1, j);

            }
            size--;
        }

    }

    // ----------------------------------------------------------------------------------------------

    public static void selectionSort(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;

            for (int j = i + 1; j < arr.length; j++) {
                if (isSmaller(arr, j, min))
                    min = j;

            }

            swap(arr, i, min);

        }
    }

    // -----------------------------------------------------------------------------------------------

    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j - 1 >= 0; j--) {

                if (isGreater(arr, j - 1, j))
                    swap(arr, j - 1, j);
                else
                    break;

            }
        }

    }

    // -----------------------------------------------------------------------------------------
}
