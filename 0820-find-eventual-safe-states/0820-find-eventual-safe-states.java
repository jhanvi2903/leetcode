class Solution {
// DFS approach is more efficient as compared to BFS approach   
// DFS : using state array
//Nodes in a cycle cannot reach a terminal node, so they are not safe.
//A safe node always leads to a terminal node or other safe nodes.
//Detecting cycles helps us exclude unsafe nodes and find all safe ones.
// Conclusion: A node is a safe node if EVERY POSSIBLE PATH starting from that node leads to a terminal node
// Time complexity: O(V + E)
// Space complexity: O(V)
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int totalNodes = graph.length;
        int[] state = new int[totalNodes]; // 0: unvisited, 1: visiting, 2: safe
        List<Integer> safeNodes = new ArrayList<>();

        for (int i = 0; i < totalNodes; i++) {
            if (dfs(graph, i, state)) {
               safeNodes.add(i);
            }
        }

        return safeNodes;
    }

    private boolean dfs(int[][] graph, int node, int[] state) {
        // if 2 = Already safe, or else  1 = visited but not safe
        if(state[node] > 0) return state[node] == 2;

        state[node] = 1; // Marked visited

        for(int adjNode : graph[node]) {
            if(state[adjNode] == 1 || dfs(graph, adjNode, state) == false) return false; // Cycle detected
        }

        state[node] = 2; // Marked  safe
        return true;
    }
}