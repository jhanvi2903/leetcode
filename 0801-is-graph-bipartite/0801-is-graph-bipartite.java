class Solution {
    public boolean isBipartite(int[][] graph) {
      int rows = graph.length;
      int[] color = new int[graph.length]; // ~visited node array

    for(int i = 0; i < color.length; i++) {
        color[i] = -1;
    }

    // To traverse all the disconnected components of a graph
    for(int i = 0; i < graph.length; i++) {
        if(color[i] == -1) {
           if(dfs(color, graph, i, 0) == false) return false; // early return
        }
    }

    return true;
}

    private boolean dfs(int[] color, int[][] adj, int node, int col) {
        color[node] = col;

        for(int adjNode = 0; adjNode < adj[node].length; adjNode++) {
            int el = adj[node][adjNode];
            if(color[el] == -1) {
                if(dfs(color, adj, el, 1 - col) == false) return false; // early return
            } else if(color[el] == col){
                return false;
            }
        }

        return true;
    }
}