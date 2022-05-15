package Arrays;

import java.util.HashMap;

/*
You are given an array of N integers, A1, A2 ,…, AN and an integer B. Return the of count of distinct numbers in all windows of size B.

Formally, return an array of size N-B+1 where i'th element in this array contains number of distinct elements in sequence Ai, Ai+1 ,..., Ai+B-1.

NOTE: if B > N, return an empty array.
 */
public class DistinctNumbers {

    public static void main(String[] args) {
        int[] arr = {1,2,1,3,4,3};
        System.out.println(dNums(arr, 3));
    }

    public static int[] dNums(int[] A, int B) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int start = 0;
        int end = 0;
        int len = A.length;
        int[] output = new int[len - B + 1];

        for(int i =0 ; i < B; i++){
            map.put(A[i], map.getOrDefault(A[i], 0) + 1);
        }

        output[0] = map.size();

        for(int i = 0 ; i < len - B; i++){
            map.put(A[i], map.get(A[i]) - 1);
            if(map.get(A[i]) == 0){
                map.remove(A[i]);
            }
            map.put(A[i+B], map.getOrDefault(A[i+ B], 0) + 1);

            output[i+1] = map.size();
        }

        return output;
    }
}
