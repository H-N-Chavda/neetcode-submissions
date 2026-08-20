class Solution {
    public int mySqrt(int x) {
        if(x == 1)
            return 1;
        long l = 1;
        long r = x/2;
        while(l <= r) {
            long mid = l + (r-l)/2;
            long sq = mid*mid;
            if(sq > x)
                r = mid - 1;
            else if(sq < x)
                l = mid + 1;
            else 
                return (int)mid;
        }
        return (int)l-1;
    }
}