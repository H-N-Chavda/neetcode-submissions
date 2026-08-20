class Node {
    int val;
    int key;
    Node next;
    Node prev;
    Node() {}
    Node(int num) {
        this.val = num;
    }
    Node(int num, Node curr, Node prev) {
        this.val = num;
        this.next = curr;
        this.prev = prev;
    }
}

class LRUCache {
    Node start = new Node(0);
    Node end = new Node(0);
    HashMap<Integer, Node> map = new HashMap<>();
    int size;

    public LRUCache(int capacity) {
        this.size = capacity;
        start.next = end;
        end.prev = start;
    }

    public int get(int key) {
        if (!map.containsKey(key))
            return -1;

        Node temp = map.get(key);
        int ans = temp.val;
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;

        temp.next = end;
        temp.prev = end.prev;
        temp.prev.next = temp;
        end.prev = temp;

        return ans;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.get(key).val = value;
            
            Node temp = map.get(key);
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;

            temp.next = end;
            temp.prev = end.prev;
            temp.prev.next = temp;
            end.prev = temp;
            return; 
        }

        if (size == 0 && !map.containsKey(key)) {
            Node temp = start.next;
            start.next = temp.next;
            temp.next.prev = start;
            map.remove(temp.key);
            size++;
        }

        Node curr = new Node(value);
        map.put(key, curr);
        curr.key = key;
        curr.prev = end.prev;
        curr.prev.next = curr;
        curr.next = end;
        end.prev = curr;
        size--;
    }
}
