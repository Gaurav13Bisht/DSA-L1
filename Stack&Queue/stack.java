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
        nextGreaterElement();
    }

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

    public static void nextGreaterElement() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }

        int[] nge = solve(a);
        display(nge);
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

    public static void display(int[] a) {
        StringBuilder sb = new StringBuilder();

        for (int val : a) {
            sb.append(val + "");
        }
        System.out.println(sb);
    }

    // -------------------------------------------------------------------------------
}
