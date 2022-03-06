public class MaxConsecutiveOnes3 {

    public static void main(String[] args) {
        MaxConsecutiveOnes3 maxConsecutiveOnes3 = new MaxConsecutiveOnes3();
        maxConsecutiveOnes3.longestOnes(new int[]{1,1,1,0,0,0,1,1,1,1,0}, 2);
    }

    public int longestOnes(int[] nums, int k) {
        int left = 0, right;
        for (right = 0; right < nums.length; right++) {
            // If we included a zero in the window we reduce the value of k.
            // Since k is the maximum zeros allowed in a window.
            if (nums[right] == 0) {
                k--;
            }
            // A negative k denotes we have consumed all allowed flips and window has
            // more than allowed zeros, thus increment left pointer by 1 to keep the window size same.
            if (k < 0) {
                // If the left element to be thrown out is zero we increase k.
                k += 1 - nums[left];
                left++;
            }
        }
        return right - left;
    }
}
