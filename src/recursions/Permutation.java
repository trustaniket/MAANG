package recursions;

import java.util.ArrayList;
import java.util.List;

public class Permutation {

    public static void main(String[] args) {
        Permutation permutation = new Permutation();
        List<Integer> input = new ArrayList<>(){{
            add(1);
            add(2);
            add(3);
        }};
        List<List<Integer>> output = permutation.getPermutations(input);
        System.out.println(output);

        List<Integer> inputNew = new ArrayList<>(){{
            add(1);
            add(2);
            add(3);
        }};
        List<List<Integer>> outputNew = new ArrayList<>();
        permutation.permutationHelperOptimized(inputNew, outputNew, 0);
        System.out.println(outputNew);
    }

    private List<List<Integer>> getPermutations(List<Integer> array){
        List<List<Integer>> output = new ArrayList<>();
        permutationHelper(array, new ArrayList<>(), output);
        return output;
    }

    /**
     * O(n^2*n!) time || O(n * n!) space
     * O(n*n!) time roughly
     */
    private void permutationHelper(List<Integer> array, List<Integer> currentPermutation, List<List<Integer>> output){


        if(array.size() == 0 && currentPermutation.size() > 0){
            output.add(currentPermutation);
        } else {

            for (int i = 0; i < array.size(); i++) {
                List<Integer> newArray = new ArrayList<>(array);
                newArray.remove(i);
                List<Integer> newPermutations = new ArrayList<>(currentPermutation);
                newPermutations.add(array.get(i));
                permutationHelper(newArray, newPermutations, output);
            }
        }
    }

    private void permutationHelperOptimized(List<Integer> array, List<List<Integer>> output, int start){
        if(start == array.size() -1){
            output.add(new ArrayList<>(array));
        } else {
            for(int i = start ; i < array.size(); i++){
                swap(i, start, array);
                permutationHelperOptimized(array, output, start+1);
                swap(i, start, array);
            }
        }
    }

    private void swap(int i, int j, List<Integer> array){
        int temp = array.get(i);
        array.set(i, array.get(j));
        array.set(j, temp);
    }

}
