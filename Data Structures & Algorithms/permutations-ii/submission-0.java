class Solution {
    List<List<Integer>> res = new ArrayList<>();
    boolean[] vis;

    public List<List<Integer>> permuteUnique(int[] nums) {
        vis = new boolean[nums.length];
        List<Integer> perm = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, perm);
        return res;
    }

    private void dfs(int[] nums, List<Integer> perm) {
        if(perm.size() == nums.length) {
            res.add(new ArrayList<>(perm));
            return ;
        }

        for(int i = 0; i < nums.length; i++) {
            if(vis[i] || (i > 0 && nums[i] == nums[i-1] && !vis[i-1]))
                continue;

            vis[i] = true;
            perm.add(nums[i]);
            dfs(nums, perm);
            vis[i] = false;
            perm.remove(perm.size() - 1);
        }
    }
}