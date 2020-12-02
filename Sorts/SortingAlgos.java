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
        sortsUsedQues();
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
        // int pivot = scn.nextInt();
        // partition(a, pivot);
        // print(a);

        // quickSort(a, 0, arr.length - 1);
        // print(a);

        // int k = scn.nextInt();
        // System.out.println(quickSelect(arr, 0, arr.length - 1, k - 1));

        /*
         * int max = Integer.MIN_VALUE; int min = Integer.MAX_VALUE; for (int i = 0; i <
         * n; i++) { arr[i] = scn.nextInt(); max = Math.max(max, arr[i]); min =
         * Math.min(min, arr[i]); countSort(arr, min, max); print(arr);
         */

        // radixSort(a);
        // print(a);

        /*
         * int m = scn.nextInt(); int[] b = new int[m]; for (int i = 0; i < m; i++) {
         * b[i] = scn.nextInt(); } int[] mergedArray = mergeTwoSortedArrays(a, b);
         * print(mergedArray);
         */
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

    public static void partition(int[] arr, int pivot) {
        int i = 0, j = 0;
        while (i < arr.length) {
            if (arr[i] > pivot)
                i++;

            else {
                swap(arr, i, j);
                i++;
                j++;
            }
        }

    }

    // -------------------------------------------------------------------------------------------

    public static void quickSort(int[] arr, int lo, int hi) {

        if (lo > hi) {
            return;
        }

        int pivot = partition2(arr, arr[hi], lo, hi);
        quickSort(arr, lo, pivot - 1);
        quickSort(arr, pivot + 1, hi);

    }

    public static int partition2(int[] arr, int pivot, int lo, int hi) {
        System.out.println("pivot -> " + pivot);
        int i = lo, j = lo;
        while (i <= hi) {
            if (arr[i] <= pivot) {
                swap(arr, i, j);
                i++;
                j++;
            } else {
                i++;
            }
        }
        System.out.println("pivot index -> " + (j - 1));
        return (j - 1);
    }

    // -----------------------------------------------------------------------------

    public static int quickSelect(int[] arr, int lo, int hi, int k) {
        if (lo > hi)
            return 0;

        int pivot = partition2(arr, arr[hi], lo, hi);
        if (pivot == k)
            return arr[pivot];
        else {

            if (pivot > k)
                return quickSelect(arr, lo, pivot - 1, k);
            else {

                return quickSelect(arr, pivot + 1, hi, k);
            }

        }

    }

    // -------------------------------------------------------------------------------------

    public static void countSort(int[] arr, int min, int max) {
        int[] freq = new int[max - min + 1];
        for (int i = 0; i < arr.length; i++) {
            freq[arr[i] - min]++;
        }
        int prefixsum = 0;
        for (int i = 0; i < freq.length; i++) {
            prefixsum += freq[i];
            freq[i] = prefixsum;
            freq[i]--;
        }

        int[] csorted = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            int idx = freq[arr[i] - min];
            csorted[idx] = arr[i];
            freq[arr[i] - min]--;
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = csorted[i];
        }

    }

    // ------------------------------------------------------------------------------------------

    public static void radixSort(int[] arr) {
        Scanner scn = new Scanner(System.in);
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        int exp = 1;
        while (exp <= max) {
            countSort2(arr, exp);
            exp *= 10;
        }
    }

    public static void countSort2(int[] arr, int exp) {
        int[] freq = new int[10];
        for (int i = 0; i < arr.length; i++) {
            freq[arr[i] / exp % 10]++;
        }
        int prefixsum = 0;
        for (int i = 0; i < freq.length; i++) {
            prefixsum += freq[i];
            freq[i] = prefixsum;
            freq[i]--;
        }

        int[] csorted = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            int idx = freq[arr[i] / exp % 10];
            csorted[idx] = arr[i];
            freq[arr[i] / exp % 10]--;
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = csorted[i];
        }

        System.out.print("After sorting on " + exp + " place -> ");
        print(arr);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////

    public static void sortsUsedQues() {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            String str = scn.next();
            arr[i] = str;
        }
        sortDates(arr);
        print(arr);
    }

    // ---------------------------------------------------------------------------------------------------

    public static void sortDates(String[] arr) {
        countSort(arr, 1000000, 100, 32); // Days // range is 1 - 31 but if we pass 31 then 0 - 30 will be the range in
                                          // freq array }
        countSort(arr, 10000, 100, 13); // Months
        countSort(arr, 1, 10000, 2501); // Years
    }

    public static void countSort(String[] arr, int div, int mod, int range) {

        int[] freq = new int[range];
        for (int i = 0; i < arr.length; i++) {
            freq[Integer.parseInt(arr[i], 10) / div % mod]++;

            // Since the arr[i] is in the form of String, so we have to convert
            // it to integer first and then often if arr[i] have a no. starting
            // with 0 e.g. 05 then the machine convert it into octal base so we
            // pass 10 with it to instruct the machine that it is a decimal no.

        }

        int prefixsum = 0;
        for (int i = 0; i < freq.length; i++) {
            prefixsum += freq[i];
            freq[i] = prefixsum;
            freq[i]--;
        }

        String[] csorted = new String[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            int idx = freq[Integer.parseInt(arr[i], 10) / div % mod];
            csorted[idx] = arr[i];
            freq[Integer.parseInt(arr[i], 10) / div % mod]--;
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = csorted[i];
        }

    }

    // -------------------------------------------------------------------------------------------

}
