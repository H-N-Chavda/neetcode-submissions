class LFUCache {
    private class Node {
        int val;
        int key;
        int count = 0;
        Node next;
        Node prev;
        Node() {}
        Node(int key, int num) {
            this.val = num;
            this.key = key;
        }
    }

    List<Node> nodes;
    HashMap<Integer, Node> map;
    int size;

    public LFUCache(int capacity) {
        nodes = new ArrayList<>();
        map = new HashMap<>();
        size = capacity;
    }
    
    private void remove(Node curr) {
        curr.prev.next = curr.next;
        curr.next.prev = curr.prev;
    }

    private void add(int fre, Node curr) {
        if(fre == nodes.size()) {
            Node temp = new Node(-1, -1);
            temp.next = temp;
            temp.prev = temp;
            nodes.add(temp);
        }

        Node first = nodes.get(fre);
        Node last = first.prev;
        first.prev = curr;
        curr.next = first;
        curr.prev = last;
        last.next = curr;
    }

    private void update(Node curr) {
        curr.count = curr.count + 1;
        int fre = curr.count;
        remove(curr);
        add(fre, curr);
        return ;
    }

    public int get(int key) {
        if(!map.containsKey(key))
            return -1;

        Node curr = map.get(key);
        update(curr);
        return curr.val;
    }
    
    public void put(int key, int value) {
        if(size == 0 && nodes.isEmpty())    
            return ;
            
        if(map.containsKey(key)) {
            Node curr = map.get(key);
            curr.val = value;
            update(curr);
            return ;
        }

        size--;
        if(size < 0) {
            int fre = 0;
            while(nodes.get(fre).next.val < 0) 
                fre++;
            Node temp = nodes.get(fre).next;
            remove(temp);
            map.remove(temp.key);
            size++;
        }

        Node curr = new Node(key, value);
        add(0, curr);
        update(curr);
        map.put(key, curr);
        return ;
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */