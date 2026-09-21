class Solution {
    private int[][] dp;

    public int lastStoneWeightII(int[] stones) {
        int n = stones.length;
        int sum = 0;
        for(int stone : stones)
            sum += stone;

        int target = (sum + 1) / 2;

        dp = new int[n][target + 1];
        for(int i = 0; i < n; i++)
            Arrays.fill(dp[i], -1);

        return dfs(0, 0, stones, sum, target);
    }

    private int dfs(int i, int total, int[] stones, int sum, int target) {
        if(total >= target || i == stones.length) {
            return Math.abs(total - (sum - total));
        }

        if(dp[i][total] != -1)
            return dp[i][total];

        int take = dfs(i + 1, total + stones[i], stones, sum, target);
        int not_take = dfs(i + 1, total, stones, sum, target);

        return dp[i][total] = Math.min(take, not_take);
    }
}