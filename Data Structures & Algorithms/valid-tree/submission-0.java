class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) {
            return false;
        }

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        boolean[] vis = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        
        q.add(0);
        vis[0] = true;
        int visitedCount = 0;

        while (!q.isEmpty()) {
            int curr = q.poll();
            visitedCount++;

            for (int neighbor : adj.get(curr)) {
                if (!vis[neighbor]) {
                    vis[neighbor] = true;
                    q.add(neighbor);
                }
            }
        }

        return visitedCount == n;
    }
}
