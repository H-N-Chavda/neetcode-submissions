class MedianFinder {
    PriorityQueue<Integer> min = new PriorityQueue<>();
    PriorityQueue<Integer> max = new PriorityQueue<>(
        (a,b) -> Integer.compare(b,a)
    );

    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        if (max.isEmpty() || num <= max.peek())
            max.offer(num);
        else
            min.offer(num);

        if (max.size() - min.size() > 1)
            min.offer(max.poll());
        else if (min.size() > max.size())
            max.offer(min.poll());
    }
    
    public double findMedian() {
        if((max.size() + min.size())%2 == 1)
            return max.peek();
        else 
            return ((double)(max.peek() + min.peek())) / 2;
    }
}
