import java.util.ArrayList;
import java.util.List;

public class CountInversions {

    int countInversion(int[] arr){
        return countInversionHelper(arr, 0, arr.length);
    }

    private int countInversionHelper(int[] arr, int start, int end){

        if(end - start <= 1)
            return 0;

        int middle = start + (end - start)/2;
        int leftInversions = countInversionHelper(arr, start, middle);
        int rightInversions = countInversionHelper(arr, middle, end);
        int mergedInversions = getMergedInversions(arr, start, middle, end);

        return leftInversions + rightInversions + mergedInversions;
    }

    private int getMergedInversions(int[] arr, int start, int middle, int end){
        int left = start;
        int right = middle;
        List<Integer> list = new ArrayList<>();
        int count = 0;

        while(left < middle && right < end){
            if(arr[left] <= arr[right]){
                list.add(arr[left++]);
            } else {
                count += middle - left;
                list.add(arr[right++]);
            }
        }

        for(int i = left; i < middle; i++){
            list.add(arr[i]);
        }
        for(int i = right; i < end; i++){
            list.add(arr[i]);
        }

        for(int i = 0; i < list.size(); i++){
            int num = list.get(i);
            arr[start + i] = num;
        }

        return count;
    }

    public static void main(String[] args) {
        CountInversions countInversions = new CountInversions();
        System.out.println(countInversions.countInversion(new int[]{2, 3, 3, 1, 9, 5, 6}));
    }
}
