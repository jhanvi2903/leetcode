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
// Time Complexity: O(n)
// Space Complexity: O(n) (including recursion stack + hashmap)
class Solution {
    int preorderIndex = 0;
    HashMap<Integer, Integer> hm = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        for(int i = 0; i < inorder.length; i++) {
            hm.put(inorder[i], i);
        }

        TreeNode root = build(preorder, 0, inorder.length - 1);

        return root;        
    }

    private TreeNode build(int[] preorder, int start, int end) {
        if(start > end) return null;

        int rootValue = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootValue);
        int mid = hm.get(rootValue);

        root.left = build(preorder, start, mid - 1);
        root.right = build(preorder, mid+1, end);

        return root;
    }
}