class Solution {
    public String stoneGameIII(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 3];
        dp[n] = 0; dp[n + 1] = 0; dp[n + 2] = 0;

        boolean alice = true;
        for(int i = n-1; i >= 0; i--) {
            int maxD = Integer.MIN_VALUE;
            int curr = 0;
        
            for(int j = 0; j < 3; j++) {
                if(i + j < n) {
                    curr += nums[i+j];
                    int diff = curr - dp[i+j+1];
                    maxD = Math.max(maxD, diff);
                }
            }
            dp[i] = maxD;
        }

        if(dp[0] > 0)   return "Alice";
        if(dp[0] < 0)   return "Bob";
        return "Tie";
    }
}