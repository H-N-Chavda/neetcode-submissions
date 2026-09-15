class Solution {
    public boolean checkValidString(String s) {
        int free = 0, open = 0;
        for(char ch : s.toCharArray()) {
            if(ch == '*')
                free++;
            else if(ch == '(') {
                open++;
            } else if(ch == ')') {
                if(open > 0)
                    open--;
                else if(free > 0)
                    free--;
                else 
                    return false;
            }
        }

        free = 0;
        int close = 0;
        for(char ch : new StringBuilder(s).reverse().toString().toCharArray()) {
            if(ch == '*')
                free++;
            else if(ch == ')') {
                close++;
            } else if(ch == '(') {
                if(close > 0)
                    close--;
                else if(free > 0)
                    free--;
                else 
                    return false;
            }
        }

        return true;
    }
}
