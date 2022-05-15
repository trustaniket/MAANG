package Arrays;

public class MinimumSwapsFor0s1s {

    public static int minSwaps(int[] arr){
        int countOnes = 0;
        int output = 0;
        for(int i : arr){
            if(i == 1)
                countOnes++;
        }

        int countZero = 0;

        for(int i =0; i <  countOnes ; i++){
            if(arr[i] == 0)
                countZero++;
        }
        output = countZero;

        for(int i = countOnes; i < arr.length; i++){
            if(arr[i] == 0)
                countZero++;
            if(arr[i - countOnes] == 0){
                countZero--;
            }
            output = Math.min(output, countZero);
        }

        return output;

    }
}
