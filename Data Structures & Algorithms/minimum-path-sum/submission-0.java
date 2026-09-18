class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++)
            Arrays.fill(dp[i], 8000001);
        dp[m-1][n-1] = grid[m-1][n-1];

        for(int i = m-1; i >= 0; i--) {
            for(int j = n-1; j >= 0; j--) {
                if(i + 1 < m)
                    dp[i][j] = Math.min(dp[i][j], dp[i+1][j] + grid[i][j]);
                if(j + 1 < n)
                    dp[i][j] = Math.min(dp[i][j], dp[i][j+1] + grid[i][j]);
            }
        }

        return dp[0][0];
    }
}