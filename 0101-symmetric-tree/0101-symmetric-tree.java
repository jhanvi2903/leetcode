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
    public boolean isSymmetric(TreeNode root) {
        return helper(root.left, root.right);
    }

    public boolean helper(TreeNode leftTree, TreeNode rightTree){
        if(leftTree == null && rightTree == null){
            return true;
        }

        if(leftTree == null || rightTree == null){
            return false;
        }

        return (leftTree.val == rightTree.val) && helper(leftTree.left, rightTree.right) && helper(leftTree.right, rightTree.left);
    }
}