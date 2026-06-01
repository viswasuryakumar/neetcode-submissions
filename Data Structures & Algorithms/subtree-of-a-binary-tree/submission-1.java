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
    void preOrder(TreeNode x, StringBuilder sb){
        if(x==null){
            sb.append("null,");
            return;
        }
        sb.append("^").append(x.val).append(",");
        preOrder(x.left,sb);
        preOrder(x.right,sb);
    }

    String preOrder(TreeNode x){
        StringBuilder sb = new StringBuilder();
        preOrder(x,sb);
        return sb.toString();
    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
       String rot = preOrder(root);
       String sub = preOrder(subRoot);
       return rot.contains(sub);
    }
}
