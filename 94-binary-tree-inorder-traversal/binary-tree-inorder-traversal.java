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
    // public List<Integer> inorderTraversal(TreeNode root) {
    //     List<Integer> ans = new ArrayList<>();
    //     inOrder(root,ans);
    //     return ans;
    // }

    // private void inOrder(TreeNode root,List ans){
    //     if(root == null){
    //         return;
    //     }
        
    //     inOrder(root.left,ans);
    //     ans.add(root.val);
    //     inOrder(root.right,ans);        
    // }

//    
public List<Integer> inorderTraversal(TreeNode root){

    List<Integer> inorder =new ArrayList<>();
    TreeNode curr = root;

    while(curr != null){
        if(curr.left == null){
            inorder.add(curr.val);
            curr = curr.right;
        }
        else{
            TreeNode temp = curr.left;
            while(temp.right!=null  && temp.right != curr){
                temp = temp.right;
            }
                if(temp.right == null){
                    //create thread and move cur
                    temp.right = curr;
                    curr = curr.left;
                }else{
                    //remove the thread andd to inorderr 
                    temp.right = null;
                    inorder.add(curr.val);
                    curr = curr.right;
                }
            }
    }
    return inorder;
}



}