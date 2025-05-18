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
/* 
Using BFS:
T.C : O(n)
S.C : O(n)
*/

class Solution {
    public int amountOfTime(TreeNode root, int start) {
        HashMap<TreeNode, TreeNode> childParentHashmap = new HashMap<>();
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode startNode = null;

        // Step 1: BFS to populate child-parent and to find the start node
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();

             // If current node is the one where infection starts, save it
            if(node.val == start) {
                startNode = node;
            }

            // If left child exists, map its parent and enqueue it
            if(node.left != null) {
                childParentHashmap.put(node.left, node);
                queue.offer(node.left);
            }

            // If right child exists, map its parent and enqueue it
            if(node.right != null) {
                childParentHashmap.put(node.right, node);
                queue.offer(node.right);
            }
        }

        HashSet<TreeNode> vis = new HashSet<>(); // To track already infected nodes
        queue.offer(startNode);
        int minutes = -1; // Timer to track minutes until whole tree is infected

        // Step 2: BFS to simulate infection spread from startNode
        while(!queue.isEmpty()) {
            int size = queue.size();
            minutes++;

            for(int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                vis.add(node);

                // Try to infect the left child
                if(node.left != null && !vis.contains(node.left)) {
                    queue.offer(node.left);
                }

                 // Try to infect the right child
                if(node.right != null && !vis.contains(node.right)) {
                    queue.offer(node.right);
                }

                // Try to infect the parent
                if(childParentHashmap.containsKey(node) && !vis.contains(childParentHashmap.get(node))) {
                    queue.offer(childParentHashmap.get(node));
                }
            }
        }

        return minutes;
    }
}