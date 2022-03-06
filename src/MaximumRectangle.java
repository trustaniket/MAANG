import java.util.Arrays;

public class MaximumRectangle {


    public static void main(String[] args) {
        char[][] matrix = new char[][]{{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        
        MaximumRectangle maximumRectangle = new MaximumRectangle();
        maximumRectangle.maximalRectangle(matrix);
    }
    public int maximalRectangle(char[][] matrix) {

        int temp[] = new int[matrix[0].length];

        Arrays.fill(temp, 0);

        int maxArea = 0;
        int area;
        for(int i=0; i < matrix.length; i++){
            for(int j=0; j < matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    temp[j] = 0;
                }else{
                    temp[j] += (matrix[i][j] - '0');
                }
            }
            area = maxHistogram(temp);
            if(area > maxArea){
                maxArea = area;
            }
        }
        return maxArea;
    }

    private int maxHistogram(int[] temp){
        int area = 0;
        int maxArea = 0;
        int len = 0;
        int j = 0;
        int l = 0;
        while(j < temp.length){
            for(int i = j; i< temp.length; i++){
                if(l == 0){
                    l = temp[i];
                    len = 1;
                }
                else{
                    area = Math.max(area, len * l);
                    l = Math.min(area, temp[i]);
                    len++;
                }
            }
            j++;
            maxArea = Math.max(area, maxArea);
        }

        return maxArea;
    }
}
