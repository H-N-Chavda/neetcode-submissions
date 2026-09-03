class Solution {
    Stack<Integer> st = new Stack<>();
    List<List<Integer>> adj;
    int[] vis;

    public int[] findOrder(int n, int[][] preq) {
        adj = new ArrayList<>();    
        for(int i = 0; i < n; i++)  
            adj.add(new ArrayList<>());
        for(int[] pre : preq) {
            adj.get(pre[1]).add(pre[0]);
        }
        vis = new int[n];
        int[] res = new int[n];

        for(int i = 0; i < n; i++) {
            if(vis[i] != 2) {
                boolean pos = dfs(i);
                if(!pos)
                    return new int[0];
            }
        }

        for(int i = 0; i < n; i++) {
            res[i] = st.pop();
        }

        return res;
    }

    private boolean dfs(int idx) {
        vis[idx] = 1;
        for(int pre : adj.get(idx)) {
            if(vis[pre] == 2)
                continue;
            if(vis[pre] == 1)
                return false;
            boolean pos = dfs(pre);
            if(!pos)
                return false;
        }
        vis[idx] = 2;
        st.push(idx);
        return true;
    }
}
