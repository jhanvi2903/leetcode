/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/* 
Using BFS:
T.C : O(n)
S.C : O(n)
*/
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> result = new ArrayList<>();

        // To store child-parent relationship: This map stores each node's parent. 
        // Since TreeNode doesn't have a parent pointer, we create this manually to allow "upward" traversal.
        HashMap<TreeNode, TreeNode> hm = new HashMap<>(); 

        Queue<TreeNode> q = new  LinkedList<>(); // A queue for level-order traversal (BFS)

        /*
         If the below BFS and parent map creation is skipped:
         You won't be able to traverse upward from the target node,
         meaning you can't find nodes at distance K that lie "above" the target.
        */
        q.offer(root);
        while(!q.isEmpty()) {
           int size = q.size();
           for(int i = 0; i < size; i++) {
            TreeNode curr = q.poll();

            if(curr.left != null) {
               hm.put(curr.left, curr);
               q.offer(curr.left);
            }

            if(curr.right != null) {
               hm.put(curr.right, curr);
               q.offer(curr.right);
            }
            }
        }

        HashSet<TreeNode> vis = new HashSet<>(); // Set to track visited nodes and avoid cycles (especially with parent references)

        // Start BFS from the target node to find all nodes at distance K
        q.offer(target);
        while(k > 0 && !q.isEmpty()) {
           int size = q.size();
           for(int i = 0; i < size; i++) {
            TreeNode curr = q.poll();
            vis.add(curr);  // mark as visited
            
            // Explore left child if it is not null and not visited
            if(curr.left != null && !vis.contains(curr.left)) {
               q.offer(curr.left);
            }

             // Explore right child if it is not null and not visited
            if(curr.right != null && !vis.contains(curr.right)) {
                q.offer(curr.right);
            }

            // Explore parent (from the map) if not visited
            if(hm.containsKey(curr) && !vis.contains(hm.get(curr))) {
                q.offer(hm.get(curr));
            }
         }

           k--;  // Reduce K after one level of BFS
        }

        // After k levels, all remaining nodes in the queue are at distance K
        while(!q.isEmpty()) {
            result.add(q.poll().val);
        }

        return result;
    }
}

/*
Consequence of not checking hm.containsKey(curr):
1. The root node has no parent, so it's not in the hm map.
2. If you skip hm.containsKey(curr), calling hm.get(curr) may return null.
3. You might do q.offer(null) — accidentally adding a null to the queue.
4. Later, when you process this null, accessing .val or children causes a NullPointerException.
5. This check prevents that by skipping the parent lookup when the node has no parent (i.e., it's the root).
*/