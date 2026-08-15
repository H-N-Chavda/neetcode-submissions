class MinStack {
    private class pair {
        int num; 
        int min;
        pair(int num, int min) {
            this.num = num;
            this.min = min;
        }
    }
    
    Stack<pair> st;
    public MinStack() {
        st = new Stack<>();
    }
    
    public void push(int val) {
        int min_so_far = Integer.MAX_VALUE;
        if(!st.isEmpty()) {
            min_so_far = st.peek().min;
        }
        st.push(new pair(val, Math.min(val, min_so_far)));
        return ;
    }
    
    public void pop() {
        st.pop();
    }
    
    public int top() {
        return st.peek().num;
    }
    
    public int getMin() {
        return st.peek().min;
    }
}
