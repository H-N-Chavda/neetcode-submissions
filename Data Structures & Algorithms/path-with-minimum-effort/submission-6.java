class Solution {
    final int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};

    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        int[][] dist = new int[n][m];
        for(int[] d : dist)
            Arrays.fill(d, Integer.MAX_VALUE);

        dist[0][0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) -> Integer.compare(a[2], b[2])
        );

        pq.offer(new int[] {0,0,0});

        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            if(curr[0] == n-1 && curr[1] == m-1)
                return curr[2];

            for(int[] dir : dirs) {
                int x = curr[0] + dir[0];
                int y = curr[1] + dir[1];
                if(x < 0 || x >= n || y < 0 || y >= m)
                    continue;

                int diff = Math.abs(heights[x][y] - heights[curr[0]][curr[1]]);
                diff = Math.max(diff, curr[2]);

                if(diff < dist[x][y]) {
                    dist[x][y] = diff;
                    pq.offer(new int[] {x, y, diff});
                }
            }
        }

        return -1;
    }
}