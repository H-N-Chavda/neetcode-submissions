class Solution {
    public int maxProfit(int[] prices) {
        int buy = Integer.MAX_VALUE;
        int diff = 0;
        int curr = 0;
        for(int i = 0; i < prices.length; i++) {
            if(prices[i] < buy) {
                buy = prices[i];
            }
            curr = prices[i] - buy;
            diff = Math.max(diff, curr);
        }

        return diff;
    }
}
