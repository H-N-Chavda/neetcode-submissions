class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        dfs(nums, 0, new ArrayList<>());
        return res;
    }

    private void dfs(int[] nums, int idx, List<Integer> curr) {
        if(idx == nums.length) {
            res.add(new ArrayList<>(curr));
            return ;
        }

        //take 
        curr.add(nums[idx]);
        dfs(nums, idx + 1, curr);
        //not take
        curr.remove(curr.size() - 1);
        dfs(nums, idx + 1, curr);
        return ;
    }
}
