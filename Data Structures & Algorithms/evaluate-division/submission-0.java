class DSU {
    private Map<String, String> par;
    private Map<String, Double> wei;

    public DSU() {
        par = new HashMap<>();
        wei = new HashMap<>();
    }

    public void add(String x) {
        if(!par.containsKey(x)) {
            par.put(x, x);
            wei.put(x, 1.0);
        }
    }

    public String find(String x) {
        if(!x.equals(par.get(x))) {
            String p_x = par.get(x);
            par.put(x, find(p_x));
            wei.put(x, wei.get(x)*wei.get(p_x));
        }
        return par.get(x);
    }

    public void union(String x, String y, double value) {
        add(x);
        add(y);
        String p_x = find(x);
        String p_y = find(y);

        if(!p_x.equals(p_y)) {
            par.put(p_x, p_y);
            wei.put(p_x, value * wei.get(y) / wei.get(x));
        }
    }

    public double ratio(String x, String y) {
        if(!par.containsKey(x) || !par.containsKey(y) || !find(x).equals(find(y)))
            return -1.0;

        return wei.get(x) / wei.get(y);
    }
}

class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        
        DSU uf = new DSU();

        for(int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            String a = equation.get(0);
            String b = equation.get(1);
            uf.union(a, b, values[i]);
        }

        double[] res = new double[queries.size()];

        for(int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            String a = query.get(0);
            String b = query.get(1);
            res[i] = uf.ratio(a, b);
        }

        return res;
    }
}