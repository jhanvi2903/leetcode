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

 // DFS
class Solution {
    public boolean checkTree(TreeNode root) {
        // Base case: null node or leaf node satisfies the property
        if(root == null || (root.left == null && root.right == null)) {
           return true;
        }

        int left = root.left != null ? root.left.val : 0;  // Get the value of the left child (0 if it doesn't exist)
        int right = root.right != null ? root.right.val : 0; // Get the value of the right child (0 if it doesn't exist)

        // Check if the current node's value is equal to the sum of its children's values
        // and recursively check the left and right subtrees
        if(root.val == left + right && checkTree(root.left) == true && checkTree(root.right) == true) {
            return true;
        }

        // Return false if the sum property is violated at this node
        return false;
    }
}

/*
Time complexity: O(n) – each node is visited once
Space complexity: O(n) - due to recursion stack
*/