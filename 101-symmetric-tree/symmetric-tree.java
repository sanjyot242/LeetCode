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
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return isSymmetricUtil(root.left , root.right);
    }

    public boolean isSymmetricUtil(TreeNode left, TreeNode right){
        if(left == null || right == null){
            return(left == right);
        }

        return (left.val == right.val) && isSymmetricUtil(left.left,right.right) && isSymmetricUtil(left.right,right.left) ;
    }
}