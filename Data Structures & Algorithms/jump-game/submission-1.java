class Solution {
    public boolean canJump(int[] nums) {
        if(nums[0] == 0)
            return nums.length == 1;

        int curr = nums[0] - 1;
        for(int i = 0; i < nums.length - 1; i++) {
            curr = Math.max(curr, nums[i]);
            if(curr == 0)
                return false;
            curr--;
        }
        return true;
    }
}
