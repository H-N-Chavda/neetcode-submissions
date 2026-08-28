class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n];
        if(s.charAt(0) != '0')  dp[0] = 1;
        else return 0;

        for(int i = 1; i < n; i++) {
            char cur = s.charAt(i);
            char pre = s.charAt(i-1);

            int oneD = (cur != '0') ? dp[i-1] : 0;
            int twoD = 0;
            if(pre == '1' || (pre == '2' && cur <= '6'))
                twoD = (i >= 2) ? dp[i-2] : 1;

            dp[i] = oneD + twoD;
        }

        return dp[n-1];
    }
}
