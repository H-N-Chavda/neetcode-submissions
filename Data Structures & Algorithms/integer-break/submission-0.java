class Solution {
    public int integerBreak(int n) {
        if (n == 2) return 1;
        if (n == 3) return 2;
        
        int countOfThrees = n / 3;
        int remainder = n % 3;
        
        if (remainder == 0) {
            return (int) Math.pow(3, countOfThrees);
        } else if (remainder == 1) {
            return (int) Math.pow(3, countOfThrees - 1) * 4;
        } else {
            return (int) Math.pow(3, countOfThrees) * 2;
        }
    }
}