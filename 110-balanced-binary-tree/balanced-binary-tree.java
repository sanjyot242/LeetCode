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
    // public boolean isBalanced(TreeNode root) {
    //     if (root ==null) return true;

    //     int lh = findHeight(root.left);
    //     int rh = findHeight(root.right);
    //     if(Math.abs(rh-lh)>1) return false ;

    //     Boolean left = isBalanced(root.left);
    //     Boolean right = isBalanced(root.right);

    //     if(!left || !right) return false;

    //     return true;
    // }

    // public int findHeight(TreeNode root){
    //     if (root ==null) return 0;
    //     int lh = findHeight(root.left);
    //     int rh = findHeight(root.right);

    //     return 1+ Math.max(lh,rh);
    // }

    public boolean isBalanced(TreeNode root) {
        return dfsheight(root) != -1;
    }

    public int dfsheight(TreeNode root){
        if(root == null) return 0;
       
        int lh = dfsheight(root.left);
        int rh = dfsheight(root.right);

        if(lh == -1 || rh==-1) return -1;
        if(Math.abs(rh-lh)>1) return -1;

        return Math.max(lh,rh)+1;
    }

}