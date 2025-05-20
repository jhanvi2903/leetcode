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
    public List<Integer> inorderTraversal(TreeNode root) {
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
                // Find the inorder predecessor (rightmost node in left subtree)
                TreeNode predecessor = curr.left;

                // Move to the rightmost node in the left subtree or
                // stop if the thread pointing back to current already exists
                while(predecessor.right != null && predecessor.right != curr) {
                    predecessor = predecessor.right;
                }

                 /*
                     * Thread Creation:
                     * - We have NOT visited this left subtree before.
                     * - Create a temporary thread from predecessor's right to current.
                     *   This allows us to come back to 'current' after completing the left subtree traversal without using recursion or stack.
                     * - Move current to its left child to continue traversal.
                     */
                if(predecessor.right == null) {
                    predecessor.right = curr;   // Create thread
                    curr = curr.left;    
                } else {
                    /*
                     * Thread Removal:
                     * - We have ALREADY visited the left subtree (thread exists).
                     * - The predecessor's right pointer is pointing back to current, meaning we returned here via the thread.
                     * - Now, remove the thread to restore original tree structure.
                     * - Print current node's value (visiting current after left subtree).
                     * - Move to current's right child to continue traversal.
                     */
                    predecessor.right = null;   // Remove thread
                    result.add(curr.val);
                    curr = curr.right;
                }

            }
        }

        return result;
    }
}