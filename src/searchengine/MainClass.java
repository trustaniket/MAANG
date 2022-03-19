package searchengine;

import java.util.Arrays;

public class MainClass {

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        String[] keys = {"the", "a", "there", "answer", "any",
                "by", "bye", "their", "abc"};
        System.out.println("Keys to insert: ");
        System.out.println(Arrays.toString(keys));

        for(String key : keys){
            wordDictionary.insertWord(key);
        }

        System.out.println("Search a word in dictionary (there) : " + wordDictionary.searchWord("there"));

    }
}
