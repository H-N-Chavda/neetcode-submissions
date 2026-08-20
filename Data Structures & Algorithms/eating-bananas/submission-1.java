class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = Integer.MIN_VALUE;
        for(int pile : piles) {
            r = Math.max(r, pile);
        }
        while(l <= r) {
            int mid = l + (r-l)/2;
            int time = time(piles, mid);
            System.out.println(l + " " + r);
            if(time > h)
                l = mid + 1;
            else 
                r = mid - 1;
        }
        return l;
    }

    private int time(int[] piles, int mid) {
        int res = 0;
        for(int pile : piles) {
            res += (pile + mid -1)/mid;
        }
        return res;
    }
}
