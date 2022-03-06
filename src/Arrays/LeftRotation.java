package Arrays;

import java.util.ArrayList;

public class LeftRotation {

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);

        ArrayList<Integer> arr1 = new ArrayList<>();
        arr1.add(2);
        arr1.add(3);
        int[] b = {2,3};
        LeftRotation leftRotation = new LeftRotation();
        leftRotation.solve(arr, arr1);
    }

    public ArrayList<ArrayList<Integer>> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        ArrayList<ArrayList<Integer>> output = new ArrayList<>();

        for(int i :B){
            ArrayList<Integer> temp = (ArrayList<Integer>) A.clone();

            i = i % temp.size();
            int num = temp.size() - i-1;
            rotate(0, temp.size()-1, temp);
            rotate(0, num, temp);
            rotate(temp.size() - i , temp.size()-1, temp);
            output.add(temp);

        }

        return output;
    }

    private void rotate(int i, int j, ArrayList<Integer> arr){
        while(i < j){
            int temp = arr.get(i);
            arr.set(i, arr.get(j));
            arr.set(j, temp);
            i++;
            j--;
        }
    }
}
