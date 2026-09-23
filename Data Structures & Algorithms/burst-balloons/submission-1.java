class Solution {
    private int[] val;
    private Integer[][] dp;

    public int maxCoins(int[] nums) {
        int n = nums.length;
        dp = new Integer[n+2][n+2];
        val = new int[n+2];
        val[0] = val[n+1] = 1;
        for(int i = 1; i <= n; i++)
            val[i] = nums[i-1];

        return dfs(0, n+1);
    }

    private int dfs(int left, int right) {
        if(left + 1 == right)
            return 0;
        
        if(dp[left][right] != null)
            return dp[left][right];

        int best = 0;
        for(int k = left + 1; k < right; k++) {
            int coins = (val[left] * val[k] * val[right]) + dfs(left, k) + dfs(k, right);
            best = Math.max(best, coins);
        }

        return dp[left][right] = best;
    }
}
