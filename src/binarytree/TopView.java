package binarytree;

import org.apache.commons.lang3.tuple.Pair;

import java.util.Map;
import java.util.TreeMap;

public class TopView {

    public static void main(String[] args) {
        printTop(Node.createTree());
    }

    public static void printTop(Node root)
    {
        // create a `TreeMap` where
        // key —> relative horizontal distance of the node from the root node, and
        // value —> pair containing the node's value and its level
        Map<Integer, Pair<Integer, Integer>> map = new TreeMap<>();

        // perform preorder traversal on the tree and fill the map
        printTop(root, 0, 0, map);

        // traverse the `TreeMap` and print the top view
        for (Pair<Integer, Integer> it: map.values()) {
            System.out.print(it.getLeft() + " ");
        }
    }

    public static void printTop(Node root, int dist, int level,
                                Map<Integer, Pair<Integer, Integer>> map)
    {
        // base case: empty tree
        if (root == null) {
            return;
        }
        // if the current level is less than the maximum level seen so far
        // for the same horizontal distance, or if the horizontal distance
        // is seen for the first time, update the map
        if (!map.containsKey(dist) || level < map.get(dist).getRight())
        {
            // update value and level for current distance
            map.put(dist, Pair.of(root.val, level));
        }

        // recur for the left subtree by decreasing horizontal distance and
        // increasing level by 1
        printTop(root.left, dist - 1, level + 1, map);

        // recur for the right subtree by increasing both level and
        // horizontal distance by 1
        printTop(root.right, dist + 1, level + 1, map);
    }
}
