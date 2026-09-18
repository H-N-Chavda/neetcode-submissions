class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        HashMap<Integer, Integer> rows = Kahns(k, rowConditions);
        HashMap<Integer, Integer> cols = Kahns(k, colConditions);
        if(rows == null || cols == null)
            return new int[0][];

        int[][] res = new int[k][k];
        for(int i = 1; i <= k; i++) {
            int x = rows.get(i);
            int y = cols.get(i);
            res[x][y] = i;
        }

        return res;
    }

    private HashMap<Integer,Integer> Kahns(int k, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i <= k; i++)  
            adj.add(new ArrayList<>());

        int[] indegree = new int[k+1];
        for(int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            indegree[edge[1]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i <= k; i++)  
            if(indegree[i] == 0)
                queue.offer(i);

        Integer[] vis = new Integer[k+1];
        int idx = 0;

        while(!queue.isEmpty()) {
            int u = queue.poll();
            vis[u] = idx++;
            for(int v : adj.get(u)) {
                if(--indegree[v] == 0)
                    queue.offer(v);
            }
        }

        HashMap<Integer, Integer> res = new HashMap<>();

        for(int i = 1; i <= k; i++) {
            if(vis[i] == null) 
                return null;
            res.put(i, vis[i]);
        }

        return res;
    }
}