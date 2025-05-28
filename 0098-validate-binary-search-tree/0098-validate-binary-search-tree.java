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

 /*
 Approach : Preorder traversal (Checking the node's value if it is in range or not)
 Time complexity: O(n)
 Space complexity: O(n)
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        boolean result = helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
        return result;
    }

    private boolean helper(TreeNode root, long min,long max) {
        if(root == null) return true;

        if(root.val <= min || root.val >= max) return false;

        boolean leftSubtree = helper(root.left, min, root.val);
        boolean rightSubtree = helper(root.right, root.val, max);

        return leftSubtree && rightSubtree; 
    }
}