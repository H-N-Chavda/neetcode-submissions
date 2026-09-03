class Solution {
    public List<Boolean> checkIfPrerequisite(int n, int[][] preq, int[][] queries) {
        List<List<Integer>> adj = new ArrayList<>();
        int[] inDegree = new int[n];
        boolean[][] isPre = new boolean[n][n];
        
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        
        for (int[] p : preq) {
            adj.get(p[0]).add(p[1]);
            inDegree[p[1]]++;
            isPre[p[0]][p[1]] = true;
        }
        
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) q.offer(i);
        }
        
        while (!q.isEmpty()) {
            int curr = q.poll();
            for (int nei : adj.get(curr)) {
                // Pass all prerequisites of curr to nei
                for (int i = 0; i < n; i++) {
                    if (isPre[i][curr]) {
                        isPre[i][nei] = true;
                    }
                }
                
                if (--inDegree[nei] == 0) {
                    q.offer(nei);
                }
            }
        }
        
        List<Boolean> ans = new ArrayList<>();
        for (int[] qry : queries) {
            ans.add(isPre[qry[0]][qry[1]]);
        }
        return ans;
    }
}