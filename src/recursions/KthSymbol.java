package recursions;

import java.util.Stack;

/*
On the first row, we write a 0. Now in every subsequent row, we look at the previous row and replace each occurrence of 0 with 01, and each occurrence of 1 with 10.

Given row A and index B, return the Bth indexed symbol in row A. (The values of B are 1-indexed.) (1 indexed).
 */
public class KthSymbol {


    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();
        stack.peek();
        KthSymbol kthSymbol = new KthSymbol();
        //System.out.println(kthSymbol.solve(2,2));

        System.out.println(kthSymbol.solveMid(2,2));
    }

    public int solveMid(int A, int B) {
        return solveQ(A, B) ? 1 : 0;
    }
    static boolean solveQ(int n, int k) {

        if (n == 1 && k == 1)
            return false;

        int mid = (int) Math.pow(2, n - 1) / 2;

        if (k <= mid)
            return solveQ(n - 1, k);
        else
            return !solveQ(n - 1, k - mid);
    }

    public int solve(int A, int B) {
        return helper(A, "-1", B);
    }

    private int helper(int A, String prev, int B){
        if(A == 0){
            String val = String.valueOf(prev);
            return val.charAt(B-1) - '0';
        }

        if(prev.equals("-1")){
            prev = "0";
        } else {
            StringBuffer sb = new StringBuffer();
            for(int i = 0 ; i < prev.length(); i++){
                if(prev.charAt(i) == '0'){
                    sb.append('0');
                    sb.append('1');
                } else {
                    sb.append('1');
                    sb.append('0');
                }
            }
            prev = sb.toString();
        }
        return helper(A -1, prev, B);
    }
}
