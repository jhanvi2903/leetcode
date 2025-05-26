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
Intution: Since in a BST we only go in one direction at each step, I’ll keep track of the parent and traverse until I reach null — which is where the new node belongs. Then I attach it on the left or right of the last valid node.
Time complexity: O(h)
Space complexity: O(1)
*/
class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode newNode = new TreeNode(val);

        if(root == null) {
            return newNode;
        }
        
        TreeNode parentNode = null;
        TreeNode curr = root;

        // Traverse the tree to find the correct insertion point
        while(curr != null) {
             parentNode = curr;

             if(val > curr.val) {
                curr = curr.right;
             } else {
                curr = curr.left;
             }
        }

         // Attach the new node to the appropriate side of the parent node
        if(parentNode.val < val) {
            parentNode.right = newNode; 
        } else {
            parentNode.left = newNode;
        }

        return root;
    }
}