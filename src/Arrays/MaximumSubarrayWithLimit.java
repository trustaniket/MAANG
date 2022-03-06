package Arrays;

public class MaximumSubarrayWithLimit {

    public static void main(String[] args) {
        int[] C = {1, 2, 4, 4, 5, 5, 5, 7, 5};
        int B = 14;
        int A = 9;

        System.out.println(maxSubarray(A, B, C));
    }

    public static int maxSubarray(int A, int B, int[] C) {
        if(A == 1){
            return C[0];
        }

        int start = 0;
        int max = C[0];
        int output = 0;
        for(int i = 1 ; i < A; i++){
            if(max <= B){
                output = Math.max(max, output);
            }
            while (max + C[i] > B && start < i){
                max -= C[start];
            }

            max += C[i];
        }
        if(max <= B){
            output = Math.max(output, max);
        }
        return output;

    }
}
