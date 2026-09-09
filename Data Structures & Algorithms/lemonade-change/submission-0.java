class Solution {
    public boolean lemonadeChange(int[] bills) {
        int fiv = 0, ten = 0, twe = 0;
        for(int b : bills) {
            if(b == 5)
                fiv++;
            else if(b == 10) {
                ten++;
                fiv--;
            } else if(ten > 0) {
                fiv--;
                ten--;
            } else {
                fiv -= 3;
            }
            if(fiv < 0)
                return false;
        }
        return true;
    }
}