public class SongPairDurationDivisbleBy60 {

    public static void main(String[] args) {
numPairsDivisibleBy60(new int[]{60,30,150,100,40,80,120});
    }

    public static int numPairsDivisibleBy60(int[] time) {
        int remainders[] = new int[60];
        int count = 0;
        for (int t: time) {
            if (t % 60 == 0) { // check if a%60==0 && b%60==0
                count += remainders[0];
            } else { // check if a%60+b%60==60
                count += remainders[60 - t % 60];
            }
            remainders[t % 60]++; // remember to update the remainders
        }
        return count;
    }

    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int ans = 0;
        int leftMax = 0, rightMax = 0;

        while(left < right){
            if(height[left] < height[right]){
                var i = (height[left] >= leftMax) ? (leftMax = height[left]) : (ans += (leftMax - height[left]));
                left++;
            }
            else{
                var i = (height[right] >= rightMax) ? (rightMax = height[right]) : (ans += (rightMax - height[right]));
                right--;
            }
        }

        return ans;
    }
}
