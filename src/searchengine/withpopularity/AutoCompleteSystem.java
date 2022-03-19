package searchengine.withpopularity;

import searchengine.Node;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AutoCompleteSystem {

    private SearchNode root;
    private SearchNode current;
    private String keyword;

    public AutoCompleteSystem(String[] sentences, int[] ranks){
        this.root = new SearchNode();
        this.current = root;
        this.keyword = "";

        for(int i = 0; i < sentences.length; i++){
            this.addRecord(sentences[i], ranks[i]);
        }
    }

    public void addRecord(String word, int rank){
        SearchNode node = this.root;
        List<SearchNode> visited = new ArrayList<>();
        for(char c : word.toCharArray()){
            if(!node.children.containsKey(c)){
                node.children.put(c, new SearchNode());
            }
            node = node.children.get(c);
            visited.add(node);
        }
        node.isEnd = true;
        node.data = word;
        node.rank += rank;

        for(SearchNode n : visited){
            n.update(node);
        }
    }

    public String[] autoComplete(char c){
        List<String> res = new ArrayList<>();
        if(c == '#'){
            addRecord(keyword, 1);
            keyword = "";
            current = root;
            return new String[]{};
        }
        this.keyword += c;
        if(current != null) {
            if (!current.children.containsKey(c))
                return new String[]{};
            else
                current = current.children.get(c);
        } else
            return new String[]{};

        for(SearchNode searched : current.hot){
            res.add(searched.data);
        }
        return res.toArray(new String[res.size()]);
    }

    public static void main(String[] args) {
        String[] sentences = {"beautiful", "best quotes", "best friend", "best birthday wishes", "instagram", "internet", "better", "bestroot"};
        int[] times = {30, 14, 21, 10, 10, 15, 56, 15};
        AutoCompleteSystem auto = new AutoCompleteSystem(sentences, times);
        System.out.println(Arrays.toString(auto.autoComplete('b')));
        System.out.println(Arrays.toString(auto.autoComplete('e')));
        System.out.println(Arrays.toString(auto.autoComplete('s')));
        System.out.println(Arrays.toString(auto.autoComplete('t')));
        System.out.println(Arrays.toString(auto.autoComplete('#')));
    }

}
