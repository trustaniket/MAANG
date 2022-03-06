public class SearchInRotatedArray {

    public static void main(String[] args) {
        //System.out.println(search(new int[]{4,5,6,7,0,1,2}, 0));

        System.out.println(searchII(new int[]{2,5,6,7,8,0,0,1,2}, 0));
    }

    public static  int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length -1;

        while(start <= end){
            int mid = start + (end - start)/2;

            if(nums[mid] == target)
                return mid;
            else if(nums[mid] >= nums[start]){
                if(target >= nums[start] && target < nums[mid])
                    end = mid -1;
                else
                    start = mid + 1;
            }
            else{
                if(target <= nums[end] && target > nums[mid] )
                    start = mid + 1;
                else
                    end = mid -1;
            }
        }

        return -1;
    }

    public  static boolean searchII(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while(start <= end){
            int mid = start + (end - start)/2;

            if(target == nums[mid])
                return true;

            if(nums[mid] < nums[end] || nums[mid] < nums[start]){
                if(target > nums[mid] && target <= nums[end])
                    start = mid + 1;
                else
                    end = mid -1;
            }
            else if(nums[mid] > nums[start] || nums[mid] > nums[end]){
                if(target < nums[mid] && target >= nums[start])
                    end = mid - 1;
                else
                    start = mid +1;
            }
            else
                end--;

        }
        return false;
    }
}
