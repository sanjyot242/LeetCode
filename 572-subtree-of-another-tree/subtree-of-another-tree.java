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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
         
        // If the main tree is null, subRoot cannot be a subtree
        if (root == null) {
            return false;
        }

        // Check if the current subtree matches subRoot
        if (isSameTree(root, subRoot)) {
            return true;
        }

        // Recursively check the left and right subtrees
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean isSameTree(TreeNode tree1, TreeNode tree2) {
        // If both trees are null, they are identical
        if (tree1 == null && tree2 == null) {
            return true;
        }

        // If one of the trees is null, they are not identical
        if (tree1 == null || tree2 == null) {
            return false;
        }

        // Check if the current nodes match and recurse for left and right children
        return (tree1.val == tree2.val &&
                isSameTree(tree1.left, tree2.left) &&
                isSameTree(tree1.right, tree2.right));
    }
    
}