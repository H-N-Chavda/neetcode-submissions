class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> res = new Stack<>();
        for(int ast : asteroids) {
            if(ast > 0)
                res.push(ast);
            else {
                while(!res.isEmpty() && res.peek() > 0 && res.peek() < -ast)
                    res.pop();

                if(res.isEmpty() || res.peek() < 0)
                    res.push(ast);
                else if(res.peek() == -ast)
                    res.pop();
            }
        }
        int size = res.size();
        int[] ans = new int[size];
        for(int i = size - 1; i >= 0; i--)
            ans[i] = res.pop();

        return ans;
    }
}