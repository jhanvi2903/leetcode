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
    public int maxPathSum(TreeNode root) {
       int[] maxSumResult = {root.val};
       dfs(root, maxSumResult);
       return maxSumResult[0];      
    }

    private int dfs(TreeNode root, int[] maxSumResult){
        if(root == null) return 0;

        int leftSum = Math.max(0, dfs(root.left, maxSumResult));
        int rightSum = Math.max(0, dfs(root.right, maxSumResult));

        maxSumResult[0] = Math.max(maxSumResult[0], root.val + leftSum + rightSum);

        return root.val + Math.max(leftSum, rightSum);
    } 
}