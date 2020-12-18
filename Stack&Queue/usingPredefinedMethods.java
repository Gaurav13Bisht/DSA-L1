import java.io.*;
import java.util.*;

public class usingPredefinedMethods {
    static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        solved();
        // Unsolved();

    }

    public static void solved() {
        duplicateBrackets();
        balancedBrackets();
        group1(); // NEXT GREATEST ELEMENT AND STOCK SPAN
        largestAreaHistogram();
        slidingWindowMax();
        infixEvaluation();
        infixConversion();
        postfixEvalAndCoversion();
        prefixEvalAndConversion();
        findCelebrity();
        mergeOverlappingIntervals();
        smallestNumberFollowingPattern();
    }

    public static void display(int[] a) {
        StringBuilder sb = new StringBuilder();

        for (int val : a) {
            sb.append(val + "");
        }
        System.out.println(sb);
    }

    ////////////////////////////////////////////////////////////////////////////////

    public static void duplicateBrackets() {

        String str = scn.nextLine();
        Stack<Character> st = new Stack<>();
        int dupli = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch != ')')
                st.push(ch);
            else if (ch == ')' && st.peek() != '(') {
                while (st.peek() != '(') {
                    st.pop();
                }
                st.pop();
            } else if (ch == ')' && st.peek() == '(')
                dupli++;
        }
        if (dupli == 0)
            System.out.print("false");
        else
            System.out.print("true");
    }
    // --------------------------------------------------------------------------

    public static void balancedBrackets() {

        String str = scn.nextLine();
        Stack<Character> st = new Stack<>();
        int unbalanced = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == '(' || ch == '{' || ch == '[')
                st.push(ch);
            else if (ch == ')' || ch == '}' || ch == ']') {
                if (st.size() == 0) {
                    unbalanced++;
                    break;
                } else if (ch == ')')
                    if (st.peek() == '(')
                        st.pop();
                    else {
                        unbalanced++;
                        break;
                    }

                else if (ch == '}')
                    if (st.peek() == '{')
                        st.pop();
                    else {
                        unbalanced++;
                        break;
                    }
                else if (ch == ']')
                    if (st.peek() == '[')
                        st.pop();
                    else {
                        unbalanced++;
                        break;
                    }
            }
        }
        if (unbalanced == 0 && st.size() == 0)
            System.out.print("true");
        else
            System.out.print("false");

    }

    // ----------------------------------------------------------------------------------

    public static void group1() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }

        // int[] nge = solve1(a); NEXT GREATER ELEMENTS
        // display(nge);

        int[] span = solve2(a); // STOCK SPAN
        display(span);
    }

    public static int[] solve(int[] arr) {

        int[] nge = new int[arr.length];

        nge[nge.length - 1] = -1;

        Stack<Integer> st = new Stack<>();

        st.push(arr[arr.length - 1]);

        for (int i = arr.length - 2; i >= 0; i--) {

            while (st.size() != 0 && st.peek() < arr[i])
                st.pop();

            if (st.size() == 0)
                nge[i] = -1;
            else
                nge[i] = st.peek();

            st.push(arr[i]);

        }

        return nge;
    }

    // ------------------------------------------------------------------------------

    public static int[] solve2(int[] arr) {

        int[] nge = new int[arr.length];

        nge[0] = 1;

        Stack<Integer> st = new Stack<>();

        st.push(0);

        for (int i = 1; i < arr.length; i++) {

            while (st.size() != 0 && arr[st.peek()] < arr[i]) {
                st.pop();
            }

            if (st.size() == 0)
                nge[i] = i + 1;
            else
                nge[i] = i - st.peek();

            st.push(i);
        }

        return nge;
    }

    // --------------------------------------------------------------------------------------------

    public static void largestAreaHistogram() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[] ser = new int[arr.length];

        ser[ser.length - 1] = arr.length;

        Stack<Integer> st = new Stack<>();

        st.push(arr.length - 1);

        for (int i = arr.length - 2; i >= 0; i--) {

            while (st.size() != 0 && arr[st.peek()] >= arr[i])
                st.pop();

            if (st.size() == 0)
                ser[i] = arr.length;
            else
                ser[i] = st.peek();

            st.push(i);

        }

        int[] sel = new int[arr.length];

        sel[0] = -1;

        Stack<Integer> st2 = new Stack<>();

        st2.push(0);

        for (int i = 1; i < arr.length; i++) {

            while (st2.size() != 0 && arr[st2.peek()] >= arr[i]) {
                st2.pop();
            }

            if (st2.size() == 0)
                sel[i] = -1;
            else
                sel[i] = st2.peek();

            st2.push(i);
        }

        int maxArea = 0;
        for (int i = 0; i < arr.length; i++) {
            int iarea = arr[i] * (ser[i] - sel[i] - 1);
            if (iarea > maxArea)
                maxArea = iarea;
        }

        System.out.print(maxArea);

    }

    // --------------------------------------------------------------------------

    public static void slidingWindowMax() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }
        int k = Integer.parseInt(br.readLine());

        int[] nge = new int[a.length];

        Stack<Integer> st = new Stack<>();

        st.push(a.length - 1);
        nge[a.length - 1] = -1;

        for (int i = a.length - 2; i >= 0; i--) {
            while (st.size() > 0 && a[st.peek()] < a[i])
                st.pop();

            if (st.size() == 0)
                nge[i] = -1;
            else
                nge[i] = st.peek();

            st.push(i);
        }

        int j = 0;
        for (int i = 0; i < a.length - k + 1; i++) {
            if (j < i)
                j = i;
            int window = i + k - 1;
            while (nge[j] <= window && nge[j] != -1)
                j = nge[j];

            System.out.println(a[j]);

        }

    }

    // ------------------------------------------------------------------------------

    public static void infixEvaluation() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();

        Stack<Integer> oprand = new Stack<>();
        Stack<Character> oprator = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);

            if (Character.isDigit(ch)) {
                oprand.push(ch - '0');
            } else if (ch == '(') {
                oprator.push(ch);
            } else if (ch == ')') {
                while (oprator.peek() != '(') {
                    char opd = oprator.pop();
                    int val2 = oprand.pop();
                    int val1 = oprand.pop();

                    oprand.push(operation(val1, val2, opd));
                }
                oprator.pop();
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                while (oprator.size() > 0 && oprator.peek() != '(' && precedence(ch) <= precedence(oprator.peek())) {
                    char opd = oprator.pop();
                    int val2 = oprand.pop();
                    int val1 = oprand.pop();

                    oprand.push(operation(val1, val2, opd));
                }
                oprator.push(ch);
            }

        }

        while (oprator.size() != 0) {
            char opd = oprator.pop();
            int val2 = oprand.pop();
            int val1 = oprand.pop();

            oprand.push(operation(val1, val2, opd));

        }

        System.out.print(oprand.peek());
    }

    public static int precedence(char input) {

        if (input == '-')
            return 1;

        else if (input == '+')
            return 1;

        else if (input == '*')
            return 2;

        else
            return 2;
    }

    public static int operation(int v1, int v2, char operatr) {

        if (operatr == '-')
            return v1 - v2;

        else if (operatr == '+')
            return v1 + v2;

        else if (operatr == '*')
            return v1 * v2;

        else
            return v1 / v2;

    }

    // -----------------------------------------------------------------------------------

    public static void infixConversion() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();

        Stack<String> prefix = new Stack<>();
        Stack<String> postfix = new Stack<>();
        Stack<Character> oprator = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);

            if (ch >= '0' && ch <= '9' || ch >= 'A' && ch <= 'Z' || ch >= 'a' && ch <= 'z') {
                prefix.push(ch + "");
                postfix.push(ch + "");
            } else if (ch == '(') {
                oprator.push(ch);
            } else if (ch == ')') {
                while (oprator.peek() != '(') {
                    char opd = oprator.pop();

                    String preVal2 = prefix.pop();
                    String preVal1 = prefix.pop();
                    prefix.push(opd + preVal1 + preVal2);

                    String postVal2 = postfix.pop();
                    String postVal1 = postfix.pop();
                    postfix.push(postVal1 + postVal2 + opd);
                }
                oprator.pop();
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                while (oprator.size() > 0 && oprator.peek() != '(' && precedence(ch) <= precedence(oprator.peek())) {
                    char opd = oprator.pop();

                    String preVal2 = prefix.pop();
                    String preVal1 = prefix.pop();
                    prefix.push(opd + preVal1 + preVal2);

                    String postVal2 = postfix.pop();
                    String postVal1 = postfix.pop();
                    postfix.push(postVal1 + postVal2 + opd);
                }
                oprator.push(ch);
            }

        }

        while (oprator.size() != 0) {
            char opd = oprator.pop();

            String preVal2 = prefix.pop();
            String preVal1 = prefix.pop();
            prefix.push(opd + preVal1 + preVal2);

            String postVal2 = postfix.pop();
            String postVal1 = postfix.pop();
            postfix.push(postVal1 + postVal2 + opd);
        }

        System.out.println(postfix.peek());
        System.out.print(prefix.peek());
    }

    public static int precedence(char input) {

        if (input == '-' || input == '+')
            return 1;

        else if (input == '*' || input == '/')
            return 2;

        else
            return 2;
    }

    /*
     * public static String opnPre(int v1, int v2, char operatr) {
     * 
     * if (operatr == '-') return "-"v1v2;
     * 
     * else if (operatr == '+') return v1 + v2;
     * 
     * else if (operatr == '*') return v1 * v2;
     * 
     * else return v1 / v2;
     * 
     * }
     */
    // ----------------------------------------------------------------------------------------

    public static void postfixEvalAndCoversion() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();

        Stack<String> infix = new Stack<>();
        Stack<String> prefix = new Stack<>();
        Stack<Integer> evaluation = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);

            if (ch >= '0' && ch <= '9' || ch >= 'A' && ch <= 'Z' || ch >= 'a' && ch <= 'z') {
                evaluation.push(ch - '0');
                prefix.push(ch + "");
                infix.push(ch + "");

            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {

                String inVal2 = infix.pop();
                String inVal1 = infix.pop();
                infix.push('(' + inVal1 + ch + inVal2 + ')');

                String preVal2 = prefix.pop();
                String preVal1 = prefix.pop();
                prefix.push(ch + preVal1 + preVal2);

                int eval2 = evaluation.pop();
                int eval1 = evaluation.pop();
                evaluation.push(operation(eval1, eval2, ch));
            }

        }

        System.out.println(evaluation.peek());
        System.out.println(infix.peek());
        System.out.print(prefix.peek());
    }

    // ---------------------------------------------------------------------------------------------

    public static void prefixEvalAndConversion() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();

        Stack<String> infix = new Stack<>();
        Stack<String> postfix = new Stack<>();
        Stack<Integer> evaluation = new Stack<>();

        for (int i = exp.length() - 1; i >= 0; i--) {
            char ch = exp.charAt(i);

            if (ch >= '0' && ch <= '9' || ch >= 'A' && ch <= 'Z' || ch >= 'a' && ch <= 'z') {
                evaluation.push(ch - '0');
                postfix.push(ch + "");
                infix.push(ch + "");

            } else {

                String inVal1 = infix.pop();
                String inVal2 = infix.pop();
                infix.push('(' + inVal1 + ch + inVal2 + ')');

                String postVal1 = postfix.pop();
                String postVal2 = postfix.pop();
                postfix.push(postVal1 + postVal2 + ch);

                int eval1 = evaluation.pop();
                int eval2 = evaluation.pop();
                evaluation.push(operation(eval1, eval2, ch));
            }

        }

        System.out.println(evaluation.peek());
        System.out.println(infix.peek());
        System.out.print(postfix.peek());
    }

    // --------------------------------------------------------------------------------------------------

    public static void findCelebrity() {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];

        for (int j = 0; j < n; j++) {
            String line = br.readLine();
            for (int k = 0; k < n; k++) {
                arr[j][k] = line.charAt(k) - '0';
            }
        }

        findCelebrityFunc(arr);

    }

    public static void findCelebrityFunc(int[][] arr) {
        // if a celebrity is there print it's index (not position), if there is not then
        // print "none"
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            st.push(i);
        }
        while (st.size() != 1) {
            int val1 = st.pop();
            int val2 = st.pop();
            if (knowsOrNot(arr, val1, val2))
                st.push(val2);
            else
                st.push(val1);
        }

        int potentialCeleb = st.peek();

        for (int i = 0; i < arr.length; i++) {
            if (i == potentialCeleb)
                continue;
            else if (arr[potentialCeleb][i] == 1 || arr[i][potentialCeleb] == 0) {
                System.out.print("none");
                return;
            }
        }

        System.out.print(potentialCeleb);

    }

    public static boolean knowsOrNot(int[][] arr, int v1, int v2) {
        if (arr[v1][v2] == 1)
            return true;
        else
            return false;

    }

    // ---------------------------------------------------------------------------------------------

    public static void mergeOverlappingIntervals() {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];

        for (int j = 0; j < n; j++) {
            String line = br.readLine();
            arr[j][0] = Integer.parseInt(line.split(" ")[0]);
            arr[j][1] = Integer.parseInt(line.split(" ")[1]);
        }

        mergeOverlappingIntervalsFunc(arr);
    }

    public static void mergeOverlappingIntervalsFunc(int[][] arr) {
        // merge overlapping intervals and print in increasing order of start time

        quickSort(arr, 0, arr.length - 1);

        Stack<Integer> start = new Stack<>();
        Stack<Integer> end = new Stack<>();

        start.push(arr[0][0]);
        end.push(arr[0][1]);

        for (int i = 1; i < arr.length; i++) {
            if (arr[i][0] <= end.peek()) {
                if (arr[i][1] > end.peek()) {
                    end.pop();
                    end.push(arr[i][1]);
                }
            } else {
                start.push(arr[i][0]);
                end.push(arr[i][1]);
            }
        }

        recurPrint(start, end);

    }

    public static void recurPrint(Stack<Integer> start, Stack<Integer> end) {

        if (start.size() == 0)
            return;

        int st = start.pop();
        int en = end.pop();
        recurPrint(start, end);

        System.out.println(st + " " + en);
        return;

    }

    public static void quickSort(int[][] arr, int lo, int hi) {

        if (lo > hi) {
            return;
        }

        int pivot = partition(arr, arr[hi][0], lo, hi);
        quickSort(arr, lo, pivot - 1);
        quickSort(arr, pivot + 1, hi);

    }

    public static int partition(int[][] arr, int pivot, int lo, int hi) {

        int i = lo, j = lo;
        while (i <= hi) {
            if (arr[i][0] <= pivot) {
                swap(arr, i, j);
                i++;
                j++;
            } else {
                i++;
            }
        }

        return (j - 1);
    }

    // used for swapping ith and jth elements of array
    public static void swap(int[][] arr, int i, int j) {

        int temp1 = arr[i][0];
        int temp2 = arr[i][1];
        arr[i][0] = arr[j][0];
        arr[i][1] = arr[j][1];
        arr[j][0] = temp1;
        arr[j][1] = temp2;
    }

    // -------------------------------------------------------------------------------------------------

    public static void smallestNumberFollowingPattern() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        Stack<Integer> st = new Stack<>();
        st.push(1);
        int[] pattern = new int[str.length() + 1];

        for (int s = 0; s < str.length(); s++) {
            if (str.charAt(s) == 'd')
                continue;
            else {
                pattern[s] = st.peek();
                st.pop();
                st.push(pattern[s] + 1);

                for (int j = s - 1; j >= 0 && str.charAt(j) == 'd'; j--) {
                    pattern[j] = st.peek();
                    st.pop();
                    st.push(pattern[j] + 1);
                }

            }
        }

        if (str.charAt(str.length() - 1) == 'i') {
            pattern[pattern.length - 1] = st.peek();
        } else {
            pattern[pattern.length - 1] = st.peek();
            pattern[pattern.length - 2] = st.peek() + 1;
        }

        for (int s = 0; s < pattern.length; s++) {
            System.out.print(pattern[s]);

        }
    }
    // ----------------------------------------------------------------------------------------
}
