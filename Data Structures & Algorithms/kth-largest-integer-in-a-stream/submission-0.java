class KthLargest {
    PriorityQueue<Integer> pq = new PriorityQueue<>(
        (a, b) -> Integer.compare(b, a)
    );
    int k = 0;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        for(int num : nums)
            pq.offer(num);
    }
    
    public int add(int val) {
        pq.offer(val);
        List<Integer> temp = new ArrayList<>();
        for(int i = 0; i < k; i++)
            temp.add(pq.poll());

        int ans = temp.get(temp.size() - 1);
        while(!temp.isEmpty()) {
            pq.offer(temp.get(0));
            temp.remove(0);
        }
        return ans;
    }
}
