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
    int diameter = 0 ;
    public int diameterOfBinaryTree(TreeNode root) {
      getHeight(root);
        return diameter;

    }

    public int getHeight(TreeNode root){
         if(root == null) return 0;
         int lh = getHeight(root.left);
         int rh = getHeight(root.right);

         diameter = Math.max(diameter,lh+rh);

         return 1+Math.max(lh,rh);
    }
}