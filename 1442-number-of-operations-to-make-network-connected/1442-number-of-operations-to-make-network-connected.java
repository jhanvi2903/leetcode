class Solution {
    public int makeConnected(int n, int[][] connections) {
       // Using kruskal algorithm
       int cntExtraEdge = 0;
       int[] parent = new int[n];
       for(int i = 0; i < parent.length; i++) {
          parent[i] = i;
       }

       int[] size = new int[n];
       for(int i = 0; i < size.length; i++) {
            size[i] = 1;
       }

       for(int[] edge : connections) {
          int u = edge[0];
          int v = edge[1];

          if(ultimateParent(u, parent) == ultimateParent(v, parent)) {
             cntExtraEdge++; 
           }else {
             unionBySize(u, v, parent, size);
          }
       }

       int totalComponents = 0;
       for(int i = 0; i < n; i++) {
           if(i == parent[i]) totalComponents++;
       }

       int minEdgesRequired = totalComponents - 1;
       if(cntExtraEdge >= minEdgesRequired) return minEdgesRequired;

       return -1;      
    }

    private int ultimateParent(int node, int[] parent) {
        if(node == parent[node]) return node;

        int u_p = ultimateParent(parent[node], parent);
        parent[node] = u_p;

        return parent[node];
    }

    private void unionBySize(int u, int v, int[] parent, int[] size) {
        int u_p = ultimateParent(u, parent);
        int v_p = ultimateParent(v, parent);

        if(u_p == v_p) return;
        if(size[u_p] < size[v_p]) {
            parent[u_p] = v_p;
            size[v_p] = size[v_p] + size[u_p];
        } else {
            parent[v_p] = u_p;
            size[u_p] = size[u_p] + size[v_p];
        }
    }
}