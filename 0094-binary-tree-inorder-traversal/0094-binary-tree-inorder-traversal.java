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
   public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        List<Integer> result = new ArrayList<>();
        TreeNode node = root;

        while(true){
            if(node != null){
                st.push(node);
                node = node.left; // keep moving to the left until it points to the null and add the node to stack
            }else{
                if(st.isEmpty()){ // If stack becomes empty, then the entire binary tree is traversed
                    break;
                }
                node = st.pop();  // When the node becomes null, pop the element from stack and store its value in list 
                result.add(node.val);
                node = node.right; // Then move to right
            }
        }
       
        return result;
    }
}