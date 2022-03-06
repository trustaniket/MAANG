package Arrays;
/*
Given an array of integers A, a subarray of an array is said to be good if it fulfills any one of the criteria:
1. Length of the subarray is be even, and the sum of all the elements of the subarray must be less than B.
2. Length of the subarray is be odd, and the sum of all the elements of the subarray must be greater than B.
Your task is to find the count of good subarrays in A.
 */
public class GoodSubArray {

    public static void main(String[] args) {
        int[] A = {9, 12, 17, 9, 17, 16, 6, 4, 3, 8, 5, 13, 2, 9, 3, 13, 11};
        int B = 302;
        System.out.println(solve(A, B));
    }

    public static int solve(int[] A, int B) {
        int count = 0;
        int n = A.length;
        int sum = 0;
        int[] prefixSum = new int[n];
        prefixSum[0] = A[0];
        for(int i = 1 ; i < n; i++){
            prefixSum[i] = prefixSum[i-1] + A[i];
        }
        for(int i = 0 ; i < n; i++){
            sum = 0;
            for(int j = i; j < n; j++){
                sum += A[j];
                if((j - i + 1) % 2 == 0 && sum < B){
                    count++;
                } else if((j-i + 1) % 2 != 0 && sum > B){
                    count++;
                }
            }
        }

        return count;
    }
}
