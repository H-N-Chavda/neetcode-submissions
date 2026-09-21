class Solution {
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for(int stone : stones) 
            sum += stone;

        int target = (sum)/2;
        int[] dp = new int[target + 1];

        for(int stone : stones) {
            for(int t = target; t >= stone; t--) {
                dp[t] = Math.max(dp[t], dp[t-stone] + stone);
            }
        }

        return sum - 2*dp[target];
    }
}