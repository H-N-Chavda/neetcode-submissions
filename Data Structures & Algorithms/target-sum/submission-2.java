class Solution {
    Integer[][] memo;
    int offset;

    public int findTargetSumWays(int[] nums, int target) {
        int total = Arrays.stream(nums).sum();
        offset = total;
        memo = new Integer[nums.length][2 * total + 1];    
        return dfs(nums, 0, 0, target);
    }

    private int dfs(int[] nums, int idx, int curr, int target) {
        if(idx == nums.length)
            return target == curr ? 1 : 0;

        if(memo[idx][curr + offset] != null)
            return memo[idx][curr + offset];

        int add = dfs(nums, idx + 1, curr + nums[idx], target);
        int sub = dfs(nums, idx + 1, curr - nums[idx], target);
        return memo[idx][curr + offset] = add + sub;
    }
}