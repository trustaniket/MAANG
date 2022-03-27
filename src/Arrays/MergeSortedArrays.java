package Arrays;

import java.util.*;

public class MergeSortedArrays {

    static class Item {
        public int arrayIdx;
        public int num;

        public Item(int arrayIdx, int num) {
            this.arrayIdx = arrayIdx;
            this.num = num;
        }
    }

    // O(N * K) time and O(N + K) space N : total array elements and K : total arrays
    public static List<Integer> mergeSortedArrays(List<List<Integer>> arrays){
        List<Integer> sortedList = new ArrayList<>();
        List<Integer> elementIdxs = new ArrayList<>(Collections.nCopies(arrays.size(), 0));

        while(true){
            List<Item> smallestItems = new ArrayList<>();
            for(int arrayIdx = 0 ; arrayIdx < arrays.size(); arrayIdx++){
                List<Integer> relevantArray = arrays.get(arrayIdx);
                int elementIdx = elementIdxs.get(arrayIdx);
                if(elementIdx == relevantArray.size())
                    continue;
                smallestItems.add(new Item(arrayIdx, relevantArray.get(elementIdx)));
            }
            if(smallestItems.size() == 0)
                break;
            Item nextItem = getMinValue(smallestItems);
            sortedList.add(nextItem.num);
            elementIdxs.set(nextItem.arrayIdx, elementIdxs.get(nextItem.arrayIdx) + 1);
        }

        return sortedList;
    }

    public static Item getMinValue(List<Item> items){
        int minValueIdx = 0;
        for(int i = 1 ; i < items.size(); i++){
            if(items.get(i).num < items.get(minValueIdx).num)
                minValueIdx = i;
        }
        return items.get(minValueIdx);
    }

    public static void main(String[] args) {
        List<List<Integer>> arrays = new ArrayList<>();
        arrays.add(Arrays.asList(new Integer[] {1, 5, 9, 21}));
        arrays.add(Arrays.asList(new Integer[] {-1, 0}));
        arrays.add(Arrays.asList(new Integer[] {-124, 81, 121}));
        arrays.add(Arrays.asList(new Integer[] {3, 6, 12, 20, 150}));

        List<Integer> output = MergeSortedArrays.mergeSortedArraysHeap(arrays);
        System.out.println(output);
    }

    // Implement via priority queue O(NlogK + K) time and space O(N + K)
    static class HeapItem implements Comparable<HeapItem>{
        public int arrayIdx;
        public int elementIdx;
        public int num;

        public HeapItem(int arrayIdx, int elementIdx, int num) {
            this.arrayIdx = arrayIdx;
            this.elementIdx = elementIdx;
            this.num = num;
        }

        @Override
        public int compareTo(HeapItem o) {
            return Integer.compare(this.num, o.num);
        }
    }

    public static List<Integer> mergeSortedArraysHeap(List<List<Integer>> arrays){
        List<Integer> sortedList = new ArrayList<>();
        List<HeapItem> smallestItems = new ArrayList<>();

        for(int i = 0; i < arrays.size(); i++){
            smallestItems.add(new HeapItem(i,0, arrays.get(i).get(0)));
        }

        PriorityQueue<HeapItem> priorityQueue = new PriorityQueue<>(smallestItems);
        while (!priorityQueue.isEmpty()){
            HeapItem smallestItem = priorityQueue.poll();
            sortedList.add(smallestItem.num);
            if(smallestItem.elementIdx == arrays.get(smallestItem.arrayIdx).size() - 1)
                continue;
            priorityQueue.add(
                    new HeapItem(smallestItem.arrayIdx,
                            smallestItem.elementIdx + 1,
                            arrays.get(smallestItem.arrayIdx).get(smallestItem.elementIdx + 1)));
        }
        return sortedList;
    }
}
