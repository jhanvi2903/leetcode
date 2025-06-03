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
    int sum = 0;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;

        return helper(root, targetSum) == true ? true : false;
    }

    private boolean helper(TreeNode root, int targetSum) {

        sum += root.val;

        if(root.left != null) {
            if(helper(root.left, targetSum)) return true;
        }
        if(root.right != null) {
            if(helper(root.right, targetSum)) return true;
        }

        if(root.left == null && root.right == null && sum == targetSum) return true;

        sum = sum - root.val;
        return false;
    }
}