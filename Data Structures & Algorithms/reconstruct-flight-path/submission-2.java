class Solution {
    private Map<String, PriorityQueue<String>> adj;
    private List<String> res;

    public List<String> findItinerary(List<List<String>> tickets) {
        this.res = new ArrayList<>();
        this.adj = new HashMap<>();

        for(List<String> edge : tickets) {
            String u = edge.get(0);
            String v = edge.get(1);
            adj.computeIfAbsent(u, k -> new PriorityQueue<>()).add(v);
        }

        dfs("JFK");
        Collections.reverse(res);
        return res;
    }

    private void dfs(String node) {
        PriorityQueue<String> temp = adj.get(node);
        while(temp != null && !temp.isEmpty()) {
            String next = temp.poll();
            dfs(next);
        }
        res.add(node);
    }
}
