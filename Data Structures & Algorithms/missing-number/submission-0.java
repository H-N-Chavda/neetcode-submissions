class Solution {
    public int missingNumber(int[] nums) {
        int res = 0;
        int n = nums.length;
        for(int i = 1; i <= n; i++) {
            res ^= i;
            res ^= nums[i-1];
        }
        return res;
    }
}
