class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(b, a)
        );
        for(int stone : stones)
            pq.offer(stone);

        while(!pq.isEmpty()) {
            int x = pq.poll();
            if(pq.isEmpty())    return x;
            int y = pq.poll();

            if(x > y)
                pq.offer(x - y);
        }
        return 0;
    }
}
