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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> zigzagTraversal = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Boolean leftToRight = true ;

        if(root ==  null) return zigzagTraversal ;
        queue.offer(root);
        while(!queue.isEmpty()){
            int levelSize = queue.size();
            List<Integer> subList = new ArrayList<>();
            for(int i=0;i<levelSize;i++){
                if(queue.peek().left!= null) queue.offer(queue.peek().left);
                if(queue.peek().right!= null) queue.offer(queue.peek().right);
                if(leftToRight) subList.add(queue.poll().val);
                else subList.add(0,queue.poll().val);
            }
            leftToRight = !leftToRight;
            zigzagTraversal.add(subList);
        }
        return zigzagTraversal;
    }
}