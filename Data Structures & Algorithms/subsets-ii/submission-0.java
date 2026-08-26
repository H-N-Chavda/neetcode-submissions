class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        dfs(0, new ArrayList<>(), nums);
        return res;    
    }

    private void dfs(int idx, List<Integer> sub, int[] nums) {
        res.add(new ArrayList<>(sub));
        for(int j = idx; j < nums.length; j++) {
            if(j > idx && nums[j] == nums[j-1]) {
                continue;
            }
            sub.add(nums[j]);
            dfs(j + 1, sub, nums);
            sub.remove(sub.size() - 1);
        }
    }
}
