class Solution {
    public int subsetXORSum(int[] nums) {
        int or = 0;
        for(int num : nums)
            or |= num;

        return or * (int)Math.pow(2, nums.length - 1);
    }
}