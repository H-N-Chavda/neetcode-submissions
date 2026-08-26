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
    int preidx = 0;
    int[] pre;
    HashMap<Integer, Integer> inidx = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.pre = preorder;
        for(int i = 0; i < inorder.length; i++)
            inidx.put(inorder[i], i);

        return dfs(0, inorder.length - 1);
    }

    private TreeNode dfs(int start, int end) {
        if(start > end)
            return null;

        TreeNode curr = new TreeNode(pre[preidx++]);
        int idx = inidx.get(curr.val);
        curr.left = dfs(start, idx - 1);
        curr.right = dfs(idx + 1, end);

        return curr;
    }
}
