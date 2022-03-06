/*
*Given a set of non-negative integers, and a value sum, determine if there is a subset of the given set with sum equal to given sum.

Example:

Input: set[] = {3, 34, 4, 12, 5, 2}, sum = 9
Output: True
There is a subset (4, 5) with sum 9.

Input: set[] = {3, 34, 4, 12, 5, 2}, sum = 30
Output: False
There is no subset that add up to 30.
*
* */
public class SubsetSumProblem {

    static boolean isSubsetSum(int[] set, int n, int sum){
        if(sum == 0)
            return true;
        if(n == 0)
            return false;

        if(set[n-1] > sum)
            return isSubsetSum(set, n-1, sum);

        return isSubsetSum(set, n-1, sum) || isSubsetSum(set, n-1, sum - set[n-1]);
    }

    public static void main(String[] args) {
        int set[] = { 3, 34, 4, 12, 5, 2 };
        int sum = 9;
        int n = set.length;
        if (isSubSetSumDP(set, n, sum) == true)
            System.out.println("Found a subset"
                    + " with given sum");
        else
            System.out.println("No subset with"
                    + " given sum");
    }

    static boolean isSubSetSumDP(int[] set, int n, int sum){
        boolean subset[][] = new boolean[n+1][sum+1];

        for(int i = 0; i <= n; i++)
            subset[i][0] = true;

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= sum; j++){

                if(set[i-1] > j)
                    subset[i][j] = subset[i-1][j];
                else
                    subset[i][j] = subset[i-1][j] || subset[i-1][j-set[i-1]];
            }
        }

        return subset[n][sum];
    }
}
