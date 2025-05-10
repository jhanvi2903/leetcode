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

 //Balanced binary tree : A binary tree in which the height difference between the left and right subtrees of every node is at most 1
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

/*
Time complexity (worst case): O(n)
1. Each node is visited exactly once.
2. Even if some subtrees are unbalanced, the worst case still requires visiting all n nodes.

Space complexity (worst case): O(n)
1. Due to the recursion stack.
*/

/*
The code uses a depth-first search (DFS) approach, but it's not a preorder traversal. It first computes the height of the left and right subtrees and then processes the current node by checking the balance condition. So the order is more similar to postorder traversal — Left → Right → Node — even though we’re not explicitly printing or visiting the node in the typical sense

The height-balanced tree check is best solved using a postorder DFS because it computes subtree heights bottom-up efficiently. While it's theoretically possible to use BFS, it would be less optimal and more complex to manage height information at each level
*/
