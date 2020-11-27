import java.util.*;

class genericTree {

    static Scanner scn = new Scanner(System.in);

    static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    public static void main(String[] args) {
        solved();
        // Unsolved();

    }

    public static void solved() {
        construct();
        display();
        sizeOfGT();
        heightOfGT();
    }

    // static Node root = null;
    public static void construct() {
        Node root = null;
        int[] treeVal = { 10, 20, -1, 30, 50, -1, 60, -1, -1, 40, -1, -1 };
        Node founderNode = constructFunc(treeVal, root);
        System.out.println(founderNode.data);
    }

    public static Node constructFunc(int[] val, Node root) {
        Stack<Node> st = new Stack<>();
        for (int i = 0; i < val.length; i++) {
            if (val[i] != -1) {
                Node node = new Node();
                node.data = val[i];
                if (st.size() == 0) {
                    root = node;
                    st.push(node);
                } else {
                    st.peek().children.add(node);
                    st.push(node);
                }

            } else {
                st.pop();
            }
        }
        return root;
    }

    // ------------------------------------------------------------------------------------

    public static void display() {
        Node root = null;
        int[] treeVal = { 10, 20, -1, 30, 50, -1, 60, -1, -1, 40, -1, -1 };
        Node founderNode = constructFunc(treeVal, root);
        displayFunc(founderNode);

    }

    public static void displayFunc(Node node) {
        System.out.print(node.data + "->");
        for (Node child : node.children) {
            System.out.print(child.data + ",");
        }
        System.out.println(".");

        for (Node child : node.children) {
            displayFunc(child);
        }
    }

    // -------------------------------------------------------------------------------------

    public static void sizeOfGT() {
        Node root = null;
        int[] treeVal = { 10, 20, -1, 30, 50, -1, 60, -1, -1, 40, -1, -1 };
        Node founderNode = constructFunc(treeVal, root);
        System.out.println(sizeOfGTFunc(founderNode));

    }

    public static int sizeOfGTFunc(Node node) {
        int s = 0;
        for (Node child : node.children) {
            s += sizeOfGTFunc(child);
        }
        s += 1;

        return s;
    }

    // ----------------------------------------------------------------------------------------

    public static void heightOfGT() { // Based on no. of EDGES from the root
        Node root = null;
        int[] treeVal = { 10, 20, -1, 30, 50, -1, 60, -1, -1, 40, -1, -1 };
        Node founderNode = constructFunc(treeVal, root);
        System.out.println(heightOfGTFunc(founderNode));

    }

    private static int heightOfGTFunc(Node node) {
        int h = -1;
        for (Node child : node.children) {
            int th = heightOfGTFunc(child);
            h = Math.max(h, th);
        }
        h += 1;
        return h;
    }

    // ----------------------------------------------------------------------------------------------

}
