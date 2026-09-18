class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        long dp[][] = new long[m][n];
        if(grid[m-1][n-1] == 1 || grid[0][0] == 1)
            return 0;
        
        dp[m-1][n-1] = 1;
        
        for(int i = m-1; i >= 0; i--) {
            for(int j = n-1; j >= 0; j--) {
                if(grid[i][j] == 1)
                    dp[i][j] = 0;
                else {
                    if(i+1 < m)
                        dp[i][j] += dp[i+1][j];
                    if(j+1 < n)
                        dp[i][j] += dp[i][j+1];
                }
            }
        }

        return (int)(dp[0][0] % (2 * 1e9));
    }
}