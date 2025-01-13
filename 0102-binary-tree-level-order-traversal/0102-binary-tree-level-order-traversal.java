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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> result = new LinkedList<List<Integer>>();

        if(root == null){
            return result;
        }

        queue.offer(root);

        while(!queue.isEmpty()){
            int queueSize = queue.size();
            List<Integer> sublist = new LinkedList<Integer>();
            
            for(int i = 0; i < queueSize; i++){
                TreeNode curr = queue.poll();
                sublist.add(curr.val);

                if(curr.left != null){
                    queue.offer(curr.left);
                }
                if(curr.right != null){
                    queue.offer(curr.right);
                }

                
            }

            result.add(sublist);
        }
        
        return result;
    }
}