import java.util.Comparator;
import java.util.PriorityQueue;

class MedianFinder {
    PriorityQueue<Double> minHeap;
    PriorityQueue<Double> maxHeap;

    public MedianFinder() {
        this.minHeap = new PriorityQueue<>(Comparator.comparingDouble(v -> v));
        this.maxHeap = new PriorityQueue<>(Comparator.comparingDouble(v -> -v));
    }

    public void addNum(int num) {
        if(this.maxHeap.isEmpty()) {
            maxHeap.add((double) num);
            return;
        }

        if(num <= maxHeap.peek()) {
            maxHeap.add((double) num);
        } else {
            minHeap.add((double) num);
        }

        if(this.maxHeap.size() >= this.minHeap.size() + 2) {
            this.minHeap.add(this.maxHeap.poll());
        } else if(this.maxHeap.size() <this.minHeap.size()) {
            this.maxHeap.add(this.minHeap.poll());
        }
    }

    public double findMedian() {
        if(this.maxHeap.size() == this.minHeap.size()) {
            return (this.maxHeap.peek() + this.minHeap.peek()) / 2;
        }

        return this.maxHeap.peek();
    }
}
