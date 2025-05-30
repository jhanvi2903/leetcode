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

    //2nd way: Using DFS recursion
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

/*
Time Complexity (Worst Case): O(n)
DFS: Each node is visited exactly once during the DFS traversal.
BFS: Each node is enqueued and dequeued exactly once during the traversal.

Space Complexity (Worst Case): O(n)
- For DFS: Due to the recursion stack as each method call is stored on the call stack until it completes execution.
- For BFS: Due to the usage of a queue that can hold up to O(n) nodes in the worst case 
*/
