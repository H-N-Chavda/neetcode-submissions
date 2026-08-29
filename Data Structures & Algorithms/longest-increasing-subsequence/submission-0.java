class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        dp[nums.length - 1] = 1;
        for(int i = nums.length - 2; i >= 0; i--) {
            int maxi = 1;
            for(int j = i + 1; j < nums.length; j++) {
                if(nums[j] > nums[i]) {
                    maxi = Math.max(maxi, dp[j] + 1);
                }
            }

            dp[i] = maxi;
        }
        int res = 0;
        for(int num : dp)
            res = Math.max(res, num);

        return res;
    }
}
