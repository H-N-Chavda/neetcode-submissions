class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num : nums)
            sum += num;

        if(sum % 2 != 0)    return false;
        int target = sum / 2;

        return dfs(nums, 0, target, 0);
    }

    private boolean dfs(int[] nums, int idx, int target, int curr) {
        if(idx == nums.length)
            return curr == target;
        if(curr == target)
            return true;
        if(curr > target)  
            return false;

        return dfs(nums, idx + 1, target, curr + nums[idx]) ||
            dfs(nums, idx + 1, target, curr);
    }
}
