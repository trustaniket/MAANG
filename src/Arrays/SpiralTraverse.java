package Arrays;

import java.util.ArrayList;
import java.util.List;

public class SpiralTraverse {
    public static List<Integer> spiralTraverse(int[][] array) {
        if(array.length == 0)
            return new ArrayList<>();
        var list = new ArrayList<Integer>();
        int startR = 0;
        int startC = 0;
        int endR = array.length - 1;
        int endC = array[0].length - 1;

        while(startR <= endR && startC <= endC){
            //run 4 for loops
            for(int col = startC; col <= endC; col++)
                list.add(array[startR][col]);

            for(int row = startR+1; row <= endR; row++){
                list.add(array[row][endC]);
            }

            for(int col = endC -1; col >= startC; col--){
                if(startR == endR)
                    break;
                list.add(array[endR][col]);
            }

            for(int row = endR -1; row > startR; row--){
                if(startC == endC)
                    break;
                list.add(array[row][startC]);
            }

            startR++;
            startC++;
            endR--;
            endC--;
        }

        return list;
    }

    public static void main(String[] args) {
        int[][] arr = {{1,2,3,4}, {10,11,12,5}, {9,8,7,6}};
        List<Integer> out = spiralTraverse(arr);
        System.out.println(out);
    }
}
