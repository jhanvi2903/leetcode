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
    HashMap<Integer, Integer> hm = new HashMap<>();
    int postorderIndex;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
         postorderIndex = postorder.length-1;

         for(int i = 0; i < inorder.length; i++) {
            hm.put(inorder[i], i);
         }

         TreeNode root = build(postorder, 0, inorder.length-1);

         return root;      
    }

    private TreeNode build(int postorder[], int start,int end) {
        if(start > end) return null;

        int rootValue = postorder[postorderIndex--];
        TreeNode root = new TreeNode(rootValue);
        int mid = hm.get(rootValue);

        root.right = build(postorder, mid+1, end);
        root.left = build(postorder, start, mid-1);

        return root;
    }
}