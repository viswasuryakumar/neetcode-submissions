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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
         if (root == null) return null;
        
        // Compare by value, not reference
        if (root.val == p.val || root.val == q.val) {
            return root;
        }
        
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        //p and q are found in different subtrees
        if(left!=null && right!=null){
            return root;

        }
        if(left!=null){
            return left;
        }
        return right;
    }


    /* // CASE 1: I myself am p or q
if (root.val == p.val || root.val == q.val) {
    return root;
}

// Search both sides
TreeNode left = lowestCommonAncestor(root.left, p, q);
TreeNode right = lowestCommonAncestor(root.right, p, q);

// CASE 2: Got something from BOTH sides
// → p and q split across the two sides
if (left != null && right != null) {
    return root;
}

// CASE 3: Only left gave us something
// → pass that result upward
if (left != null) {
    return left;
}

// CASE 4: Only right gave us something OR neither side found anything
return right;*/
}
