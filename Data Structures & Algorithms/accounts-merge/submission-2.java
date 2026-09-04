class Solution {
    List<HashSet<String>> acc = new ArrayList<>();
    HashMap<String, List<Integer>> idc = new HashMap<>();
    int[] par;

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();

        // Setup for DSU algo
        par = new int[n];
        for(int i = 0; i < n; i++) {
            par[i] = i;
        }

        for(int idx = 0; idx < n; idx++) {
            HashSet<String> curr = new HashSet<>();
            for(int i = 1; i < accounts.get(idx).size(); i++) {
                curr.add(accounts.get(idx).get(i));
            }
            acc.add(curr);
        }

        for(int i = 0; i < n; i++) {
            if(idc.containsKey(accounts.get(i).get(0))) {
                List<Integer> temp = idc.get(accounts.get(i).get(0));
                temp.add(i);
                idc.put(accounts.get(i).get(0), temp);
            } else {
                List<Integer> temp = new ArrayList<>();
                temp.add(i);
                idc.put(accounts.get(i).get(0), temp);
            }
        }

        // Starting with actual algo
        for(int i = 1; i < n; i++) {
            for(int x = idc.get(accounts.get(i).get(0)).size() - 1; x >= 0; x--) {
                int ref = idc.get(accounts.get(i).get(0)).get(x);
                if(ref >= i)
                    continue;

                for(String mail : acc.get(i)) {
                    if(acc.get(ref).contains(mail)) {
                        parent(i, ref);
                        break;
                    }
                }
            }
        }

        // Merge accounts
        for(int i = 0; i < n; i++) {
            if(par[i] != i) {
                int ref = find(i);
                System.out.println(ref);
                for(int j = 1; j < accounts.get(i).size(); j++) {
                    String mail = accounts.get(i).get(j);
                    acc.get(ref).add(mail);
                }
            }
        }

        // Output list
        List<List<String>> res = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            if(par[i] == i) {
                List<String> curr = new ArrayList<>();
                curr.add(accounts.get(i).get(0));
                curr.addAll(acc.get(i));
                res.add(curr);
            }
        }

        return res;
    }

    private int find(int idx) {
        if(par[idx] == idx)
            return idx;
        return par[idx] = find(par[idx]);
    }

    private void parent(int i, int ref) {
        int p_i = find(i);
        int p_ref = find(ref);
        if(p_i == p_ref)
            return;
        par[p_i] = p_ref;
    }
}