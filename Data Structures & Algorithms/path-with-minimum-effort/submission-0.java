class Solution {
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        int vis[][] = new int[m][n];
        for (int i = 0; i < m; i++) Arrays.fill(vis[i], Integer.MAX_VALUE);

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {0, 0, 0});
        vis[0][0] = 0;

        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int x = curr[0], y = curr[1], effort = curr[2];

            if (effort > vis[x][y]) continue;

            for (int[] dir : dirs) {
                int nx = x + dir[0];
                int ny = y + dir[1];

                if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                    int nextEffort = Math.max(effort, Math.abs(heights[x][y] - heights[nx][ny]));

                    if (nextEffort < vis[nx][ny]) {
                        vis[nx][ny] = nextEffort;
                        q.offer(new int[] {nx, ny, nextEffort});
                    }
                }
            }
        }

        return vis[m - 1][n - 1];
    }
}