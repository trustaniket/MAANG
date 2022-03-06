package trie;

import java.util.HashMap;
import java.util.Map;

public class MaxOccuringWordInArray {

    class TrieNode {
        Map<Character, TrieNode> children;
        int count;
        boolean endOfWord;

        public TrieNode(){
            children = new HashMap<>();
            count = 0;
            endOfWord = false;
        }
    }

    public String maxOccurringWord(String[] arr){
        TrieNode root = new TrieNode();
        int maxCount = Integer.MIN_VALUE;
        String output = "";
        for(String str : arr){
            TrieNode current = root;
            for(int i = 0; i < str.length(); i++){
                if(current.children.size() == 0 || !current.children.containsKey(str.charAt(i)) ){
                    current.children.put(str.charAt(i), new TrieNode());
                }
                TrieNode node = current.children.get(str.charAt(i));
                current = node;
            }
            current.endOfWord = true;
            current.count++;
            if(current.count > maxCount){
                maxCount = current.count;
                output = str;
            } else if(maxCount == current.count && output.compareTo(str) > 0){
                output = str;
            }
        }

        return output;
    }

    public static void main(String[] args) {
        String[] votes = { "john", "johnny", "jackie",
                "johnny", "john", "jackie",
                "jamie", "jamie", "john",
                "johnny", "jamie", "johnny",
                "john" };

        MaxOccuringWordInArray maxOccuringWordInArray = new MaxOccuringWordInArray();
        System.out.println(maxOccuringWordInArray.maxOccurringWord(votes));
    }
}
