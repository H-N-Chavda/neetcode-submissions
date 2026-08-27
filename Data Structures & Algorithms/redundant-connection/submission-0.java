class Solution {
    List<List<Integer>> adj;
    boolean[] seen;

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length; 
        adj = new ArrayList<>();
        for(int i = 0; i < n+1; i++)
            adj.add(new ArrayList<>());
        for(int[] edge : edges) {
            seen = new boolean[n+1];

            if(dfs(edge[0], edge[1], -1))
                return edge;

            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        return null;
    }

    private boolean dfs(int u, int target, int parent) {
        if(u == target)
            return true;

        seen[u] = true;

        for(int v : adj.get(u)) {
            if(v == parent)
                continue;

            if(!seen[v] && dfs(v, target, u))
                return true;
        }

        return false;
    }
}
