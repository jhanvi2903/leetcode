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
    public boolean isSameTree(TreeNode p, TreeNode q) {

        // If both the nodes are null
        if(p == null && q == null){
            return true;
        }

       // If either one node is null
        if(p == null || q == null){
            return false;
        }
        
        boolean checkLeftTree = isSameTree(p.left, q.left);
        boolean checkRightTree = isSameTree(p.right, q.right);


          //using pre-order traversal
        return (p.val == q.val) && checkLeftTree  && checkRightTree;
    }
}