class Solution {
    public int change(int amount, int[] coins) {
        Integer[][] memo = new Integer[amount + 1][coins.length];
        return dfs(coins, amount, 0, memo);
    }

    private int dfs(int[] coins, int amount, int idx, Integer[][] memo) {
        if(amount == 0)
            return 1;
        if(amount < 0 || idx == coins.length)
            return 0;

        if(memo[amount][idx] != null)
            return memo[amount][idx];

        int use = dfs(coins, amount - coins[idx], idx, memo);
        int skip = dfs(coins, amount, idx + 1, memo);
        return memo[amount][idx] = use + skip;
    }
}
