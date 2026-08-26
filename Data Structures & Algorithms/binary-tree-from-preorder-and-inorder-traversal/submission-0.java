/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public Queue<Integer> pre = new LinkedList<>();
    public Queue<Integer> in = new LinkedList<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int val : preorder) pre.add(val);
        for(int val : inorder)  in.add(val);
        return dfs(pre, in);
    }

    private TreeNode dfs(Queue<Integer> pre, Queue<Integer> in) {
        if(pre.isEmpty())
            return null;

        TreeNode curr = new TreeNode(pre.poll());
        Queue<Integer> temp = new LinkedList<>();
        while(in.peek() != curr.val) {
            temp.add(in.poll());
        }
        in.poll();

        if(!temp.isEmpty()) 
            curr.left = dfs(pre, temp);
        if(!in.isEmpty())
            curr.right = dfs(pre, in);
        return curr;
    }
}
