class Solution {
    public int maxProfit(int[] prices) {
        Integer[][] dp = new Integer[prices.length][2];
        return dfs(prices, 0, true, dp);
    }

    private int dfs(int[] prices, int idx, boolean canBuy, Integer[][] dp) {
        if (idx >= prices.length) return 0;

        int key = canBuy ? 1 : 0;
        if (dp[idx][key] != null) return dp[idx][key];

        int doNothing = dfs(prices, idx + 1, canBuy, dp);
        int doSomething;
        if (canBuy) {
            // buy today
            doSomething = -prices[idx] + dfs(prices, idx + 1, false, dp);
        } else {
            // sell today, then cooldown one day
            doSomething = prices[idx] + dfs(prices, idx + 2, true, dp);
        }

        return dp[idx][key] = Math.max(doNothing, doSomething);
    }
}
