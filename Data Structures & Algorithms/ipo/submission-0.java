class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<Integer> cache = new PriorityQueue<>(
            (i, j) -> Integer.compare(capital[i], capital[j])
        );

        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (i, j) -> Integer.compare(profits[j], profits[i])
        );

        for(int i = 0; i < profits.length; i++) {
            if(capital[i] <= w)
                pq.offer(i);
            else 
                cache.offer(i);
        }

        int count = 0;
        while(count++ < k) {
            if(pq.isEmpty())
                return w;

            int proj = pq.poll();
            w += profits[proj];

            while(!cache.isEmpty() && capital[cache.peek()] <= w)
                pq.offer(cache.poll());
        }

        return w;
    }
}