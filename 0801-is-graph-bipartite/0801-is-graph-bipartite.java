class Solution {
    public boolean isBipartite(int[][] graph) {
      int rows = graph.length;
      ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
      int[] color = new int[graph.length];

    for(int i = 0; i < rows; i++) {
        adj.add(new ArrayList<>());
    }
      
    for(int i = 0; i < rows; i++){
        for(int j = 0; j < graph[i].length; j++) {
            adj.get(i).add(graph[i][j]);
        }
      }
    

    for(int i = 0; i < color.length; i++) {
        color[i] = -1;
    }

    for(int i = 0; i < adj.size(); i++) {
        if(color[i] == -1) {
           if(dfs(color, adj, i, 0) == false) return false;
        }
    }

    return true;
}

    private boolean dfs(int[] color, ArrayList<ArrayList<Integer>> adj, int node, int col) {
        color[node] = col;

        for(int adjNode : adj.get(node)) {
            if(color[adjNode] == -1) {
                if(dfs(color, adj, adjNode, 1 - col) == false) return false;
            } else if(color[adjNode] == col){
                return false;
            }
        }

        return true;
    }
}