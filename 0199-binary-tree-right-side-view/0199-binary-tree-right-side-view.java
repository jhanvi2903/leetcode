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
    public List<Integer> rightSideView(TreeNode root) {
        // Using Level order traversal,
        // store the rightmost element from the queue to the list
        // Rightmost element will be present at the last position in the queue

        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> result = new ArrayList<>();

        if(root == null) return result;

        q.offer(root);

        while(!q.isEmpty()){
            int n = q.size();

            for(int i = 0; i < n; i++){
                TreeNode curr = q.poll();

//Adding Rightmost element as it is present at the last position in the queue
                if(i == n-1) result.add(curr.val); 

                if(curr.left != null) q.offer(curr.left);
                if(curr.right != null) q.offer(curr.right);
            }
        }

        return result;
    }
}