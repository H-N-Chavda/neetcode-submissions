class Solution {
    public int[] findOrder(int n, int[][] preq) {
        int[] degree = new int[n];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n ; i++) 
            adj.add(new ArrayList<>());
        for(int[] pre : preq) {
            degree[pre[0]]++;
            adj.get(pre[1]).add(pre[0]);
        }
        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < n; i++)
            if(degree[i] == 0)
                q.offer(i);
                
        int idx = 0;
        int[] res = new int[n];

        while(!q.isEmpty()) {
            int curr = q.poll();
            res[idx++] = curr;

            for(int next : adj.get(curr)) {
                degree[next]--;
                if(degree[next] == 0)
                    q.offer(next);
            }
        }

        return idx == n ? res : new int[0];
    }
}
