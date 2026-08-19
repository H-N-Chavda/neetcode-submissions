class Solution {
    public int removeDuplicates(int[] nums) {
        int l = 0;
        int curr = nums[0];
        for(int r = 1; r < nums.length; r++) {
            if(nums[r] != curr) {
                nums[++l] = nums[r];
                curr = nums[r];
            }
        }

        return l+1;
    }
}