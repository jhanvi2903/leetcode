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
    public boolean findTarget(TreeNode root, int k) {
        ArrayList<Integer> inorder = new ArrayList<>();
        inorderTraversal(root, inorder);

        int i = 0;
        int j = inorder.size()-1;

        while(i < j) {
            int sum = inorder.get(i) + inorder.get(j);
            if(sum == k) {
                return true;
            } else if (sum < k) {
                i++;
            } else {
                j--;
            }
        }

        return false;
    }

    private void inorderTraversal(TreeNode root, ArrayList<Integer> inorder) {
        if(root == null) return;

        inorderTraversal(root.left, inorder);
        inorder.add(root.val);
        inorderTraversal(root.right, inorder);
    }
}

/*
Approach 1: Inorder traversal will add elements in sorted order , then applying 2 pointer technique to find 2 elements = target
Time complexity : O(n)
Worst Space Complexity: O(n), for balanced tree : O(N) 
Bonus : Follows the BST property as the elements are stored in sorted order in list and 2 pointer technique is used which is used on the sorted list

Approach 2: Using inorder traversal and hashset, if we find target - curr element in hashset, then return true else add the curr element in hashset
Time complexity : O(n)
Worst Space Complexity: O(n), for balanced tree : O(N) 


Approach 3 : Using 2 stack, one for storing min element and other for storing maximum element (Follows 2 pointer approach only) 
Time complexity : O(n)
Worst Space Complexity: O(n), but for balanced tree : O(h) as one halve is always eliminated at each level
Bonus : Follows the BST property as the elements are stored in sorted order in list and 2 pointer technique is used which is used on the sorted list 
*/