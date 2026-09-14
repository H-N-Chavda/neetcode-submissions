class Solution {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        dp[nums.length - 1] = 0;
        return dfs(nums, dp, 0);
    }

    private int dfs(int[] nums, int[] dp, int idx) {
        if(idx >= nums.length - 1)
            return 0;
        
        if(dp[idx] != -1)
            return dp[idx];

        int res = Integer.MAX_VALUE;
        for(int i = 1; i <= nums[idx]; i++) {
            if(i + idx < nums.length) {
                int jumps = dfs(nums, dp, i + idx);
                if(jumps != Integer.MAX_VALUE)
                    res = Math.min(res, 1 + jumps);
            }
        }
        return dp[idx] = res;
    }
}
