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
    public boolean isSameTree(TreeNode p, TreeNode q) {

        //Base Case 1: If both nodes are null, they are structurally identical at this point
        if(p == null && q == null){
            return true;
        }

       //Base Case 2: If one node is null and the other is not, the trees are not the same
       //Without this, we will get a NullPointerException when trying to access p.val, q.val, p.left, q.left, p.right, or q.right on a null node
        if(p == null || q == null){
            return false;
        }
        
        boolean checkLeftTree = isSameTree(p.left, q.left);
        boolean checkRightTree = isSameTree(p.right, q.right);


          //using pre-order traversal: Root Node -> Left -> Right
          //final check: Combine current node value comparison with left and right subtree comparisons
        return (p.val == q.val) && checkLeftTree  && checkRightTree;
    }
}

/*
Time complexity (worst case): O(n)
1. Each node is visited exactly once.

Space complexity (worst case): O(n)
1. Due to the recursion stack as each method call is stored on the call stack until it completes execution.
*/

/*
Preorder traversal is used here because we want to compare the current nodes first before going deeper. If the values at the root don't match, we can immediately return false without checking subtrees. Inorder or postorder would check children before verifying the current nodes, which is unnecessary and less efficient for this specific problem.
*/


/*
In the isSameTree function, even though recursion goes deep into the subtrees first, why is it still considered a preorder comparison? Doesn’t the recursion make it seem like we're checking children before the current node?
Yes, even though recursive calls go deep into the left/right subtrees first, the check (p.val == q.val) is evaluated before combining results of left and right subtree comparisons. So the structure still logically follows preorder comparison, making it suitable for early termination if node values don’t match.
*/

/*
 Why Base Case 1 must come before Base Case 2 in isSameTree?
1. In the function, we first check if both nodes are null. If we don't check this before the next condition, and only one node is null, Java will enter the second if block and return false without realizing that both were actually null (a valid match).
2. So, ordering matters. Checking if both nodes are null first ensures we correctly identify structurally matching parts of the tree, especially when comparing leaf nodes or empty trees. Skipping or misordering this can cause false negatives or even NullPointerExceptions when accessing values of null nodes.
*/