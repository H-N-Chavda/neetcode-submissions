class Solution {
    public int[] plusOne(int[] digits) {
        List<Integer> res = new ArrayList<>();
        int carry = 0;
        digits[digits.length - 1] += 1;
        for(int i = digits.length - 1; i >= 0; i--) {
            int num = digits[i] + carry;
            carry = num / 10;
            num = num % 10;
            res.add(num);
        }
        if(carry != 0) {
            res.add(carry);
        }
        Collections.reverse(res);
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
