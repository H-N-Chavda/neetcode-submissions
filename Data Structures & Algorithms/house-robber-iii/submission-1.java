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
    private Map<TreeNode, Integer> memoTaken = new HashMap<>();
    private Map<TreeNode, Integer> memoNotTaken = new HashMap<>();

    public int rob(TreeNode root) {
        return dfs(root, false);
    }

    private int dfs(TreeNode root, boolean taken) {
        if(root == null)
            return 0;

        Map<TreeNode, Integer> memo = taken ? memoTaken : memoNotTaken;
        if(memo.containsKey(root))
            return memo.get(root);
        // not take
        int not_take = dfs(root.left, false) + dfs(root.right, false);
        // take 
        int take = 0;
        if(taken == false)
            take = dfs(root.left, true) + dfs(root.right, true) + root.val; 

        int res = Math.max(take, not_take);
        memo.put(root, res);
        return res;
    }
}