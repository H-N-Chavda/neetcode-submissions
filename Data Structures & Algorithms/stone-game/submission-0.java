class Solution {
    public boolean stoneGame(int[] piles) {
        return dfs(piles, 0, piles.length - 1, 0, 0, true);
    }

    private boolean dfs(int[] piles, int l, int r, int alice, int bob, boolean al_turn) {
        if(l == r)
            return alice > bob;

        if(al_turn) {
            return dfs(piles, l+1, r, alice+piles[l], bob, false) || dfs(piles, l, r-1, alice+piles[r], bob, false);
        } else {
            return dfs(piles, l+1, r, alice, bob+piles[l], true) || dfs(piles, l, r-1, alice, bob+piles[r], true);
        }
    }
}