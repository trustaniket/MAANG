package searchengine;

import java.util.HashMap;

public class WordDictionary {

    private Node root;

    public WordDictionary(){
        HashMap<Character, Node> children = new HashMap<>();
        boolean isWord = false;
        this.root = new Node();
    }

    public void insertWord(String word){
        Node node = this.root;

        for(Character c : word.toCharArray()){
            if(!node.children.containsKey(c)){
                node.children.put(c, new Node());
            }
            node = node.children.get(c);
        }
        node.isWord = true;
    }

    public boolean searchWord(String word){
        Node node = this.root;
        for(char c : word.toCharArray()){
            if(!node.children.containsKey(c))
                return false;
            node = node.children.get(c);
        }
        return node.isWord;
    }

    public boolean startsWith(String word){
        Node node = this.root;
        for(char c : word.toCharArray()){
            if(!node.children.containsKey(c))
                return false;
            node = node.children.get(c);
        }
        return true;
    }
}
