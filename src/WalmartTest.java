public class WalmartTest {

    // string : didic
    // return longest palindromic substring
    // if not found return empty string
    //did deed

    // check for every index O(n)
    //

    public static void main(String[] args) {
        WalmartTest walmartTest = new WalmartTest();
        System.out.println(walmartTest.longestPalindrome("didic"));
    }

    public String longestPalindrome(String s){
        if(s == null || s.equals("")){
            return "Error";
        }

        int[] longest = {0,1};

        for(int i = 1; i < s.length(); i++){
            int[] oddLength = getLongestPalidrome(s, i-1, i+1);
            int[] evenLength =  getLongestPalidrome(s, i-1, i);

            int[] currentLongest = evenLength[1] - evenLength[0] > oddLength[1] - oddLength[0] ? evenLength : oddLength;

            longest = longest[1] - longest[0] >= currentLongest[1] - currentLongest[0] ? longest : currentLongest;

        }

        return longest[1] - longest[0] > 2 ?  s.substring(longest[0], longest[1]) : "Error";
    }

    public int[] getLongestPalidrome(String s, int start, int end){
        while(start >= 0 && end < s.length()){
            if(s.charAt(start) != s.charAt(end))
                break;
            start--;
            end++;
        }
        return new int[]{start + 1, end};
    }

}
/*
* Employee Object: id (string), name(string) and designation(string)
*
*
*
*  */