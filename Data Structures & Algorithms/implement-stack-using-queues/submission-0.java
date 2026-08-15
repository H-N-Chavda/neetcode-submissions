class MyStack {
    Queue<Integer> q;
    Queue<Integer> temp;

    public MyStack() {
        q = new LinkedList<>();
        temp = new LinkedList<>();    
    }
    
    public void push(int x) {
        q.offer(x);
    }
    
    public int pop() {
        for(int i = 0; i < q.size() - 1; i++)
            q.offer(q.poll());

        return q.poll();
    }
    
    public int top() {
        for(int i = 0; i < q.size() - 1; i++)
            q.offer(q.poll());

        int ans = q.peek();
        q.offer(q.poll());

        return ans;
    }
    
    public boolean empty() {
        return q.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */