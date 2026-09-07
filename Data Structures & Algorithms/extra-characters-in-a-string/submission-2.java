class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        int n = s.length();
        int[] dp = new int[n + 1];

        for(int i = n - 1; i >= 0; i--) {
            dp[i] = 1 + dp[i + 1];

            for(String word : dictionary) {
                if(i + word.length() <= n && s.startsWith(word, i))
                    dp[i] = Math.min(dp[i], dp[i + word.length()]);
            }
        }

        return dp[0];
    }
}