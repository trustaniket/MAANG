import java.util.*;

public class AlienDictionary {

    // This problem can be solved with Topological sort in BFS manner (BFS => Queue)

    public String sortedOrder(String[] arr){
        Map<Character, List<Character>> adjacencyList = new HashMap<>();
        Map<Character, Integer> indegrees = new HashMap<>();

        //Step 1 : Create data structure
        for(String str : arr){
            for(int i = 0; i < str.length(); i++){
                adjacencyList.put(str.charAt(i), new ArrayList<>());
                indegrees.put(str.charAt(i), 0);
            }
        }

        //Step 2: Add edges
        for(int i = 0; i < arr.length - 1; i++){
            String first = arr[i];
            String second = arr[i+1];

            if(first.length() > second.length() && first.startsWith(second))
                return "";
            for(int j = 0 ; j < Math.min(first.length(), second.length()); j++){
                if(first.charAt(j) != second.charAt(j)){
                    adjacencyList.get(first.charAt(j)).add(second.charAt(j));
                    indegrees.put(second.charAt(j), indegrees.get(second.charAt(j))+ 1);
                    break;
                }
            }
        }

        //Step 3: BFS traversal on the graph
        Queue<Character> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();


        for(Character key : indegrees.keySet()){
            if(indegrees.get(key) == 0)
                queue.offer(key);
        }

        while (!queue.isEmpty()){
            Character key = queue.poll();
            sb.append(key);
            for(Character next : adjacencyList.get(key)){
                indegrees.put(next, indegrees.get(next) - 1);
                if(indegrees.get(next) == 0){
                    queue.offer(next);
                }
            }
        }

        if(sb.length() < indegrees.size())
            return "";
        return sb.toString();


    }

    public static void main(String[] args) {
        String[] words = { "baa", "abcd", "abca", "cab", "cad" };
        AlienDictionary alienDictionary = new AlienDictionary();
        System.out.println(alienDictionary.sortedOrder(words));

    }
}
