import java.util.Arrays;

public class KClosestPointToOrigin {

    public static void main(String[] args) {
        int[][] arr = new int[][]{{3,3},{5,-1}, {-2,4}};

        System.out.println(kClosest(arr, 2));
    }

    public static int[][] kClosest(int[][] points, int k) {
        quickSelect(0, points.length - 1,points, k);
        return Arrays.copyOfRange(points, 0, k);
    }


    public static void quickSelect(int start, int end, int[][] points, int k){
        if(start >= end)
            return;

        int left = start;
        int right = end;

        int pivot = getDistance(points, (left + right)/2);

        while(left <= right){
            while(left <= right && getDistance(points, left) < pivot)
                left++;
            while(left <= right && getDistance(points, right) > pivot)
                right--;

            if(left <= right){
                int[] temp = points[right];
                points[right] = points[left];
                points[left] = temp;
                left++;
                right--;
            }
        }

        if((k-1) <= right){
            quickSelect(start, right, points, k);
        }
        else if((k-1) >= left){
            quickSelect(left, end, points, k);
        }

    }

    public static int getDistance(int[][] points, int i)
    {
        int x_direction = points[i][0] * points[i][0];
        int y_direction = points[i][1] * points[i][1];

        return x_direction + y_direction;
    }
}
