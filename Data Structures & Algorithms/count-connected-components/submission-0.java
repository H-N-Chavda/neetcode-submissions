class Solution {
    List<List<Integer>> adj = new ArrayList<>();
    boolean[] vis;

    public int countComponents(int n, int[][] edges) {
        for(int i = 0; i < n; i++)
            adj.add(new ArrayList<>());
        for(int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        vis = new boolean[n];

        int counter = 0;
        for(int i = 0; i < n; i++) {
            if(!vis[i]) {
                counter++;
                dfs(i);
            }
        }

        return counter;
    }

    private void dfs(int idx) {
        vis[idx] = true;
        for(int nei : adj.get(idx)) {
            if(!vis[nei])
                dfs(nei);
        }
        return;
    }
}
