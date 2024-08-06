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
    // public List<Integer> postorderTraversal(TreeNode root) {
    //     List<Integer> ans = new ArrayList<>();
    //     postOrder(root,ans);
    //     return ans;
    // }

    // private void postOrder(TreeNode root, List ans){
    //     if(root == null){
    //         return;
    //     }
        
    //     postOrder(root.left,ans);
    //     postOrder(root.right,ans);
    //     ans.add(root.val);
    // }

    //iterative  single stack 
    // public List <Integer> postorderTraversal(TreeNode root) {
    //     List<Integer> ans = new ArrayList<>();
    //     Stack<TreeNode> st = new Stack<>();
    //     TreeNode curr = root;
    //     while(curr != null || !st.isEmpty()){
    //         if(curr != null){
    //             st.push(curr);
    //             curr = curr.left;
    //         }
    //         else{
    //             TreeNode temp = st.peek().right;
    //             if(temp == null){
    //                 temp = st.pop();
    //                 ans.add(temp.val);
    //                 while(!st.isEmpty() && temp == st.peek().right ){
    //                     temp = st.pop();
    //                     ans.add(temp.val);
    //                 }
    //             }else{
    //                 curr = temp;
    //             }

    //         }
    //     }

    //     return ans;

    // }

    public List <Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> st1 = new Stack<>();
        Stack<TreeNode> st2 = new Stack<>();
        List<Integer> postOrder = new ArrayList<>();
        if(root == null) return postOrder;

        st1.push(root);

        while(!st1.isEmpty()){
            root = st1.pop();
            st2.add(root);
            if(root.left != null) st1.push(root.left);
            if(root.right != null) st1.push(root.right);
        }

        while(!st2.isEmpty()){
            postOrder.add(st2.pop().val);
        }

        return postOrder;
    }


}
