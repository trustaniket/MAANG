import java.util.Map;

public class MaximumLengthRepeatedSubarray {

    public static void main(String[] args) {
        MaximumLengthRepeatedSubarray maximumLengthRepeatedSubarray = new MaximumLengthRepeatedSubarray();
        maximumLengthRepeatedSubarray.findLength(new int[]{1,2,3,2,1}, new int[]{3,2,1,4,7});
    }

    public int findLength(int[] A, int[] B) {
        int ans = 0;
        int[][] memo = new int[A.length + 1][B.length + 1];
        for (int i = A.length - 1; i >= 0; --i) {
            for (int j = B.length - 1; j >= 0; --j) {
                if (A[i] == B[j]) {
                    memo[i][j] = memo[i+1][j+1] + 1;
                    if (ans < memo[i][j]) ans = memo[i][j];
                    break;
                }
            }
        }
        return ans;
    }
}
