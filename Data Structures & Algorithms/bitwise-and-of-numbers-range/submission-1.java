class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        int res = 0;
        for(int i = 0; i < 32; i++) {
            int bit = (left >> i) & 1;
            if(bit == 0)
                continue;
            int remain = left % (1 << (i+1));
            int diff = (1 << (i+1)) - remain;
            if(right - left < diff)
                res |= (1 << i);
        }
        return res;
    }
}