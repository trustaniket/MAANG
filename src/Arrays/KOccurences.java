package Arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class KOccurences {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(3);
        list.add(3);

        System.out.println(getSum(5, 2, list));


    }

    public static int getSum(int A, int B, ArrayList<Integer> C) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i : C){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int sum = -1;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue() == B) {
                sum += entry.getKey();
            }
        }

        return sum;

    }
}
