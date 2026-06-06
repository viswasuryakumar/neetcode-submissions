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
    public boolean isValidBST(TreeNode root) {
       return checkingbst(root, Long.MIN_VALUE,Long.MAX_VALUE);

    }
    public boolean checkingbst(TreeNode node, long minval, long maxval){
        if(node==null) return true;
        if(node.val >= maxval || node.val <= minval) return false;
        return checkingbst(node.left,minval,node.val) && checkingbst(node.right,node.val,maxval);
    }
}
