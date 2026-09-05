class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        // Make adjacency list and visited array
        List<List<Integer>> adj = new ArrayList<>();
        int[] degree = new int[n];
        for(int i = 0; i < n; i++)
            adj.add(new ArrayList<>());
        for(int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
            degree[edge[0]]++;
            degree[edge[1]]++;
        }
        

        // Make queue and initialise with leaf nodes
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            if(degree[i] <= 1) {
                q.offer(i);
            }
        }

        // Move inwards until only 2 left (given it is a valid tree)
        int remaining = n;
        while(remaining > 2) {
            int size = q.size();
            remaining -= size;
            for(int i = 0; i < size; i++) {
                int curr = q.poll();
                for(int next : adj.get(curr)) {
                    degree[next]--;
                    if(degree[next] == 1)
                        q.offer(next);
                }
            }
        }

        return new ArrayList<>(q);
    }
}