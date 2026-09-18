class DSU {
    private int[] parent;
    private int[] rank;

    DSU(int n) {
        this.parent = new int[n];
        for(int i = 0; i < n; i++)
            parent[i] = i;
        this.rank = new int[n];
        Arrays.fill(rank, 1);
    }

    private int find(int u) {
        if(parent[u] != u)
            parent[u] = find(parent[u]);
        return parent[u];
    }

    public boolean join(int u, int v) {
        int pu = find(u), pv = find(v);

        if(pu == pv)
            return false;
        
        if(rank[pv] > rank[pu]) {
            int temp = pu;
            pu = pv;
            pv = temp;
        }

        parent[pv] = pu;
        rank[pu] += rank[pv];
        return true;
    }
}

class Solution {
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        int m = edges.length;
        Integer[] idx = new Integer[m];
        for(int i = 0; i < m; i++)  idx[i] = i;
        Arrays.sort(idx, (a,b)->edges[a][2]-edges[b][2]);

        int baseline = kruskal(n, edges, idx, -1, -1);

        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        res.add(new ArrayList<>());

        for(int i = 0; i < m; i++) {
            int exclude = kruskal(n, edges, idx, i, -1);
            if(exclude > baseline) {
                res.get(0).add(i);
                continue;
            }
            
            int include = kruskal(n, edges, idx, -1, i);
            if(include == baseline) {
                res.get(1).add(i);
            }
        }

        return res;
    }

    private int kruskal(int n, int[][] edges, Integer[] idx, int skip, int forced) {
        DSU dsu = new DSU(n);
        int wt = 0, count = 0;
        
        if(forced != -1) {
            dsu.join(edges[forced][0], edges[forced][1]);
            wt += edges[forced][2];
            count++;
        }

        for(int i : idx) {
            if(i == skip || i == forced)
                continue;

            if(dsu.join(edges[i][0], edges[i][1])) {
                wt += edges[i][2];
                count++;
            }
        }

        return count == n - 1 ? wt : Integer.MAX_VALUE;
    }
}