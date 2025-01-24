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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> hm = new HashMap<>();

        if(inorder.length != postorder.length) {
            return null;
        }

        for(int i = 0; i < inorder.length; i++) {
              hm.put(inorder[i] , i);
        }

        return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, hm);
    }

    private TreeNode build(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd, HashMap<Integer, Integer> hm) {

        if(inStart > inEnd || postStart > postEnd) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[postEnd]);
        int mid = hm.get(postorder[postEnd]);
        int leftTotalNum = mid - inStart;

        root.left = build(inorder, inStart, mid - 1, postorder, postStart, postStart + leftTotalNum - 1, hm);
        root.right = build(inorder, mid + 1, inEnd, postorder,postStart + leftTotalNum , postEnd - 1, hm);

        return root;
    }
}