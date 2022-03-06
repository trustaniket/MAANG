package Arrays;

import java.util.ArrayList;
import java.util.List;

public class SecondLargest {

    public static void main(String[] args) {
        System.out.println(Long.valueOf(7) + Long.valueOf(3));
        ArrayList<Long> extra = new ArrayList<>();
        extra.add(Long.valueOf(742384782) + Long.valueOf(999999999));
        System.out.println(extra);
    }

    public static int solve(List<Integer> A) {

        if(A.size() < 2)
            return -1;

        int first = A.get(0);
        int second = -1;
        for(int i = 1 ; i < A.size(); i++){
            if(A.get(i) > first){
                first = A.get(i);
            } else {
                second = Math.max(second, A.get(i));
            }
        }
        return second;
    }


}
