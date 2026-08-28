class Solution {
    HashMap<Integer, Integer> map = new HashMap<>();
    public int coinChange(int[] coins, int amount) {
        int ans = dfs(coins, amount);
        return ans < 10001 ? ans : -1;
    }

    private int dfs(int[] coins, int amount) {
        if(map.containsKey(amount))
            return map.get(amount);
        if(amount == 0)
            return 0;
        if(amount < 0)
            return 10001;

        int mini = Integer.MAX_VALUE;
        for(int i = 0; i < coins.length; i++) {
            int next = 1 + dfs(coins, amount - coins[i]);
            mini = Math.min(mini, next);
        }
        map.put(amount, mini);
        return mini;
    }
}
