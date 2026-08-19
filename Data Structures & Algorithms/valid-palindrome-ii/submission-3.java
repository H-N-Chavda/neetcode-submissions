class Solution {
    public boolean validPalindrome(String s) {
        return dfs(s, 0, s.length()-1, false);
    }

    private boolean dfs(String s, int l, int r, boolean violated) {
        if(l >= r)
            return true;

        if(s.charAt(l) == s.charAt(r))
            return dfs(s, l+1, r-1, violated);

        if(violated)
            return false;
        
        return dfs(s, l+1, r, true) || dfs(s, l, r-1, true);
    }
}