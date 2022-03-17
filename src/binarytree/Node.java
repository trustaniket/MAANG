package binarytree;

public class Node {
    int val;
    Node left = null, right = null;
    Node(int val){
        this.val = val;
    }

    public static Node createTree(){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.right.left.left = new Node(7);
        root.right.left.right = new Node(8);

        return root;
    }
}
