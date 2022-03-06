import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxSumIncreasingSubsequence {

    public static void main(String[] args) {
        System.out.println(maxSumIncreasingSub(new int[]{10,70,20,30,50,11,30}));
    }

    public static List<List<Integer>> maxSumIncreasingSub(int[] array){
        int[] sequences = new int[array.length];
        Arrays.fill(sequences, Integer.MIN_VALUE);

        int[] sum = array.clone();
        int maxSumIndex = 0;

        for(int i = 0; i < array.length; i++){
            int currentNum = array[i];
            for(int j = 0;j < i; j++){
                int otherNum = array[j];
                if(otherNum < currentNum && currentNum + sum[j] >= sum[i]){
                    sum[i] = currentNum + sum[j];
                    sequences[i] = j;
                }
            }
            if(sum[i] >= sum[maxSumIndex])
                maxSumIndex = i;
        }

        return buildSequence(array, sequences, maxSumIndex, sum[maxSumIndex]);
    }

    private static List<List<Integer>> buildSequence(int[] array, int[] sequences, int maxSumIndex, int i) {

        List<List<Integer>> sequence = new ArrayList<>();
        sequence.add(new ArrayList<>());
        sequence.add(new ArrayList<>());

        sequence.get(0).add(i);

        while(maxSumIndex != Integer.MIN_VALUE){
            sequence.get(1).add(0,array[maxSumIndex]);
            maxSumIndex = sequences[maxSumIndex];
        }

        return sequence;

    }


}
