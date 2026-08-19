class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int l = 0;
        int curr = 0;
        int mini = Integer.MAX_VALUE;

        for(int r = 0; r < nums.length; r++) {
            curr += nums[r];
            while(l <= r && curr >= target) {
                curr -= nums[l];
                mini = Math.min(mini, r-l+1);
                l++;
            }
        }

        return mini > nums.length ? 0 : mini;
    }
}