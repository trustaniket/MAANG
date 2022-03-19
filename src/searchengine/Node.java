package searchengine;

import java.util.HashMap;

public class Node {
    public HashMap<Character, Node> children = new HashMap<>();
    public boolean isWord = false;
}
