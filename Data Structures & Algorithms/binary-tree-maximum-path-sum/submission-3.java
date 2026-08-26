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
    public int maxPathSum(TreeNode root) {
        int[] ans = dfs(root);
        return Math.max(ans[0], ans[1]);
    }

    private int[] dfs(TreeNode root) {
        if(root == null) {
            int[] ans = new int[2];
            Arrays.fill(ans, -1001);
            return ans;
        }

        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        int[] res = new int[2];
        res[0] = Math.max(root.val, Math.max(left[0] + root.val, right[0] + root.val));
        res[1] = Math.max(Math.max(left[1], right[1]), 
        root.val + left[0] + right[0]);
        res[1] = Math.max(Math.max(left[0], right[0]), res[1]);
        return res;
    }
}
