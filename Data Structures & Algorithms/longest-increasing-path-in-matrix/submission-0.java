class Solution {
    private int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    private Integer[][] memo;
    private int M;
    private int N;

    public int longestIncreasingPath(int[][] matrix) {
        this.M = matrix.length;
        this.N = matrix[0].length;
        memo = new Integer[M][N];

        int maxi = 1;
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                if(memo[i][j] == null) {
                    dfs(matrix, i, j);
                    maxi = Math.max(maxi, memo[i][j]);
                }
            }
        }

        return maxi;
    }

    private int dfs(int[][] matrix, int x, int y) {
        if(memo[x][y] != null)
            return memo[x][y];

        int ans = 1;
        for(int[] dir : dirs) {
            int nx = x + dir[0];
            int ny = y + dir[1];

            if(nx >= M || nx < 0 || ny >= N || ny < 0)
                continue;
            if(matrix[nx][ny] > matrix[x][y])
                ans = Math.max(ans, 1 + dfs(matrix, nx, ny));
        }
        return memo[x][y] = ans;
    }
}
