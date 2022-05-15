package strings;

public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        LongestPalindromicSubstring palindromicSubstring = new LongestPalindromicSubstring();
        System.out.println(palindromicSubstring.longestPalindrome("abbcccbbbcaaccbababcbcabca"));
        System.out.println("check" + 4%10);
    }

    public String longestPalindrome(String A) {
        int longest[] = {0,1};

        for(int i = 1; i < A.length(); i++){
            int[] odd = getPalindromeLength(A, i-1, i+1);
            int[] even = getPalindromeLength(A, i-1, i);

            int[] currentLongest = (odd[1] - odd[0]) > (even[1] - even[0]) ? odd : even;

            longest = (longest[1] - longest[0]) > (currentLongest[1] - currentLongest[0] )? longest : currentLongest;
        }

        return A.substring(longest[0], longest[1]);
    }

    private int[] getPalindromeLength(String str, int left, int right){
        while(left >= 0 && right < str.length()){
            if(str.charAt(left) != str.charAt(right))
                break;
            left--;
            right++;
        }

        return new int[]{left+1, right};
    }


}
