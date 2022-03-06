/*
* Given a set of integers, the task is to divide it into two sets S1 and S2 such that the absolute difference between their sums is minimum.
If there is a set S with n elements, then if we assume Subset1 has m elements, Subset2 must have n-m elements and the value of abs(sum(Subset1) – sum(Subset2)) should be minimum.

Example:

Input:  arr[] = {1, 6, 11, 5}
Output: 1
Explanation:
Subset1 = {1, 5, 6}, sum of Subset1 = 12
Subset2 = {11}, sum of Subset2 = 11
* */


import java.util.Collections;

public class MinimumSubsetSumProblem {

    static int findMinRecursive(int[] arr, int n){
        int sumTotal = 0;

        for(int a : arr)
            sumTotal += a;

        return findMinHelper(arr, n, 0, sumTotal);
    }

    static int findMinHelper(int[] arr, int i, int sumCalculated, int sumTotal){
        if (i == 0)
            return Math.abs((sumTotal - sumCalculated) - sumCalculated);

        return Math.min(findMinHelper(arr, i-1, sumCalculated, sumTotal), findMinHelper(arr, i-1, sumCalculated + arr[i-1], sumTotal));
    }


    public static void main(String[] args) {
        int arr[] = { 3, 1, 4, 2, 2, 1 };
        int n = arr.length;
        System.out.print("The minimum difference"
                + " between two sets is "
                + findMinDiffDP(arr, n));
    }


    static int findMinDiffDP(int arr[], int n){
        int sumTotal = 0;

        for(int a : arr)
            sumTotal += a;
        boolean dp[][] = new boolean[n+1][sumTotal +1];

        for(int i = 0; i <= n; i++){
            dp[i][0] = true;
        }

        for(int i = 1; i <= sumTotal; i++)
            dp[0][i] = false;

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= sumTotal; j++){
                dp[i][j] = dp[i-1][j];

                if(arr[i-1] <= j){
                    dp[i][j] = dp[i-1][j - arr[i-1]];
                }
            }
        }

        int diff = Integer.MAX_VALUE;

        for(int i = sumTotal / 2; i >=0; i--){
            if(dp[n][i] == true){
                diff = sumTotal - 2*i;
                break;
            }
        }

        return diff;





    }

}
