/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    HashMap<Node, Node> set = new HashMap<>();
    public Node cloneGraph(Node node) {
        if (node == null) return null;

        if (set.containsKey(node)) {
            return set.get(node);  
        }

        Node clone = new Node(node.val);
        set.put(node, clone);

        List<Node> neibor = new ArrayList<>();
        for (Node nei : node.neighbors)
            neibor.add(cloneGraph(nei));

        clone.neighbors = neibor;
        return clone;
    }
}