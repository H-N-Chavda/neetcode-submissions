class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] prices = new int[n];
        Arrays.fill(prices, Integer.MAX_VALUE);
        prices[src] = 0;

        for(int i = 0; i <= k; i++) {
            int[] tempP = Arrays.copyOf(prices, n);
            // At each iteration, the operation should have values only of previous data, not concurrent update to the array. 

            for(int[] flight : flights) {
                int s = flight[0], d = flight[1], p = flight[2];

                if(prices[s] == Integer.MAX_VALUE)
                    continue;
                if(prices[s] + p < tempP[d])
                    tempP[d] = prices[s] + p;
            }

            prices = tempP;
        }

        return prices[dst] == Integer.MAX_VALUE ? -1 : prices[dst];
    }
}
