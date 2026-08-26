class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for(int num : nums)
            sum += num;
        if(sum % k != 0)    return false;
        int target = sum / k;
        int sums[] = new int[k];
        Arrays.sort(nums);
        
        return dfs(nums, nums.length - 1, sums, target);
    }

    private boolean dfs(int[] nums, int idx, int[] sums, int target) {
        if(idx < 0) {
            int val = sums[0];
            for(int sum : sums)
                if(sum != val)
                    return false;

            return true;
        }

        for(int i = 0; i < sums.length; i++) {
            if(sums[i] + nums[idx] > target)
                continue;
            
            sums[i] += nums[idx];
            boolean out = dfs(nums, idx - 1, sums, target);
            if(out) return true;
            sums[i] -= nums[idx];
        }

        return false;
    }
}