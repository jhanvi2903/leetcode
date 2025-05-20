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
Morris traversal: Way to traverse a binary tree without recursion or a stack.
Time complexity: O(n)
Space complexity(excluding result):	O(1)
Space complexity(including result):	O(n)
*/

class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        TreeNode curr = root;

        while(curr != null) {
            // Case 1: If there is no left child,
            // print current node and move to right child
            if(curr.left == null) {
                result.add(curr.val);
                curr = curr.right;
            } else {
                // Case 2: Current has a left child,
                // Find the predecessor (rightmost node in left subtree)
                TreeNode predecessor = curr.left;

                // Move to the rightmost node in the left subtree or
                // stop if the thread pointing back to current already exists
                while(predecessor.right != null && predecessor.right != curr) {
                    predecessor = predecessor.right;
                }

                // Thread creation: first time visiting this node
                if(predecessor.right == null) {
                    result.add(curr.val);   // Visit BEFORE going left (preorder)
                    predecessor.right = curr;   // Create thread
                    curr = curr.left;    
                } else {
                // Thread already exists: remove it and move right
                    predecessor.right = null;   // Remove thread
                    curr = curr.right;
                }

            }
        }

        return result;
    }
}
