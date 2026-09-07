class Solution {
    public long minEnd(int n, int x) {
        long res = x;
        long val = n-1;

        long i = 1;
        long j = 1;

        while(j <= val) {
            if((x&i) == 0) {
                if((val&j) != 0)
                    res |= i;
                j *= 2;
            }
            i *= 2;
        }

        return res;
    }
}