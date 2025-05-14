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
    public boolean checkTree(TreeNode root) {
        // Base case: null node or leaf node satisfies the property
        if(root == null || (root.left == null && root.right == null)) {
           return true;
        }

        int left = root.left != null ? root.left.val : 0;
        int right = root.right != null ? root.right.val : 0;

        if(root.val == left + right && checkTree(root.left) == true && checkTree(root.right) == true) {
            return true;
        }

        return false;
    }
}