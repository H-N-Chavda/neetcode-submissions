class Solution {
    public int minimumEffortPath(int[][] heights) {
        int ROWS = heights.length;
        int COLS = heights[0].length;
        int[] dist = new int[ROWS * COLS];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        boolean[] inQ = new boolean[ROWS * COLS];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        inQ[0] = true;

        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        while(!queue.isEmpty()) {
            int u = queue.poll();
            inQ[u] = false;

            int r = u/COLS, c = u%COLS;

            for(int[] dir : dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                if(nr >= 0 && nc >= 0 && nr < ROWS && nc < COLS) {
                    int v = nr * COLS + nc;
                    int weight = Math.abs(heights[r][c] - heights[nr][nc]);
                    int ndist = Math.max(dist[u], weight);
                    if(ndist < dist[v]) {
                        dist[v] = ndist;
                        if(!inQ[v]) {
                            queue.offer(v);
                            inQ[v] = true;
                        }
                    }
                }
            }
        }

        return dist[ROWS * COLS - 1];
    }
}