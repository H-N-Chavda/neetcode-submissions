class Solution {
    int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
    boolean[][] vis;
    int counter = 0;
    int m, n;

    public int islandPerimeter(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        vis = new boolean[m][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1) {
                    dfs(grid, i, j);
                    break;
                }
            }
        }

        return counter;
    }

    private void dfs(int[][] grid, int i, int j) {
        if(i >= m || i < 0 || j >= n || j < 0 || grid[i][j] != 1) {
            counter++;
            return;
        }
        if(vis[i][j])
            return;

        vis[i][j] = true;
        for(int[] dir : dirs) {
            dfs(grid, i + dir[0], j + dir[1]);
        }
        return;
    }
}