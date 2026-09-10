class Solution {
    public double myPow(double x, int n) {
        if(n == 0)  
            return 1.0;
        if(x == 1)
            return 1.0;
        if(x == -1)
            return n%2 == 0 ? 1.0 : -1.0;
        if(n == Integer.MIN_VALUE)
            return 0.0;
        if(n < 0) {
            n = Math.abs(n);
            x = (1/x);
        } else {
            n = n % Integer.MAX_VALUE;
        }

        double ans = x;
        for(int i = 2; i <= n; i++) {
            ans *= x;
            System.out.print(ans + " ");
        }

        return ans;
    }
}
