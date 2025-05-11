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
        Boolean leftToRight = true;  // Flag to determine the direction of traversal (left-to-right or right-to-left)

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

            // If the flag 'leftToRight' is false, reverse the sublist to get the zigzag effect
            if(leftToRight != true) Collections.reverse(sublist);

            result.add(sublist);
            leftToRight = !leftToRight; // Flip the direction for the next level
        }

        return result;
    }
}

/*
The time complexity is O(n) because the tree is traversed level by level, and each node is processed once with an additional reversal operation at each level.

The space complexity is O(n) because of the space required for the queue and the result list
*/

/*
In the context of the zigzag level order traversal, BFS (Breadth-First Search) is preferred over DFS (Depth-First Search) because:
1. Level-wise Traversal: BFS naturally processes nodes level by level, which is ideal for this problem, as it allows easy access to nodes at each level for the zigzag pattern.
2. Zigzag Pattern: BFS can efficiently flip the direction of traversal after each level, while DFS would require additional bookkeeping or stack manipulation to achieve the same result.
3. Simplicity: BFS simplifies the logic by using a queue to keep track of nodes, whereas DFS would need extra steps for managing the direction change at each level.
*/