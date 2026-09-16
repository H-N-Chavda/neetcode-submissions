class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int dist[] = new int[n+1];
        Arrays.fill(dist, 100001);
        dist[k] = 0;
        dist[0] = 0;

        for(int i = 1; i <= n-1; i++) {
            for(int[] edge : times) {
                int u = edge[0], v = edge[1], wt = edge[2];
                if(dist[u] + wt < dist[v])
                    dist[v] = dist[u] + wt;
            }
        }

        int sum = 0; 
        for(int d : dist) {
            if(d >= 100001)
                return -1;
            sum = Math.max(sum, d);
        }

        return sum;
    }
}
