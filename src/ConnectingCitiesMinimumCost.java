import java.util.Arrays;
import java.util.Comparator;

public class ConnectingCitiesMinimumCost {

    public static void main(String[] args) {

        System.out.println(40%60);
        System.out.println(new ConnectingCitiesMinimumCost().minimumCost(3, new int[][]{{1,2,5}, {1,3,6}, {2,3,1}}));
    }

    public int minimumCost(int n, int[][] connections) {
        DisjointSet dis = new DisjointSet(n);

        Arrays.sort(connections, Comparator.comparingInt(a -> a[2]));
        int cost = 0;
        int total = 0;
        for(int i = 0; i < connections.length; i++){
            int a = connections[i][0];
            int b = connections[i][1];
            if(dis.isInSameGroup(a, b))
                continue;
            dis.union(a, b);

            cost += connections[i][2];
            total++;

        }

        if(total == n-1)
            return cost;
        else
            return -1;
    }
}

class DisjointSet{
    private int[] parents;
    private int[] weights;

    public DisjointSet(int n){
        this.parents = new int[n+1];
        this.weights = new int[n+1];

        for(int i = 1; i <= n; i++){
            this.parents[i] = i;
            this.weights[i] = 1;
        }
    }

    public int find(int a){
        while(a != this.parents[a]){
            this.parents[a] = this.parents[parents[a]];
            a = this.parents[a];
        }
        return a;
    }

    public boolean isInSameGroup(int a, int b){
        return find(a) == find(b);
    }

    public void union(int a, int b){
        int roota = find(a);
        int rootb = find(b);

        if(roota == rootb){
            return;
        }

        if(weights[roota] > weights[rootb]){
            this.parents[rootb] = roota;
            this.weights[roota] += this.weights[rootb];
        }
        else{
            this.parents[roota] = rootb;
            this.weights[rootb] += this.weights[roota];
        }
    }
}
