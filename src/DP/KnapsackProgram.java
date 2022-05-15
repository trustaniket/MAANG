package DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class KnapsackProgram {

    public static void main(String[] args) {
        int[][] input = {{1, 2}, {4, 3}, {5, 6}, {6, 7}};
        int[][] expected = {{10}, {1, 3}};

        List<List<Integer>> output = knapsackProblem(input, 10);
        System.out.println(output);
    }

    public static List<List<Integer>> knapsackProblem(int[][] items, int capacity) {

        int[][] knapsack = new int[items.length + 1][capacity + 1];

        for(int i = 1; i < items.length + 1; i++){
            int currentValue = items[i-1][0];
            int currentWeight = items[i-1][1];
            for(int c = 0; c <= capacity; c++){
                if(currentWeight > c){
                    knapsack[i][c] = knapsack[i-1][c];
                } else {
                    knapsack[i][c] = Math.max(knapsack[i-1][c], knapsack[i-1][c - currentWeight] + currentValue);
                }
            }
        }

        return getResult(items, knapsack, knapsack[items.length][capacity]);

    }

    private static List<List<Integer>> getResult(int[][] items, int[][] knapsack, int totalWeight){

        List<Integer> weight = new LinkedList<>();
        List<List<Integer>> totalOutput = new ArrayList<>();
        weight.add(totalWeight);
        totalOutput.add(weight);
        totalOutput.add(new LinkedList<>());

        int i = knapsack.length - 1;
        int c = knapsack[0].length - 1;

        while(i > 0){
            if(knapsack[i][c] == knapsack[i-1][c]){
                i--;
            } else {
                totalOutput.get(1).add(0, i-1);
                c -= items[i-1][1];
                i--;
            }
            if(c == 0)
                break;
        }

        return totalOutput;
    }
}
