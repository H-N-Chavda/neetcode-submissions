class Solution {
    Integer[] memo;

    public int numSquares(int n) {
        memo = new Integer[n + 1];
        return dfs(n);
    }

    private int dfs(int target) {
        if(target == 0)
            return 0;
        if(memo[target] != null)
            return memo[target];

        int count = Integer.MAX_VALUE;
        for(int i = (int)Math.sqrt(target); i >= 1; i--) {
            count = Math.min(count, 1 + dfs(target - (i*i)));

        }
        return memo[target] = count;
    }
}