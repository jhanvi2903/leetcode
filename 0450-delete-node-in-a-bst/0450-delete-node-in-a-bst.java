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
 Time complexity: O(n)
 Space complexity: O(n)
 */
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) {
            return null;
        }

        // Step 1: Navigate to the node to be deleted
        if(key < root.val) {
            root.left = deleteNode(root.left, key); // Go left
        } else if(key > root.val) {
            root.right = deleteNode(root.right, key); // Go right
        } else {
            // Step 2: Found the node to delete
            if(root.left == null) return root.right; // Case 1: Only right child
            if(root.right == null) return root.left; // Case 2: Only left child

            // Case 3: Both child exits
            // Find the inorder successor (smallest in right subtree)
            TreeNode minNode = getMinFromRightSubtree(root.right);

            // Step 4: Copy the inorder successor's value to the current node
            root.val = minNode.val; 

            // Step 5: Delete the inorder successor node
            root.right = deleteNode(root.right, minNode.val);
        }

        return root;
    }

    // Helper function to find the minimum node in a right subtree of a node which needs to be deleted
    private TreeNode getMinFromRightSubtree(TreeNode root) {
        while(root.left != null) {
            root = root.left; // go to extreme left
        }
        
        return root;
    }
}