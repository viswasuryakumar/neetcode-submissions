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

class Solution {private int maxsum  = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxsum;
    }
    public int maxGain(TreeNode node){
        if(node==null) return 0;
        int leftgain = Math.max(0,maxGain(node.left));
        int rightgain = Math.max(0,maxGain(node.right));
        int currentmax = node.val+leftgain+rightgain;
        maxsum = Math.max(maxsum,currentmax);
        return node.val+Math.max(leftgain,rightgain);
    }
}
