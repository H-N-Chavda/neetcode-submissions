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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if(root == null)
            return sb.toString();

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            TreeNode curr = q.poll();
            if(curr == null) {
                sb.append('N');
                sb.append('#');
                continue;
            }
            sb.append(curr.val);
            sb.append('#');
            q.add(curr.left);
            q.add(curr.right);
        }

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        StringBuilder sb = new StringBuilder(data);
        if(data.equals(""))
            return null;

        int idx = sb.indexOf("#");
        int val = Integer.parseInt(sb.substring(0, idx));

        TreeNode root = new TreeNode(val);
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()) {
            TreeNode curr = q.poll();

            if(sb.charAt(idx+1) == 'N') {
                curr.left = null;
                idx += 2;
            } else {
                int r = sb.indexOf("#", idx + 1);
                val = Integer.parseInt(sb.substring(idx+1, r));
                curr.left = new TreeNode(val);
                q.add(curr.left);
                idx = r;
            }
        
            if(sb.charAt(idx+1) == 'N') {
                curr.right = null;
                idx += 2;
            } else {
                int r = sb.indexOf("#", idx + 1);
                val = Integer.parseInt(sb.substring(idx+1, r));
                curr.right = new TreeNode(val);
                q.add(curr.right);
                idx = r;
            }
        }

        return root;
    }
}
