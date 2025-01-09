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
    public int maxDepth(TreeNode root) {
        
        return usingDFS(root);
    }

    private int usingDFS(TreeNode root) {
         if(root == null) return 0;

         int leftHeight = usingDFS(root.left);
         int rightHeight = usingDFS(root.right);

         return 1 + Math.max(leftHeight, rightHeight);
    }

    //1st way Using level order traversal
    private int usingLevelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
       int counter = 0;

       if(root == null){
        return 0;
       }

        q.add(root);

        while(!q.isEmpty()){
            counter++;
            int n = q.size();

            for(int i = 0; i < n; i++){
                TreeNode curr = q.poll();
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
        }

        return counter;
    }
}