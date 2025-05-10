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
    public boolean isBalanced(TreeNode root) {
        // Start the height check; if any subtree is unbalanced, it will return -1
        return height(root) != -1;
    }

    public int height(TreeNode root) {
        // Base case: null nodes have height 0
        if (root == null) {
            return 0;
        }

        int left = height(root.left);
        
        // Important: if left subtree is unbalanced, propagate -1 upwards
        // Without this, even if a subtree is unbalanced, the algorithm may keep going and give incorrect result
        if (left == -1) return -1;

        int right = height(root.right);
        
        // Important: if right subtree is unbalanced, propagate -1 upwards
        // Skipping this would miss the imbalance in the right subtree and might wrongly report the tree as balanced
        if (right == -1) return -1;

        // Check if current node is balanced; if not, return -1 to signal imbalance
        if (Math.abs(left - right) > 1) return -1;

        // Return the height of the current node: 1 + max height of its subtrees
        // If we don’t take max, we risk returning a shorter path which isn't correct for height calculation
        return 1 + Math.max(left, right);
    }
}
