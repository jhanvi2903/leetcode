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
// Time Complexity	
// Balanced BST:  	O(log n)
// Skewed BST (worst case):	O(n)	

// Space Complexity
// Balanced BST:   O(1)
// Skewed BST (worst case)	:  O(1)
class Solution {
    public TreeNode searchBST(TreeNode root, int val) {

        while(root != null) {
            if(root.val == val) {
                 return root;
            }else if(val < root.val) {
                root = root.left;
            } else if(val > root.val){
                root = root.right;
            }        
        }

        return null;       
    }
}