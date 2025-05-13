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
class Tuple {
    TreeNode node;
    int row;
    int col;

    public Tuple(TreeNode node, int row, int col) {
        this.node = node;
        this.row = row;
        this.col = col;
    }
}

class Solution {

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        // TreeMap to sort the columns (left to right)
        // Inner TreeMap to sort the rows (top to bottom)
        // PriorityQueue to sort values at the same 
        Map<Integer, Map<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();

        Queue<Tuple> queue = new LinkedList<>(); // Queue for BFS traversal (level order traversal)
        queue.offer(new Tuple(root, 0, 0));

        while(!queue.isEmpty()) {
            Tuple tuple = queue.poll();
            TreeNode node = tuple.node;
            int row = tuple.row;
            int col = tuple.col;

            map
             .computeIfAbsent(col, colKey -> new TreeMap<>())
             .computeIfAbsent(row, rowKey -> new PriorityQueue<>())
             .add(node.val);

             if(node.left != null) {
                queue.offer(new Tuple(node.left, row+1, col-1));
             }

             if(node.right != null) {
                queue.offer(new Tuple(node.right, row+1, col+1));
             }             
        }

        
        List<List<Integer>> result = new ArrayList<>();

        // Traverse the sorted columnTable: column by column
        for(Map<Integer, PriorityQueue<Integer>> colValue : map.values()){
            List<Integer> sublist = new ArrayList<>();

            // Traverse each row in current column
            for(PriorityQueue<Integer> rowValues : colValue.values()) {
                while(!rowValues.isEmpty()) {
                    sublist.add(rowValues.poll()); // Poll ensures sorted order
                } ; 
            }
            result.add(sublist);
        }

        return result;
    }
}

/*
Time Complexity: O(n log n), where each node is traversed exactly once and pq takes log n time to insert or remove the element.

Space Complexity: O(n), where n is the number of nodes in the tree.
*/