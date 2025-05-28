/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/*
Using iterative approach: optimized
Time complexity: O(n)
Space complexity: O(1)

Using recursion:
Time complexity: O(n)
Space complexity: O(n)
*/
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        while(root != null){
             // If both p and q are smaller than root, LCA lies in left subtree
            if(p.val < root.val && q.val < root.val){
                root = root.left; // Move to left child

            // If both p and q are greater than root, LCA lies in right subtree
            }else if(p.val > root.val && q.val > root.val){
                root = root.right; // Move to right child
            }else {
                // If p and q lie on different sides of root, or one is equal to root,
                // then root is the lowest common ancestor
                return root;
            }
        }

        return null; // If the tree is empty or no common ancestor is found
    }
}