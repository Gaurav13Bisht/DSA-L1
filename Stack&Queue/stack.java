import java.io.*;
import java.util.*;

public class stack {
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
}
