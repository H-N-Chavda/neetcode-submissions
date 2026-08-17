class FreqStack {
    List<Stack<Integer>> d2 = new ArrayList<>();
    Stack<Integer> first = new Stack<>();
    HashMap<Integer, Integer> map = new HashMap<>();

    public FreqStack() {
        d2.add(first);
    }
    
    public void push(int val) {
        if(map.containsKey(val)) {
            int idx = map.get(val);
            map.put(val, map.get(val) + 1);
            if(idx < d2.size()) {
                d2.get(idx).push(val);
            } else {
                Stack<Integer> st = new Stack<>();
                st.push(val);
                d2.add(st);
            }
        } else {
            map.put(val, 1);
            d2.get(0).push(val);
        }
    }
    
    public int pop() {
        int ans = d2.get(d2.size() - 1).pop();
        if(d2.get(d2.size() - 1).size() <= 0 && d2.size() > 1)
            d2.remove(d2.size() - 1);

        map.put(ans, map.get(ans) - 1);
        return ans;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */