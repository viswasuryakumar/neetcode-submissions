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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
       if(preorder==null||inorder==null||preorder.length!=inorder.length)
          return null;
        HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
        for(int i=0;i<inorder.length;i++){
            hm.put(inorder[i],i);
        } 
        return buildTree(inorder,0,inorder.length-1,preorder,0,preorder.length-1,hm);

    }

    private TreeNode buildTree(int[] inorder,int is,int ie, int[] preorder,int ps,int pe, HashMap<Integer,Integer> hm){
        if(is>ie || ps>pe)
           return null;
        TreeNode root = new TreeNode(preorder[ps]);
        int inRoot =hm.get(preorder[ps]);
        int leftsize = inRoot-is;
        root.left = buildTree(inorder,is,inRoot-1,preorder,ps+1,ps+leftsize,hm);
        root.right = buildTree(inorder,inRoot+1,ie,preorder,ps+leftsize+1,pe,hm);
        return root;
    }
}
