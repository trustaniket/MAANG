package binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightView {

    public static void main(String[] args) {
        System.out.println(rightSideView(Node.createTree()));
    }

    public static List<Integer> rightSideView(Node root) {
        List<Integer> out = new ArrayList<>();
        if(root == null)
            return out;

        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            int size = q.size();

            for(int i = 0; i < size; i++){
                Node node = q.poll();
                if(i == size -1)
                    out.add(node.val);

                if(node.left != null)
                    q.offer(node.left);
                if(node.right != null)
                    q.offer(node.right);
            }
        }
        return out;
    }
}
