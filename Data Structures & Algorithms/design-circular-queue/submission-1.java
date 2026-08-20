class MyCircularQueue {
    int[] q;
    int left = 0;
    int right = 0;
    int n = 0;

    public MyCircularQueue(int k) {
        q = new int[k];
        this.n = k;
        Arrays.fill(q, -1);
    }
    
    public boolean enQueue(int value) {
        if(q[right%n] < 0) {
            q[right++%n] = value;
            return true;
        }
        return false;
    }
    
    public boolean deQueue() {
        if(q[left%n] < 0)
            return false;

        q[left++%n] = -1;
        return true;
    }
    
    public int Front() {
        return q[left%n];
    }
    
    public int Rear() {
        return q[(right+n-1)%n];        
    }
    
    public boolean isEmpty() {
        if(left == right && q[left%n] == -1)
            return true;
        return false;
    }
    
    public boolean isFull() {
        return (q[right%n] >= 0);
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */