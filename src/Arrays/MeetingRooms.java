package Arrays;

import java.util.Arrays;

public class MeetingRooms {

    public static void main(String[] args) {
        int[][] intervals = {{0,30}, {5,10}, {15, 20}};
        System.out.println(findMinMeetingRooms(intervals));
    }

    public static int findMinMeetingRooms(int[][] intervals){
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];

        for(int i = 0 ; i < intervals.length; i++){
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int usedRooms = 0;
        int sp = 0;
        int ep = 0;

        while(sp < start.length){
            if(start[sp] >= end[ep]){
                usedRooms--;
                ep++;
            }
            usedRooms++;
            sp++;
        }
        return usedRooms;
    }
}
