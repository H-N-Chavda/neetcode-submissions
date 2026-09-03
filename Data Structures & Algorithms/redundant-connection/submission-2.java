class Solution {
    int[] parent;

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        parent = new int[n + 1];
        for(int i = 1; i <= n; i++)
            parent[i] = i;    

        int[] ans = new int[2];
        ans[0] = -1;

        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            int rootU = find(u);
            int rootV = find(v);

            if(rootU == rootV)
                ans = edge;

            parent[rootU] = rootV;
        }

        return ans[0] == -1 ? new int[0] : ans;
    }

    private int find(int u) {
        if(parent[u] == u)
            return u;
        return parent[u] = find(parent[u]);
    }
}
