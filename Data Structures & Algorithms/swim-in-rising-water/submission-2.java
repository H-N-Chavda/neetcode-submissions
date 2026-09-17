class Solution {
    private int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
    private boolean[][] vis;
    private int[][] grid;
    private int ROWS,COLS;

    public int swimInWater(int[][] grid) {
        this.grid = grid;
        ROWS = grid.length;
        COLS = grid[0].length;
        vis = new boolean[ROWS][COLS];
        int l = Math.max(grid[0][0], grid[ROWS-1][COLS-1]);
        int r = ROWS * COLS;
        int ans = 0;

        while(l <= r) {
            int mid = l + (r-l)/2;

            for(int i = 0; i < ROWS; i++)
                Arrays.fill(vis[i], false);

            if(grid[0][0] <= mid && dfs(mid, 0, 0)) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return ans;
    }

    private boolean dfs(int maxi, int x, int y) {
        if(x == ROWS - 1 && y == COLS - 1)
            return true;
        
        vis[x][y] = true;
        for(int[] dir : dirs) {
            int nx = x + dir[0];
            int ny = y + dir[1];

            if(nx < 0 || ny < 0 || nx >= ROWS || ny >= COLS)
                continue;
            if(vis[nx][ny] || grid[nx][ny] > maxi)
                continue;

            if(dfs(maxi, nx, ny))
                return true;
        }
        return false;
    }
}