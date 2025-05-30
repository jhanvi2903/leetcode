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

        // int first = -1;
        // int middle = -1;

        // for(int i = 1; i < list.size(); i++) {
        //     if(first == -1 && list.get(i-1) > list.get(i)) {
        //         first = i-1;
        //         middle = i;
        //     } else {
        //         middle = i;
        //     }
        // }

        // int temp;
        // temp = list.get(first);
        // list.set(first, list.get(middle));
        // list.set(middle, temp);

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
