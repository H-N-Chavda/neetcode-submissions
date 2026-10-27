class DLL {
    int val = -1;
    int key;
    int count = 1;
    DLL prev, next;

    DLL() {}
    DLL(int val, int key) {
        this.val = val;
        this.key = key;
    }
}

class LFUCache {
    HashMap<Integer, DLL> freq;
    HashMap<Integer, DLL> map;
    int capacity, total;

    public LFUCache(int capacity) {
        this.freq = new HashMap<>();
        this.map = new HashMap<>();
        this.capacity = capacity;
        this.total = 0;
    }
    
    public int get(int key) {
        System.out.print("get\t");
        if(!map.containsKey(key))
            return -1;

        DLL curr = map.get(key);
        remove(curr);
        curr.count = curr.count+1;
        add(curr, curr.count);
        return curr.val;
    }
    
    public void put(int key, int value) {
        System.out.print("put\t");
        if(!map.containsKey(key)) {
            if(total == capacity) {
                DLL head = new DLL();
                for(int fre : freq.keySet()) {
                    head = freq.get(fre);
                    break;
                }
                head = head.next;
                remove(head);
                map.remove(head.key);
                total--;
            }
            total++;
            DLL curr = new DLL(value, key);
            map.put(key, curr);
            add(curr, 1);
            
        } else {
            DLL curr = map.get(key);
            curr.val = value;
            remove(curr);
            curr.count = curr.count + 1;
            add(curr, curr.count);
        }
    }

    private void remove(DLL curr) {
        curr.prev.next = curr.next;
        curr.next.prev = curr.prev;
        int fre = curr.count;
        DLL head = freq.get(fre);
        if(head.next.val < 0)
            freq.remove(fre);
    }

    private void add(DLL curr, int count) {
        if(!freq.containsKey(count)) {
            DLL head = new DLL();
            head.next = head;
            head.prev = head;
            freq.put(count, head);
        }
        DLL head = freq.get(count);
        DLL end = head.prev;
        end.next = curr;
        curr.prev = end;
        curr.next = head;
        head.prev = curr;
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */