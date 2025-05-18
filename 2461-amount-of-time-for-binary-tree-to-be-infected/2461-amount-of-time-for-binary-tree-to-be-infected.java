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
    public int amountOfTime(TreeNode root, int start) {
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();

        // Step 1: BFS to populate parentMap and find the start node
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode startNode = null;

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            if (current.val == start) {
                startNode = current;
            }

            if (current.left != null) {
                parentMap.put(current.left, current);
                queue.offer(current.left);
            }

            if (current.right != null) {
                parentMap.put(current.right, current);
                queue.offer(current.right);
            }
        }

        // Step 2: BFS to simulate infection spread
        Set<TreeNode> visited = new HashSet<>();
        queue.offer(startNode);
        visited.add(startNode);

        int time = -1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            time++;

            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();

                if (current.left != null && visited.add(current.left)) {
                    queue.offer(current.left);
                }

                if (current.right != null && visited.add(current.right)) {
                    queue.offer(current.right);
                }

                TreeNode parent = parentMap.get(current);
                if (parent != null && visited.add(parent)) {
                    queue.offer(parent);
                }
            }
        }

        return time;
    }
}
