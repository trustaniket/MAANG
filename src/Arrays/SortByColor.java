package Arrays;

import java.util.Arrays;
import java.util.Comparator;

public class SortByColor {

    public static void main(String[] args) {
        int[] arr = {2, 0, 0, 1, 0, 0, 2, 2, 1, 1, 0, 0, 1, 0, 2, 1, 1, 0, 1, 0, 1, 2, 2, 2, 0, 0, 1, 0, 2, 1, 1, 2,
                1, 2, 2, 1, 0, 2, 2, 1, 1, 1, 0, 1, 0, 1, 0, 2, 1, 2, 0, 2, 0, 1, 1, 0, 2, 2, 1, 2, 0, 2, 1, 1, 1, 2,
                0, 1, 0, 2, 2, 1, 0, 0, 1, 0, 1, 0, 0, 0, 1, 2, 1, 1, 0, 2, 1, 2, 0, 0, 0, 2, 2, 2, 2, 0, 0, 0, 1, 1,
                0, 2, 1, 2, 2, 2, 1, 2, 2, 0, 1, 0, 1, 2, 1, 1, 0, 1, 2, 0, 1, 0, 2, 2, 1, 2, 1, 0, 2, 2, 1, 1, 0, 2, 1, 2};

        System.out.println(sortColors(arr));
        sortColorsOnePass(arr);
        System.out.println(arr);
    }

    public static void sortColorsOnePass(int[] nums) {

        int low = 0;
        int high = nums.length - 1;
        int counter = 0;

        while(counter <= high){
            if(nums[counter] == 0){
                swap(counter, low, nums);
                counter++;
                low++;
            } else if (nums[counter] == 2){
                swap(counter, high, nums);
                //Do not increment the counter because we again need to check if the swapped number is 0 or 1
                high--;
            } else {
                counter++;
            }
        }

    }

    private static void swap(int i, int j, int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static int[] sortColors(int[] A) {

        int countR = 0;
        int countB = 0;
        int countW = 0;

        for(int i = 0 ; i < A.length; i++){
            if(A[i] == 0)
                countR++;
            else if(A[i] == 1)
                countW++;
            else
                countB++;
        }

        int[] output = new int[A.length];
        int i = 0;
        while(true){
            while(countR --> 0)
                output[i++] = 0;
            while(countW --> 0)
                output[i++] = 1;
            while(countB --> 0)
                output[i++] = 2;
            break;
        }

        return output;
    }
}
