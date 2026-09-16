class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for(int[] time : times) {
            adj.get(time[0]).add(new int[]{time[1], time[2]});
        }

        int dist[] = new int[n+1];
        Arrays.fill(dist, 100001);
        dist[0] = 0; dist[k] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) -> a[0] - b[0]
        ); // PQ with {distance, node} from k

        pq.offer(new int[]{0, k});

        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            for(int[] next : adj.get(curr[1])) {
                if(curr[0] + next[1] < dist[next[0]]) {
                    dist[next[0]] = curr[0] + next[1];
                    pq.offer(new int[]{dist[next[0]], next[0]});
                }
            }
        }

        int ans = 0;
        for(int d : dist) {
            if(d >= 100001)
                return -1;
            ans = Math.max(ans, d);
        }

        return ans;
    }
}
