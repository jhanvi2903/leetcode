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
    HashMap<Integer,Integer> hm;
    int preorderIndex = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        hm = new HashMap<>();

        for(int i = 0; i < inorder.length; i++) {
            hm.put(inorder[i], i);
        }

        return build(inorder, 0, inorder.length - 1, preorder, 0, preorder.length - 1);
    }

    private TreeNode build(int[] inorder, int inStart, int inEnd, int[] preorder, int preStart, int preEnd) {
        if(inStart > inEnd || preStart > preEnd) {
            return null;
        }

        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);

        int mid = hm.get(rootVal);
        int nums = mid - inStart; // Number of elements on the left subtree in inorder

        root.left = build(inorder, inStart, mid - 1, preorder, preStart + 1, preStart + nums);
        root.right = build(inorder, mid + 1, inEnd, preorder, preStart + nums + 1, preEnd);

        return root;
    }
}