class Solution {
    public int reverse(int x) {
        int maxi = Integer.MAX_VALUE;
        int mini = Integer.MIN_VALUE;
        int res = 0;
        while(Math.abs(x) > 0) {
            if(res > maxi/10 || res < mini/10)
                return 0;
            if(res == maxi/10 && Math.abs(x%10) > maxi%10)
                return 0;
            if(res == mini/10 && Math.abs(x%10) < mini%10)
                return 0;
            res*=10;
            res += (x%10);
            x /= 10;
        }
        return res;
    }
}
