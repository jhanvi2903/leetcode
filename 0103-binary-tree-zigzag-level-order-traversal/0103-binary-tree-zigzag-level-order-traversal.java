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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        Boolean leftToRight = true;

        if(root == null){
            return result;
        }

        q.offer(root);

        while(!q.isEmpty()){
            int n = q.size();
            List<Integer> sublist = new ArrayList<>();

            for(int i = 0; i < n; i++){
                TreeNode curr = q.poll();
                sublist.add(curr.val);
                if(curr.left != null) q.offer(curr.left);
                if(curr.right != null) q.offer(curr.right);
            }

            if(leftToRight != true) Collections.reverse(sublist);

            result.add(sublist);
            leftToRight = !leftToRight;
        }

        return result;
    }
}