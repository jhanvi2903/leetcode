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
        // Initialize an array to hold the maximum path sum result.
        // Using an array so that it can be updated inside the dfs function.
        // If the value of root.val is stored in int varaible then the modified value in dfs() will be local to it and the original value of root will be returned instead of returning maximum path sum
        int[] maxSumResult = {root.val};
        dfs(root, maxSumResult);
        return maxSumResult[0];      
    }

    private int dfs(TreeNode root, int[] maxSumResult) {
        if (root == null) return 0;   // Base case: if the node is null, return 0 (no path to add).

        // Recursively calculate the maximum path sum of the left and right subtrees.
        // If the path sum is negative, return 0, as negative paths do not contribute to the max sum.
        int leftSum = Math.max(0, dfs(root.left, maxSumResult));
        int rightSum = Math.max(0, dfs(root.right, maxSumResult));

        // This is the key part where we consider paths that may pass through the root.
        maxSumResult[0] = Math.max(maxSumResult[0], root.val + leftSum + rightSum);

        // We return either left or right subtree's max sum along with the current node's value.
        return root.val + Math.max(leftSum, rightSum); 
    } 
}

/*
Time complexity (worst case): O(n)
1. Each node is visited exactly once.

Space complexity (worst case): O(n)
1. Due to the recursion stack as each method call is stored on the call stack until it completes execution.
*/
