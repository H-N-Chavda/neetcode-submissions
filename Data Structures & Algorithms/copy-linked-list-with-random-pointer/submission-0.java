/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null)
            return new Node(0).next;

        Node ori = head;
        Node cop = new Node(0);
        Node dummy = cop;

        HashMap<Node, Node> map = new HashMap<>();
        map.put(null, null);

        while(ori != null) {
            cop.next = new Node(ori.val);
            map.put(ori, cop.next);

            ori = ori.next;
            cop = cop.next;
        }

        ori = head;
        cop = dummy.next;

        while(ori != null) {
            cop.random = map.get(ori.random);

            ori = ori.next;
            cop = cop.next;
        }

        return dummy.next;
    }
}
