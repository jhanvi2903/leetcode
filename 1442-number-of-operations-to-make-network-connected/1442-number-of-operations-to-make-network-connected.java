// Using kruskal algorithm (Union By Size)
class Solution {
    public int makeConnected(int n, int[][] connections) {
      // To connect n computers, we need at least n-1 cables.
      // If we don't even have that many, it's impossible.
      // As long as there are at least (n - 1) connections, there is definitely a way to connect all computers.
       if (connections.length < n - 1) return -1;

       int[] parent = new int[n];
       for(int i = 0; i < parent.length; i++) {
          parent[i] = i; // Initially, each node is its own parent.
       }

       int[] size = new int[n];
       for(int i = 0; i < size.length; i++) {
            size[i] = 1;
       }

       int cntExtraEdge = 0; // Count of redundant (extra) edges that form a cycle
       for(int[] edge : connections) {
          int u = edge[0];
          int v = edge[1];

           // If both nodes have the same ultimate parent, it's a cycle (extra edge)
          if(ultimateParent(u, parent) == ultimateParent(v, parent)) {
             cntExtraEdge++; 
           }else {
             unionBySize(u, v, parent, size); // Otherwise, union the two components
          }
       }

       int totalComponents = 0; // Count how many disconnected components remain
       for(int i = 0; i < n; i++) {
           if(i == parent[i]) totalComponents++; // A node is a root if it's its own parent
       }

       // To connect all components, we need (components - 1) edges
       int minEdgesRequired = totalComponents - 1; 

       // If we have enough extra edges to connect all components, return the number needed
       if(cntExtraEdge >= minEdgesRequired) return minEdgesRequired;

       return -1;   // Otherwise, it's not possible to connect all components   
    }

    // Find function with path compression
    private int ultimateParent(int node, int[] parent) {
        if(node == parent[node]) return node;

        int u_p = ultimateParent(parent[node], parent);
        parent[node] = u_p;

        return parent[node];
    }

    // Union function using union by size optimization
    private void unionBySize(int u, int v, int[] parent, int[] size) {
        int u_p = ultimateParent(u, parent);
        int v_p = ultimateParent(v, parent);

        if(u_p == v_p) return; // No need to union if they already share the same parent

        // Attach smaller component under the larger one
        if(size[u_p] < size[v_p]) {
            parent[u_p] = v_p;
            size[v_p] = size[v_p] + size[u_p];
        } else {
            parent[v_p] = u_p;
            size[u_p] = size[u_p] + size[v_p];
        }
    }
}


// Time Complexity: O(n + m * α(n)) ≈ O(n + m), where:
    //   n = number of nodes
    //   m = number of connections
    //   α(n) is the inverse Ackermann function (nearly constant)

// Space Complexity: O(n), for parent[] and size[] arrays