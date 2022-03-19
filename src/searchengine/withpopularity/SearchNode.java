package searchengine.withpopularity;

import java.util.*;

public class SearchNode implements Comparable<SearchNode>{

    public HashMap<Character, SearchNode> children;
    public boolean isEnd;
    public String data;
    int rank;
    public List<SearchNode> hot;

    public SearchNode(){
        this.children = new HashMap<>();
        this.isEnd = false;
        this.rank = 0;
        this.hot = new ArrayList<>();
    }

    @Override
    public int compareTo(SearchNode o) {
        if(this.rank == o.rank){
            return this.data.compareTo(o.data);
        }
        return o.rank - this.rank;
    }

    public void update(SearchNode n){
        if(!this.hot.contains(n)){
            this.hot.add(n);
        }
        Collections.sort(hot);
        if(hot.size() > 3){
            hot.remove(hot.size() - 1);
        }
    }
}
