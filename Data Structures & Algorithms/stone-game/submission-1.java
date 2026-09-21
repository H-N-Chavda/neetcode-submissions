class Solution {
    Integer[][] memo;

    public boolean stoneGame(int[] piles) {
        int total = 0;
        for (int pile : piles) {
            total += pile;
        }

        memo = new Integer[piles.length + 1][piles.length + 1];

        int aliceScore = dfs(0, piles.length - 1, piles);
        return aliceScore > total - aliceScore;
    }

    private int dfs(int l, int r, int[] piles) {
        if (l > r) {
            return 0;
        }
        if(memo[l][r] != null)
            return memo[l][r];

        boolean even = (r - l) % 2 == 0;
        int left = even ? piles[l] : 0;
        int right = even ? piles[r] : 0;
        return memo[l][r] = Math.max(dfs(l + 1, r, piles) + left, dfs(l, r - 1, piles) + right);
    }
}