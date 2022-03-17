package strings;

public class LengthLongestConsecutiveOnes {

    public static void main(String[] args) {
        String a = "010100110101";
        System.out.println(solve(a));
    }

    public static int solve(String A) {

        int maxLength  = 0;

        for(int i = 0; i < A.length(); i++){
            int length = 0;
            if(A.charAt(i) == '0'){
                int range = i - 1;
                while(range >= 0 && A.charAt(range) == '1'){
                    length++;
                    range--;
                }
                range = i+1;
                while(range < A.length() && A.charAt(range) == '1'){
                    length++;
                    range++;
                }
            }
            maxLength = Math.max(maxLength, length + 1);
        }

        return maxLength;

    }
}
