class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> set = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if(set.containsKey(target - num)) {
                int[] ans = new int[2];
                ans[0] = set.get(target-num);
                ans[1] = i;
                return ans;
            } else {
                set.put(num, i);
            }
        }

        return new int[]{0,0};
    }
}
