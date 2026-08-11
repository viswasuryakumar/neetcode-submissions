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
    public boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }

    // returns height in nodes, or -1 if this subtree is already unbalanced
    private int height(TreeNode node) {
        if (node == null) return 0;

        int left = height(node.left);
        if (left == -1) return -1;          // left subtree already failed

        int right = height(node.right);
        if (right == -1) return -1;         // right subtree already failed

        if (Math.abs(left - right) > 1) return -1;   // fails right here

        return 1 + Math.max(left, right);
    }
}
