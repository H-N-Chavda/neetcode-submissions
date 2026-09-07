class Solution {
    public String addBinary(String a, String b) {
        int l = a.length() - 1;
        int r = b.length() - 1;
        int carry = 0;
        StringBuilder res = new StringBuilder();

        while (l >= 0 || r >= 0 || carry > 0) {
            int bit_l = (l >= 0) ? a.charAt(l) - '0' : 0;
            int bit_r = (r >= 0) ? b.charAt(r) - '0' : 0;
            
            int sum = bit_l + bit_r + carry;
            carry = sum / 2;
            res.append(sum % 2);

            l--;
            r--;
        }

        return res.reverse().toString();
    }
}