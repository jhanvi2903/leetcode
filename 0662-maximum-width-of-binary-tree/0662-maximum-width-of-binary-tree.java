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
    static class Pair {
    TreeNode node;
    int pos;

    Pair(TreeNode node, int pos){
        this.node = node;
        this.pos = pos;
    }
 }
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> q = new LinkedList<>();
        int maxWidth = 0;

        if(root == null){
            return 0;
        }

        q.offer(new Pair(root, 0));

        while(!q.isEmpty()){
            int n = q.size();
            int first = 0;
            int last = 0;

            for(int i = 0; i < n; i++){
                Pair p = q.poll();
                TreeNode currNode = p.node;
                int position = p.pos;

                if(i == 0){
                    first = position; 
                } 

                if(i == n-1){
                    last = position;
                }

                if(currNode.left != null) {
                    q.offer(new Pair(currNode.left, 2*position + 1));
                }

                if(currNode.right != null){
                    q.offer(new Pair(currNode.right, 2* position + 2));
                }
            }
          
          maxWidth = Math.max(maxWidth, last - first + 1);

        }

        return maxWidth;
    }
}