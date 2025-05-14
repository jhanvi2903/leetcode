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
class Pair {
    TreeNode node;
    int index;

    public Pair(TreeNode node, int index) {
       this.node = node;
       this.index = index;
    }

}

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> queue = new LinkedList<>();
        int maxWidth = 0;

        if(root == null) return 0;

        queue.offer(new Pair(root, 0));

        while(!queue.isEmpty()) {
            int first = 0; // Reset per level
            int last = 0; // Reset per level
            int size = queue.size();

            for(int i = 0; i < size; i++) {
                Pair pair = queue.poll();
                TreeNode node = pair.node;
                int index = pair.index;

                if(i == 0) first = index;
                if(i == size-1) last = index;

                if(node.left != null) queue.offer(new Pair(node.left, 2 * index + 1));

                if(node.right != null) queue.offer(new Pair(node.right, 2 * index + 2));
            }

            maxWidth = Math.max(maxWidth, last - first + 1);
        }

        return maxWidth;
    }
}

/*
Time Complexity :O(n) Each node is processed once
Space Complexity :O(n) Queue holds nodes per level and all nodes are stored in queue
*/

/*
Using 2 * index + 1 and 2 * index + 2 preserves the structure of a complete binary tree, even when nodes are missing. This indexing helps track the actual position of each node and includes gaps caused by nulls, which is crucial for accurately calculating the maximum width.

Using a simple counterIndex++ doesn’t work because it only counts visited nodes and ignores missing ones, so it underestimates the width in sparse trees.
*/