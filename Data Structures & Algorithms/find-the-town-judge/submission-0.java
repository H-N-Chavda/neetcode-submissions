class Solution {
    public int findJudge(int n, int[][] trust) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for(int[] edge : trust) {
            adj.get(edge[0]).add(edge[1]);
        }

        int judge = 0;
        for(int i = 1; i <= n; i++) {
            if(adj.get(i).size() == 0) {
                judge = i;
                break;
            }
        }

        if(judge == 0)  return -1;

        for(int i = 1; i <= n; i++) {
            if(i != judge && !adj.get(i).contains(judge))
                return -1;
        }

        return judge;
    }
}