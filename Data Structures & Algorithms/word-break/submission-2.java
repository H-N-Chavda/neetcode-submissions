class Solution {
    HashSet<String> set;
    Boolean[] dp;

    public boolean wordBreak(String s, List<String> wordDict) {
        set = new HashSet<>(wordDict);
        dp = new Boolean[s.length() + 1];
        return dfs(s, 0, 0);
    }

    private boolean dfs(String s, int l, int r) {
        if(r == s.length()) {
            if(set.contains(s.substring(l, r)))
                return true;
            return false;
        }
        if(dp[l] != null)
            return dp[l];
        if(set.contains(s.substring(l, r + 1))) {
            return dp[l] = dfs(s, r+1, r+1) || dfs(s, l, r + 1);
        } 
        return dp[l] = dfs(s, l, r + 1);
    }
}