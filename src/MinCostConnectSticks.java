import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinCostConnectSticks {
    public static void main(String[] args) {
        MinCostConnectSticks minCostConnectSticks = new MinCostConnectSticks();

        System.out.println(minCostConnectSticks.connectSticks(new int[]{3354,4316,3259,4904,4598,474,3166,6322,8080,9009}));

        List<Integer> list = new ArrayList<>(26);

    }


    public int connectSticks(int[] sticks) {
        if(sticks.length == 0 || sticks.length == 1)
            return 0;

        Arrays.sort(sticks);
        int cost = 0;
        for(int i = 1; i < sticks.length; i++){
            Arrays.sort(sticks);
            sticks[i] += sticks[i-1];
            cost += sticks[i];
        }

        return cost;
    }
}
