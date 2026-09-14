class Solution {
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0"))
            return "0";

        StringBuilder res = new StringBuilder();
        for(int i = num2.length() - 1; i >= 0; i--) {
            StringBuilder curr = onedigit(num1, num2.charAt(i) - '0');
            curr.repeat('0', num2.length() - 1 - i);
            res = add(res, curr);
        }
        return res.toString();
    }

    private StringBuilder onedigit(String num1, int num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for(int i = num1.length() - 1; i >= 0; i--) {
            int ch = num1.charAt(i) - '0';
            int ans = (num2 * ch) + carry;
            carry = ans / 10;
            ans %= 10;
            sb.insert(0, ans);
        }

        if(carry != 0)
            sb.insert(0, carry);

        return sb;
    }

    private StringBuilder add(StringBuilder num1, StringBuilder num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        for(; i >= 0 || j >= 0; i--, j--) {
            int ans = carry;
            if(i >= 0)
                ans += num1.charAt(i)-'0';
            if(j >= 0)
                ans += num2.charAt(j)-'0';
            carry = ans/10;
            ans %= 10;
            sb.insert(0, ans);
        }
        if(carry != 0)
            sb.insert(0, carry);

        return sb;
    }
}
