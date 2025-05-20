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
 Time complexity : O(n)
 Space complexity : O(n)
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";

        StringBuilder result = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if(node == null) {
                result.append("# ");
            } else {
                result.append(node.val).append(" ");

                queue.offer(node.left);
                queue.offer(node.right);
            }
        }

        return result.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        if(data == "") {
            return null;
        }

        String[] values = data.split(" ");

        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);

        int i = 1;
        while(!q.isEmpty()) {
            TreeNode node = q.poll();

            if(!values[i].equals("#")) {
                TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                node.left = left;
                q.offer(left);
            }
            i++;

            if(!values[i].equals("#")) {
                TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                node.right = right;
                q.offer(right);
            }
            i++;
        }

        return root;      
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));