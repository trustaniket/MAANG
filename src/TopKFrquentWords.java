import java.util.*;

public class TopKFrquentWords {

    public static void main(String[] args) {
        String[] words = {"i","love","leetcode","i","love","coding"};

        System.out.println(topKFrequent(words, 2));
    }

    public  static List<String> topKFrequent(String[] words, int k) {

        Map<String, Integer> map = new HashMap<>();

        for(int i = 0; i< words.length; i++){
            map.put(words[i], map.getOrDefault(words[i], 0) + 1);
        }


        Arrays.sort(words, new Comparator<>(){
            @Override
            public int compare(String s1, String s2){
                int freq1 = map.get(s1);
                int freq2 = map.get(s2);
                int diff = freq2 - freq1;
                if(diff != 0)
                    return diff;
                else
                    return s1.compareTo(s2);
            }
        });

        Set<String> set= new LinkedHashSet<>();
        List<String> out = new ArrayList<>();

        for(int i = 0; i<words.length; i++){
            if(set.size() == k)
                break;
            else
                set.add(words[i]);
        }
        out.addAll(set);
        return out;

    }
}
