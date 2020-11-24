import java.io.*;
import java.util.*;

class genericTree {
    
    static Scanner scn = new Scanner(System.in);
    static class Node{
        int data;
        ArrayList<Node> children = new ArrayList<>();  
    }
    public static void main(String[] args) {
        solved();
        //Unsolved();

    }

    public static void solved() {
        construct();
    }


    //static Node root = null;
    public static void construct() {
        Node root = null;
        int[] treeVal= {10, 20, -1, 30, 50, -1, 60, -1, -1, 40, -1, -1};
        Node founderNode = constructFunc(treeVal, root);
        System.out.println(founderNode.data);
    }


    public static Node constructFunc(int[] val, Node root){
        Stack<Node> st = new Stack<>();
        for(int i = 0; i < val.length; i++){
            if(val[i] != -1){
                Node node = new Node();
                node.data = val[i];
                if(st.size() == 0){
                    root = node;
                    st.push(node);
                }
                else{
                    st.peek().children.add(node);
                    st.push(node);
                }

            }
            else{
                st.pop();
            }
        }
        return root;
    }
    

//------------------------------------------------------------------------------------




}
