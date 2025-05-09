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
        List<List<Integer>> result = new ArrayList<>();

       // Important: If root is null, return empty list.
       // Otherwise, without this check if root is null, accessing root.val or root.left/right later would throw a NullPointerException.
        if(root == null){
            return result;
        }

        queue.offer(root);

        while(!queue.isEmpty()){
            int queueSize = queue.size(); // Crucial: this prevents processing newly added children in the same level
            List<Integer> sublist = new ArrayList<>();
            
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