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
The LCA of two nodes is the deepest node in the tree that has both p and q as descendants (a node can be a descendant of itself)
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

      // Base case:
        // If root is null, or root is equal to either p or q, then return root because either:
        // - we've reached the end of a path (null), or
        // - we've found one of the nodes (p or q)
      if(root == null || root == p || root == q){
        return root;
      }  

      // Recurse on the left subtree to search for p and q  
      TreeNode left =  lowestCommonAncestor(root.left, p, q); 

      // Recurse on the right subtree to search for p and q
      TreeNode right = lowestCommonAncestor(root.right, p, q);

      // If both left and right are not null, it means:
      // - p and q are found in different subtrees,
      // - so current node `root` is their lowest common ancestor
      if(left != null && right != null){
         return root;
      }

      // If one of the sides returned a non-null value,
      // return that side (either p or q was found in that subtree
      return left != null ? left : right; 
    }
}

/*
Worst-case space complexity: O(n) Due to recursion stack depth when the tree is skewed.
Worst-case Time Complexity: O(n) where n is the number of nodes in the tree, since each node is visited once.
*/