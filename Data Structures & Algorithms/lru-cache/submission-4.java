class DLL {
    int val;
    int key;
    DLL prev, next;

    DLL() {}
    DLL(int num, int key) {
        this.val = num;
        this.key = key;
    }
}

class LRUCache {
    int capacity, count;
    DLL head;
    HashMap<Integer, DLL> map = new HashMap<>();
    DLL end;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        count = 0;
        head = new DLL();
        end = new DLL();
        head.next = end;
        end.prev = head;
    }
    
    public int get(int key) {
        System.out.print("get\t");
        if(!map.containsKey(key))
            return -1;
        
        DLL curr = map.get(key);
        remove(curr);
        add(curr);
        return curr.val;
    }
    
    public void put(int key, int value) {
        System.out.print("put\t");
        if(!map.containsKey(key)) {
            DLL curr = new DLL(value, key);
            map.put(key, curr);
            add(curr);
            count++;
        } else {
            DLL curr = map.get(key);
            curr.val = value;
            remove(curr);
            add(curr);
        }

        if(count > capacity) {
            DLL rem = head.next;
            map.remove(rem.key);
            remove(rem);
            count--;
        }
    }

    private void remove(DLL curr) {
        curr.prev.next = curr.next;
        curr.next.prev = curr.prev;
    }

    private void add(DLL curr) {
        curr.prev = end.prev;
        curr.next = end;
        end.prev.next = curr;
        end.prev = curr;
    }
}