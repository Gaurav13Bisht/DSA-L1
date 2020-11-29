import java.util.*;

class SortingAlgos {

    static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        solved();
        // Unsolved();

    }

    public static void solved() {
        sorts1(); // BUBBLE , SELECTION AND INSERTION SORT
        sorts2();
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

    //////////////////////////////////////////////////////////////////////////////////////////////////

    public static void sorts2() {

        int n = scn.nextInt();
        int[] a = new int[n];

        // mergeSort();
        return;

        // FOR MERGE TWO SORTED ARRAYS COMMENT return TOO AND FOR MERGE SORT UNCOMMENT-
        // -mergeSort();

        for (int i = 0; i < n; i++) {
            a[i] = scn.nextInt();
        }
        int m = scn.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = scn.nextInt();
        }
        int[] mergedArray = mergeTwoSortedArrays(a, b);
        print(mergedArray);
    }

    // -----------------------------------------------------------------------------------------------

    public static int[] mergeTwoSortedArrays(int[] a, int[] b) {
        // System.out.println("Merging these two arrays ");
        // System.out.print("left array -> ");
        // print(a);
        // System.out.print("right array -> ");
        // print(b);
        int[] merged = new int[a.length + b.length];
        int k = 0, i = 0, j = 0;

        while (i < a.length && j < b.length) {

            if (a[i] < b[j]) {
                merged[k] = a[i];
                i++;

            } else {
                merged[k] = b[j];
                j++;
            }

            k++;
        }

        while (i != a.length) {
            merged[k] = a[i];
            i++;
            k++;
        }

        while (j != b.length) {
            merged[k] = b[j];
            j++;
            k++;
        }
        return merged;
    }

    // ------------------------------------------------------------------------------------------

    public static void mergeSort() {

        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int[] sa = mergeSortFunc(arr, 0, arr.length - 1);
        System.out.print("Sorted Array -> ");
        print(sa);

    }

    public static int[] mergeSortFunc(int[] arr, int lo, int hi) {

        if (lo == hi) {
            int[] last = new int[1];
            last[0] = arr[lo];
            return last;
        }
        int mid = (lo + hi) / 2;
        int[] fsh = mergeSortFunc(arr, lo, mid);
        int[] ssh = mergeSortFunc(arr, mid + 1, hi);

        int[] fsa = mergeTwoSortedArrays(fsh, ssh);

        return fsa;
    }

    // -------------------------------------------------------------------------------------------

}
