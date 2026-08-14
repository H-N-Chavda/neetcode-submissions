class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums)
            set.add(num);

        int maxi = 1;
        for(int num : set) {
            if(!set.contains(num - 1)) {
                int currNum = num;
                int currStreak = 1;
                while(set.contains(currNum + 1)) {
                    currNum += 1;
                    currStreak += 1;
                }
                maxi = Math.max(maxi, currStreak);
            }
        }
        return maxi;
    }
}