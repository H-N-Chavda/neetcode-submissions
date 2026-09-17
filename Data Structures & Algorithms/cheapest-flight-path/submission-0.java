class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int INF = Integer.MAX_VALUE;
        List<int[]>[] adj = new ArrayList[n];
        for(int i = 0; i < n; i++)
            adj[i] = new ArrayList<>();
        for(int[] edge : flights)
            adj[edge[0]].add(new int[]{edge[1], edge[2]});

        int[][] dist = new int[n][k + 5];
        for(int i = 0; i < n; i++)
            Arrays.fill(dist[i], INF);
        dist[src][0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) -> a[0] - b[0]
        );
        pq.offer(new int[]{0, src, -1});

        while(!pq.isEmpty()) {
            int[] top = pq.poll();
            int cost = top[0], node = top[1], stops = top[2];

            if(node == dst)
                return cost;
            if(stops == k || dist[node][stops+1] < cost)
                continue;

            for(int[] nei : adj[node]) {
                int next = nei[0], wt = nei[1];
                int nextcost = cost + wt;
                int nextstops = stops + 1;

                if(dist[next][nextstops + 1] > nextcost) {
                    dist[next][nextstops + 1] = nextcost;
                    pq.offer(new int[] {nextcost, next, nextstops});
                }
            }
        }

        return -1;
    }
}
