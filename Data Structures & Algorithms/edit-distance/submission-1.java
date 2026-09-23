class Solution {
    Integer[][] memo;

    public int minDistance(String word1, String word2) {
        memo = new Integer[word1.length()][word2.length()];
        return dfs(word1, word2, 0, 0, word1.length(), word2.length());
    }

    private int dfs(String word1, String word2, int i, int j, int m, int n) {
        if(i == m)
            return n - j;
        if(j == n)
            return m - i;

        if(memo[i][j] != null)
            return memo[i][j];

        if(word1.charAt(i) == word2.charAt(j))
            return dfs(word1, word2, i+1, j+1, m, n);

        int insert = dfs(word1, word2, i, j+1, m, n);
        int delete = dfs(word1, word2, i+1, j+1, m, n);
        int replace = dfs(word1, word2, i+1, j, m, n);

        return memo[i][j] = 1 + Math.min(insert, Math.min(delete, replace));
    }
}
