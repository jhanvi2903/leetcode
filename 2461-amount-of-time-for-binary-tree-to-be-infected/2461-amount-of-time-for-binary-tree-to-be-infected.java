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
        HashMap<TreeNode, TreeNode> childParentHashmap = new HashMap<>();
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode startNode = null;

        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if(node.val == start) {
                startNode = node;
            }

            if(node.left != null) {
                childParentHashmap.put(node.left, node);
                queue.offer(node.left);
            }

            if(node.right != null) {
                childParentHashmap.put(node.right, node);
                queue.offer(node.right);
            }
        }

        HashSet<TreeNode> vis = new HashSet<>();
        queue.offer(startNode);
        int minutes = -1;

        while(!queue.isEmpty()) {
            int size = queue.size();
            minutes++;

            for(int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                vis.add(node);

                if(node.left != null && !vis.contains(node.left)) {
                    queue.offer(node.left);
                }

                if(node.right != null && !vis.contains(node.right)) {
                    queue.offer(node.right);
                }

                if(childParentHashmap.containsKey(node) && !vis.contains(childParentHashmap.get(node))) {
                    queue.offer(childParentHashmap.get(node));
                }
            }
        }

        return minutes;
    }
}