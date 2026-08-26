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
    public int goodNodes(TreeNode root) {
        return dfs(root, root.val);
    }

    private int dfs(TreeNode root, int maxi) {
        if(root == null)
            return 0;
        
        if(root.val >= maxi)
            return dfs(root.left, root.val) + dfs(root.right, root.val) + 1;

        return dfs(root.left, maxi) + dfs(root.right, maxi);
    }
}
