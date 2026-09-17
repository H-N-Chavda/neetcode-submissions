class Solution {
    private int[] parent;

    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        parent = new int[n];
        for(int i = 0; i < n; i++)
            parent[i] = i;
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) -> a[0]-b[0]
        );

        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                int dist = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                pq.offer(new int[] {dist, i, j});
            }
        }

        int sum = 0;
        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            if(find(curr[1]) == find(curr[2]))
                continue;

            sum += curr[0];
            System.out.println(sum + " " + curr[1] + " " + curr[2]);
            parent[parent[curr[2]]] = parent[curr[1]];
        }

        return sum;
    }

    private int find(int u) {
        if(parent[u] != u)
            parent[u] = find(parent[u]);
        return parent[u];
    }
}
