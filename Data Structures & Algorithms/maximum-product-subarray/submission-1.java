class Solution {
    public int maxProduct(int[] nums) {
        int res = nums[0];
        int mini = 1;
        int maxi = 1;
        for(int num : nums) {
            int max = maxi*num;
            int min = mini*num;
            maxi = Math.max(Math.max(min, max), num);
            mini = Math.min(Math.min(min, max), num);
            res = Math.max(res, maxi);
        }

        return res;
    }
}
