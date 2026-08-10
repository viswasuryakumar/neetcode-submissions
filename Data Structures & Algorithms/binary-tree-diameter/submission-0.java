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
    private int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return diameter;
    }

    // returns height in NODES: null = 0, leaf = 1
    private int height(TreeNode node) {
        if (node == null) return 0;

        int left  = height(node.left);
        int right = height(node.right);

        // path that "peaks" at this node, measured in edges
        diameter = Math.max(diameter, left + right);

        return 1 + Math.max(left, right);
    }
}
