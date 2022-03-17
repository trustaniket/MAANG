import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFinder {

    private PriorityQueue<Integer> max;
    private PriorityQueue<Integer> min;
    int size;
    /** initialize your data structure here. */
    public MedianFinder() {
        max = new PriorityQueue<>(Collections.reverseOrder());
        min = new PriorityQueue<>();
        size = 0;
    }
    public void addNum(int num) {
        if(size % 2 == 0){
            min.add(num);
            max.add(min.poll());
        } else{
            max.add(num);
            min.add(max.poll());
        }
        size++;
    }

    public double findMedian() {
        if(size % 2 == 0){
            return ((double) max.peek() + (double) min.peek()) / 2;
        } else{
            return (double) max.peek();
        }
    }

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();

        medianFinder.addNum(1);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(4);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(5);
        System.out.println(medianFinder.findMedian());

    }
}
