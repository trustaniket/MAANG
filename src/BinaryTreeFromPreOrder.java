import com.sun.source.tree.Tree;

public class BinaryTreeFromPreOrder {

    public static void main(String[] args) {
        int preOrder[] = {8,5,1,7,10,12};
        TreeNode root = bstFromPreorder(preOrder);
    }

    public static TreeNode bstFromPreorder(int[] preorder) {
        TreeNode node = new TreeNode();
        bstHelper(node, 0, preorder);
        return node;
    }

    private static void bstHelper(TreeNode node, int index, int[] pre){
        if(index == pre.length)
            return;
        if(index == 0)
        {
            node.val = pre[index];
            bstHelper(node, index+ 1, pre);
        }

        if(pre[index] < node.val){
            node.left = new TreeNode(pre[index]);
            bstHelper(node.left, index+1, pre);
        }
        else{
            node.right = new TreeNode(pre[index]);;
            bstHelper(node.right, index+1, pre);
        }
    }
}

 class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(){}
     TreeNode(int val){
        this.val = val;
     }
     TreeNode(int val, TreeNode left, TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
     }
}
/*
*
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
*/
