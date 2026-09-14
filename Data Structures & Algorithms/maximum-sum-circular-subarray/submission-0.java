class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int maxi = Integer.MIN_VALUE;
        int currmax = 0;
        int mini = Integer.MAX_VALUE;
        int currmin = 0;
        int total = 0;

        for(int i = 0; i < nums.length; i++) {
            total += nums[i];

            currmax += nums[i];
            currmin += nums[i];
            maxi = Math.max(maxi, currmax);
            mini = Math.min(mini, currmin);
            if(currmax < 0)
                currmax = 0;
            if(currmin > 0)
                currmin = 0;
        }

        if(maxi < 0)
            return maxi;

        return Math.max(maxi, total - mini);
    }
}