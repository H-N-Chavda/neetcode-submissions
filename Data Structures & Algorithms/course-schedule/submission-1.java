class Solution {
    int[] vis;
    public boolean canFinish(int n, int[][] preq) {
        vis = new int[n];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) 
            adj.add(new ArrayList<>());

        for(int[] pre : preq) {
            adj.get(pre[0]).add(pre[1]);
        }

        for(int i = 0; i < n; i++) {
            if(vis[i] != 2) {
                if(!dfs(adj, i))
                    return false;
            }
        }
        return true;
    }

    private boolean dfs(List<List<Integer>> adj, int idx) {
        vis[idx] = 1;
        for(int pre : adj.get(idx)) {
            if(vis[pre] == 1)   return false;
            if(vis[pre] == 0 && !dfs(adj,pre))  return false;
        }
        vis[idx] = 2;
        return true;
    }
}
