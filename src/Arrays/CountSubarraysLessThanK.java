package Arrays;

public class CountSubarraysLessThanK {

    public static void main(String[] args) {
        int[] C = {12, 10, 9, 17, 8, 17, 16, 16, 7, 17, 3, 14, 1, 19, 7, 19, 5, 11, 3};
        int B = 210;

        System.out.println(solve(C, B));
    }

    public static int solve(int[] A, int B) {
        int[] copy = new int[A.length];
        copy[0] = A[0];
        for(int i = 1; i < A.length; i++){
            copy[i] = copy[i-1] + A[i];
        }
        int count = 0;
        for(int i = 0 ; i < copy.length; i++){
            if(copy[i] < B){
                count = count + (i + 1) ;
            } else {
                int start = 0;
                int temp = copy[i];
                while(temp > B && start < i){
                    temp = temp - A[start];
                    if(temp < B){
                        count  = count + i + 1 - (start + 1);
                    }
                    start++;
                }
            }
        }
        return count;
    }
}
