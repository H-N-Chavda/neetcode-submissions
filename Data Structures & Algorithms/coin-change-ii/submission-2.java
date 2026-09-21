class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        Arrays.sort(coins);
        int[][] dp = new int[amount + 1][n + 1];

        for(int i = 0; i <= n; i++)
            dp[0][i] = 1;

        for(int i = n - 1; i >= 0; i--) {
            for(int a = 0; a <= amount; a++) {
                if(a >= coins[i]) {
                    dp[a][i] = dp[a][i+1];
                    dp[a][i] += dp[a - coins[i]][i];
                }
            }
        }

        return dp[amount][0];
    }
}
