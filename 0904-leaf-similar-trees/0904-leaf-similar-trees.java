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

// Important Note: BFS traversal works level wise, so it doesn't gaurantee the left to right leaf sequence

//Time Complexity:	O(N + M) If both trees are skewed and very large, with N nodes in root1 and M nodes in root2
//Space Complexity: O(N + M), (stack + list) where M ~ leaf nodes
class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> lr1 = new ArrayList<>();
        List<Integer> lr2 = new ArrayList<>();
    
        dfs(root1, lr1);
        dfs(root2, lr2);

        return lr1.equals(lr2);
    }

// preorder traversal that collects leaf nodes during the visit step.
    private void dfs(TreeNode root, List<Integer> list) {
       if(root == null) return;

       if(root.left == null && root.right == null) {
          list.add(root.val);
       }

       dfs(root.left, list);
       dfs(root.right, list);
    }
}