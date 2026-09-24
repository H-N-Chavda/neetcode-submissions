class Solution {
    private int M;
    private int N;
    private Boolean[][] memo;

    public boolean isMatch(String s, String p) {
        this.M = s.length();
        this.N = p.length();
        memo = new Boolean[M+1][N+1];
        return dfs(0, 0, s, p);
    }

    private boolean dfs(int i, int j, String s, String p) {
        if(j == N)
            return i == M;

        if(memo[i][j] != null)
            return memo[i][j];

        boolean match = i < M && 
        (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');

        if(j + 1 < N && p.charAt(j+1) == '*') {
            return memo[i][j] = dfs(i, j+2, s, p) || (match && dfs(i+1, j, s, p));
        }

        if(match)
            return memo[i][j] = dfs(i+1, j+1, s, p);

        return memo[i][j] = false;
    }
}
