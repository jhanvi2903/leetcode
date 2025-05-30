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
public class Solution {
    int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return diameter;
    }

    private int helper(TreeNode root) {
        if (root == null) {
             return 0;
        }

        // Recursively calculate the height of the left and right subtrees.
        int left = helper(root.left);
        int right = helper(root.right);

        // selects the maximum diameter by comparing the previous diameter and the current node diameter
        diameter = Math.max(diameter, left + right); 
        
        // returns maximum height of the node + 1 (includes the current node)
        return 1 + Math.max(left, right); 
    }
}

/*
Time complexity (worst case): O(n)
1. Each node is visited exactly once.

Space complexity (worst case): O(n)
1. Due to the recursion stack as  each method call is stored on the call stack until it completes execution.
*/