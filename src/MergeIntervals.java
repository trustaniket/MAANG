import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {

    public static void main(String[] args) {
        int[][] intervals = {{1,2}, {3,5}, {4,7}, {9,10}, {6,8}};

        MergeIntervals mergeIntervals = new MergeIntervals();
        mergeIntervals.mergeOverlappingIntervals(intervals);
    }

    public int[][] mergeOverlappingIntervals(int[][] intervals) {
        List<int[]> mergedIntervals = new ArrayList<>();
        int[][] sortedIntervals = intervals.clone();
        Arrays.sort(sortedIntervals, Comparator.comparingInt(a -> a[0]));

        int[] currentInterval = sortedIntervals[0];
        mergedIntervals.add(currentInterval);


        for(int[] nextInterval : sortedIntervals){
            int currentIntervalEnd = currentInterval[1];
            int nextIntervalStart = nextInterval[0];
            int nextIntervalEnd = nextInterval[1];

            if(currentIntervalEnd >= nextIntervalStart){
                currentInterval[1] = Math.max(currentIntervalEnd, nextIntervalEnd);
            } else {
                currentInterval = nextInterval;
                mergedIntervals.add(currentInterval);
            }
        }
        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
    }
}
