import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class CheckValidBST {

    public static void main(String[] args) {
        CheckValidBST checkValidBST = new CheckValidBST();
        System.out.println(checkValidBST.isValidBST(checkValidBST.createValidBST()));
    }

    public boolean isValidBST(TreeNode node){
        Stack<TreeNode> stack = new Stack<>();
        Integer prev = null;

        while(stack != null || node != null){
            while(node != null){
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();

            if(prev != null && node.val <= prev)
                return false;
            prev = node.val;
            node = node.right;

        }
        return true;
    }

    public TreeNode createValidBST(){
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(6);
        return root;

    }
}
