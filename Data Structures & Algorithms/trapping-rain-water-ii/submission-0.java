class Solution {
    public int trapRainWater(int[][] height) {
        int m = height.length, n = height[0].length;
        if(m < 3 || n < 3)
            return 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[2]-b[2]);
        boolean[][] vis = new boolean[m][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i == 0 || i == m-1 || j == 0 || j == n-1) {
                    pq.offer(new int[] {i, j, height[i][j]});
                    vis[i][j] = true;
                }
            }
        }

        int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        int water = 0;

        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            int h = curr[2];

            for(int[] dir : dirs) {
                int nx = curr[0] + dir[0];
                int ny = curr[1] + dir[1];

                if(nx < 0 || nx == m || ny < 0 || ny == n || vis[nx][ny])
                    continue;

                vis[nx][ny] = true;
                water += Math.max(0, h - height[nx][ny]);
                pq.offer(new int[] {nx, ny, Math.max(h, height[nx][ny])});
            }
        }

        return water;
    }
}