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
        Map<Integer,Integer> map = new HashMap<>();
    //puttin inorder in hashmap 
    for ( int i =0 ; i < inorder.length;i++){
        map.put(inorder[i],i);
    }

    TreeNode root = buildTreeHelper(preorder, 0 , preorder.length-1,
                                    inorder,0,inorder.length-1,
                                    map);

    return root;
    }
    
    public TreeNode buildTreeHelper(int[] preorder , int preStart , int preEnd, int[] inorder, int inStart , int inEnd, Map<Integer,Integer> map)
    {
        if(preStart > preEnd || inStart > inEnd) return null;

        //create a root
        TreeNode root = new TreeNode(preorder[preStart]);

        //find the root in Inorder and get a pointer to do divison of arrays and recurse

        int inRoot = map.get(root.val); //returns index 
        
        int numsLeft = inRoot - inStart ;

        root.left = buildTreeHelper(preorder,preStart+1,preStart+numsLeft,inorder,inStart,inRoot-1,map);
        root.right = buildTreeHelper(preorder,preStart+numsLeft+1,preEnd,inorder,inRoot+1,inEnd,map);

        return root;



    }


                




}