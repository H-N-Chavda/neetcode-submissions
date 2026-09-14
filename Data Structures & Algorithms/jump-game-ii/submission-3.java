class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        if(n == 1)
            return 0;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        dp[n - 1] = 0;

        for(int i = n - 1; i >= 0; i--) {
            if(nums[i] == 0)
                continue;
            int res = Integer.MAX_VALUE;
            for(int j = 1; j <= nums[i]; j++) {
                if(i + j >= n - 1) {
                    res = 1;
                    break;
                }
                if(dp[i+j] != -1)
                    res = Math.min(res, 1 + dp[i+j]);
            }
            if(res != Integer.MAX_VALUE)
                dp[i] = res;
        }

        return dp[0];
    }
}
