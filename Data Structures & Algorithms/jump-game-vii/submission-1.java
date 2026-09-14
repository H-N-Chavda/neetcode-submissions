class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();
        if(s.charAt(n-1) != '0')
            return false;
        int l = 0, r = 0;
        while(l <= r) {
            int next = r;
            for(int i = l; i <= r; i++) {
                if(s.charAt(i) == '0') {
                    if(i + maxJump >= n - 1 && i + minJump <= n - 1)
                        return true;
                    next = Math.max(next, i + maxJump);
                }
            }
            l = Math.max(r + 1, l + minJump);
            r = Math.min(next, n - 1);
        }

        return false;
    }
}