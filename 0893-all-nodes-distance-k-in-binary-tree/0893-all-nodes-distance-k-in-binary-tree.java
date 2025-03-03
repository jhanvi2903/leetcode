/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> result = new ArrayList<>();
        HashMap<TreeNode, TreeNode> hm = new HashMap<>(); // To store child-parent relationship
        Queue<TreeNode> q = new  LinkedList<>();

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

        HashMap<TreeNode, Integer> vis = new HashMap<>();
        q.offer(target);
        while(k > 0 && !q.isEmpty()) {
           int size = q.size();
           for(int i = 0; i < size; i++) {
            TreeNode curr = q.poll();
            vis.put(curr, 1);
            
            if(curr.left != null && !vis.containsKey(curr.left)) {

                q.offer(curr.left);
            }

            if(curr.right != null && !vis.containsKey(curr.right)) {
                q.offer(curr.right);
            }

            if(hm.containsKey(curr) && !vis.containsKey(hm.get(curr))) {
                q.offer(hm.get(curr));
            }
         }

           k--;
        }

        while(!q.isEmpty()) {
            result.add(q.poll().val);
        }

        return result;
    }
}