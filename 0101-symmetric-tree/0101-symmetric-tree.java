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
        // Base condition 1: If both the subtree are null, then symmetric 
        if(leftTree == null && rightTree == null){
            return true;
        }

        // Base condition 1: If any node among them is null, then not symmetric
        if(leftTree == null || rightTree == null){
            return false;
        }

    // Recursive Case: Both nodes are not null:
    // If both nodes are non-null, we compare their values (leftTree.val == rightTree.val).
    // Then, we make two recursive calls to compare the following:
    // The left child of the left subtree with the right child of the right subtree 
    // The right child of the left subtree with the left child of the right subtree 
        return (leftTree.val == rightTree.val) && helper(leftTree.left, rightTree.right) && helper(leftTree.right, rightTree.left);
    }
}