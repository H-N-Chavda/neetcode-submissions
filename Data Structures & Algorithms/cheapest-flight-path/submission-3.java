class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] prices = new int[n];
        Arrays.fill(prices, Integer.MAX_VALUE);
        prices[src] = 0;

        List<int[]>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();
        for (var f : flights) adj[f[0]].add(new int[] {f[1], f[2]});

        Queue<int[]> q = new LinkedList<>(); // {node, cost}
        q.offer(new int[] {src, 0});
        int stops = 0;

        while (!q.isEmpty() && stops <= k) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                int node = curr[0], cost = curr[1];

                for (int[] nei : adj[node]) {
                    int next = nei[0], w = nei[1];
                    int nextCost = cost + w;
                    if (nextCost < prices[next]) {
                        prices[next] = nextCost;
                        q.offer(new int[] {next, nextCost});
                    }
                }
            }
            stops++;
        }

        return prices[dst] == Integer.MAX_VALUE ? -1 : prices[dst];
    }
}
