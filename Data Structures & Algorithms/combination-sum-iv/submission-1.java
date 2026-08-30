class Solution {
    Integer[] memo;

    public int combinationSum4(int[] nums, int target) {
        memo = new Integer[target + 1];
        return dfs(nums, target);
    }

    private int dfs(int[] nums, int target) {
        if(target == 0) {return 1;}
        if(target < 0) {return 0;}
        if(memo[target] != null)
            return memo[target];

        int count = 0;
        for(int i = 0; i < nums.length; i++) 
            count += dfs(nums, target - nums[i]);
        return memo[target] = count;
    }
}