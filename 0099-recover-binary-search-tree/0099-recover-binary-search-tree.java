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
    int index = 0;
    public void recoverTree(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorderTraversal(root, list);
        Collections.sort(list);
        inorderTra(root, list);
    }

    private void inorderTraversal(TreeNode root, List<Integer> list) {
        if(root == null) return;

        inorderTraversal(root.left, list);
        list.add(root.val);
        inorderTraversal(root.right, list);
    }

    private void inorderTra(TreeNode root, List<Integer> list) {
        if(root == null) return;

        inorderTra(root.left, list);
        if(root.val != list.get(index)) {
            root.val = list.get(index);
        }
        index++;
        inorderTra(root.right, list);
    }
}
