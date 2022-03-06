import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class RemoveIslands {

    int[][] matrix;
    int rows;
    int cols;

    public static void main(String[] args) {

        



        RemoveIslands removeIslands = new RemoveIslands();
        int[][] island = {
                {1, 0, 0, 0, 0, 0},
  {0, 1, 0, 1, 1, 1},
  {0, 0, 1, 0, 1, 0},
  {1, 1, 0, 0, 1, 0},
  {1, 0, 1, 1, 0, 0},
  {1, 0, 0, 0, 0, 1}
};

        removeIslands.removeIslands(island);
    }

    public int[][] removeIslands(int[][] matrix) {
        this.matrix = matrix;
        this.rows = matrix.length;
        this.cols = matrix[0].length;


        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                boolean isRowBorder = (i == 0) || (i == rows-1);
                boolean isColBorder = (j == 0) || ( j == cols -1);

                boolean isBorder = isRowBorder || isColBorder;

                if(!isBorder)
                    continue;


                if(matrix[i][j] != 1)
                    continue;

                changeBorderOneToTwo(i, j);

            }
        }

        for(int i = 0; i < rows; i++){
            for(int j =0; j < cols; j++){
                int color = matrix[i][j];
                if(color == 1)
                    matrix[i][j] = 0;
                else if(color == 2)
                    matrix[i][j] = 1;
            }
        }


        return matrix;
    }

    private void changeBorderOneToTwo(int row, int col){
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{row, col});

        int[][] directions = {{-1,0}, {0,1}, {1,0}, {0, -1}};

        while(!stack.isEmpty()){
            int[] out = stack.pop();
            matrix[out[0]][out[1]] = 2;

            for(int[] dir: directions){
                int newR = out[0] + dir[0];
                int newC = out[1] + dir[1];

                if(newR >=0 && newR < rows && newC >= 0 && newC < cols && matrix[newR][newC] == 1)
                    stack.push(new int[]{newR, newC});
                else
                    continue;
            }
        }

    }
}
