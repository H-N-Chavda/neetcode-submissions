/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}
*/

class Solution {
    public Node construct(int[][] grid) {
        return dfs(grid, 0, grid[0].length - 1, 0, grid.length - 1);
    }

    private Node dfs(int[][] grid, int sta, int end, int top, int bot) {
        if(end == sta) {
            return new Node(grid[top][sta] == 1, true);
        }

        int row = top + (bot - top)/2;
        int col = sta + (end - sta)/2;
       
        Node tl = dfs(grid, sta, col, top, row);
        Node tr = dfs(grid, col+1, end, top, row); 
        Node bl = dfs(grid, sta, col, row+1, bot);
        Node br = dfs(grid, col+1, end, row+1, bot);

        Node curr = new Node();

        if(tl.isLeaf && tr.isLeaf && bl.isLeaf && br.isLeaf 
        && tl.val == tr.val && bl.val == tr.val && br.val == tr.val) {
            curr.isLeaf = true;
            curr.val = tr.val;
        } else {
            curr.val = true;
            curr.isLeaf = false;
            curr.topLeft = tl;
            curr.topRight = tr;
            curr.bottomLeft = bl;
            curr.bottomRight = br;
        }

        return curr;
    }
}