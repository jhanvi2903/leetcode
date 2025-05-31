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
    public int maxLevelSum(TreeNode root) {
        int maxSum = Integer.MIN_VALUE;
        int level = 0;
        int resultLevel = 0;

        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);

        while(!q.isEmpty()) {
            int size = q.size();
            int sum = 0;
            level = level + 1;

            for(int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                sum += curr.val;

                if(curr.left != null) q.offer(curr.left);
                if(curr.right != null) q.offer(curr.right);
            }

            if(maxSum < sum) {
                maxSum = sum;
                resultLevel  = level;
            }
        }

        return resultLevel;       
    }
}