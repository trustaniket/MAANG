package Arrays;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {

    public static void main(String[] args) {
        int[] arr = {8, 89};
        System.out.println(largestNumber(arr));
        Integer arr1[] = {5,4,6,1};

        checkComparatorWorking(arr1);
    }

    public static void checkComparatorWorking(Integer[] arr){
        Arrays.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
    }

    public static String largestNumber(final int[] A) {

        Integer[] arr = new Integer[A.length];
        int j = 0;
        for(int i : A){
            arr[j++] = i;
        }

        Arrays.sort(arr, (a, b) -> {
            String a1 = "" + a + b;
            String a2 = "" + b + a;

            return a2.compareTo(a1);
        });

        StringBuffer sb = new StringBuffer();
        for(int i = 0 ; i < A.length; i++){
            sb.append(arr[i]);
        }

        return sb.toString();
    }
}
