class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        boolean[] vis = new boolean[n];
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) -> a[0] - b[0]
        );
        pq.offer(new int[]{0,0,-1});
        int sum = 0;
        
        while(!pq.isEmpty()) {
            int curr[] = pq.poll();
            int u = curr[1];
            if(vis[u])
                continue;
            vis[u] = true;
            sum += curr[0];
            for(int i = 0; i < n; i++) {
                if(i == u)  continue;
                int dist = Math.abs(points[i][0] - points[u][0]) + Math.abs(points[i][1] - points[u][1]);
                pq.offer(new int[]{dist, i, u});
            }
        }

        return sum;
    }
}
