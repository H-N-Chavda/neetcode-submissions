class Solution {
    List<String> res;

    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        dfs(n, 0, 0, "");
        return res;
    }

    private void dfs(int n, int open, int total, String s) {
        if(s.length() == n*2) {
            res.add(s);
            return ;
        }

        if(total < n) {
            dfs(n, open + 1, total + 1, s + "(");
        }
        if(open > 0) {
            dfs(n, open - 1, total, s + ")");
        }
        return ;
    }
}
