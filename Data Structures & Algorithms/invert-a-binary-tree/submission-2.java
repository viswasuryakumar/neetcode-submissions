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
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode top_element = q.poll();
            TreeNode temp = top_element.left;
            top_element.left = top_element.right;
            top_element.right = temp;
            if(top_element.left != null) q.add(top_element.left);
            if(top_element.right != null) q.add(top_element.right);

        }
        return root;
    }
}
