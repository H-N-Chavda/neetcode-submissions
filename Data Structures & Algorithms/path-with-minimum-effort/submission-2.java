class Solution {
    private int ROWS, COLS;
    private int[][] heights;
    private int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private boolean[][] vis;

    public int minimumEffortPath(int[][] heights) {
        this.heights = heights;
        this.ROWS = heights.length;
        this.COLS = heights[0].length;
        this.vis = new boolean[ROWS][COLS];

        int l = 0, r = 1_000_000, res = r;

        while(l <= r) {
            int mid = l + (r-l)/2;
            for(boolean[] row : vis)
                Arrays.fill(row, false);

            if(dfs(0,0,mid)) {
                res = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return res;    
    }

    private boolean dfs(int r, int c, int limit) {
        if(r == ROWS-1 && c == COLS-1)
            return true;

        vis[r][c] = true;
        for(int[] dir : dirs) {
            int nc = c + dir[1];
            int nr = r + dir[0];
            if(nr < 0 || nr >= ROWS || nc < 0 || nc >= COLS || vis[nr][nc])
                continue;

            if(Math.abs(heights[nr][nc] - heights[r][c]) > limit)
                continue;
            
            if(dfs(nr, nc, limit))
                return true;
        }

        return false;
    }
}