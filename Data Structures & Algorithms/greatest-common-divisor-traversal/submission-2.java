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
    public boolean canTraverseAllPairs(int[] nums) {
        int n = nums.length;
        if(n == 1)
            return true;

        int maxi = 0;
        for(int num : nums)
            maxi = Math.max(maxi, num);

        DSU dsu = new DSU(n + maxi + 1);

        for(int i = 0; i < n; i++) {
            int val = nums[i];

            if(val == 1)
                continue;

            for(int p = 2; (long)p * p <= val; p++) {
                if(val % p == 0) {
                    dsu.join(i, n + p);
                    while(val % p == 0)
                        val /= p;
                }
            }

            if(val > 1)
                dsu.join(i, n + val);
        }

        int root = dsu.find(0);
        for(int i = 1; i < n; i++) {
            if(dsu.find(i) != root)
                return false;
        }

        return true;
    }
}