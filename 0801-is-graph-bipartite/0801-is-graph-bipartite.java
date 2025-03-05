class Solution {
    public boolean isBipartite(int[][] graph) {
      int rows = graph.length;
    //   ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
      int[] color = new int[graph.length];

    // for(int i = 0; i < rows; i++) {
    //     adj.add(new ArrayList<>());
    // }
      
    // for(int i = 0; i < rows; i++){
    //     for(int j = 0; j < graph[i].length; j++) {
    //         adj.get(i).add(graph[i][j]);
    //     }
    //   }
    

    for(int i = 0; i < color.length; i++) {
        color[i] = -1;
    }

    for(int i = 0; i < graph.length; i++) {
        if(color[i] == -1) {
           if(dfs(color, graph, i, 0) == false) return false;
        }
    }

    return true;
}

    private boolean dfs(int[] color, int[][] adj, int node, int col) {
        color[node] = col;

        for(int adjNode = 0; adjNode < adj[node].length; adjNode++) {
            int el = adj[node][adjNode];
            if(color[el] == -1) {
                if(dfs(color, adj, el, 1 - col) == false) return false;
            } else if(color[el] == col){
                return false;
            }
        }

        return true;
    }
}