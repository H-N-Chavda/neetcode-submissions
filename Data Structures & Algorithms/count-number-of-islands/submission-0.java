class Solution {
    boolean[][] vis;
    int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        vis = new boolean[m][n];

        int count = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == '1' && !vis[i][j]) {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }

        return count;
    }

    private void dfs(char[][] grid, int x, int y) {
        vis[x][y] = true;
        for(int[] dir : dirs) {
            int nx = x + dir[0];
            int ny = y + dir[1];
            if(nx >= 0 && nx < grid.length && 
                ny >= 0 && ny < grid[0].length && 
                !vis[nx][ny] && grid[nx][ny] == '1')
                dfs(grid, nx, ny);
        }
        return;
    }
}
