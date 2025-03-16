class Solution {
    // Using BFS - outdegree array & incoming edge adj list
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<List<Integer>> adj = new ArrayList<>();
         int[] outdegree = new int[graph.length];

        for(int i = 0; i < graph.length; i++) {
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < graph.length; i++) {
            for(int j = 0; j < graph[i].length; j++) {
                outdegree[i]++; // total outdegree edges
            }
        }

        
        for(int i = 0; i < graph.length; i++) {
            for(int j = 0; j < graph[i].length; j++) {
                adj.get(graph[i][j]).add(i); // incoming edges nodes
               
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < outdegree.length; i++) {
            if(outdegree[i] == 0) q.offer(i);
        }

       // Processing all the adjacent nodes of the terminal node
       // If the adjacent node has only one edge to the terminal node, then it will be added to queue
       List<Integer> result = new ArrayList<>();
        while(!q.isEmpty()) {
            int safeNode = q.poll();
            result.add(safeNode);

            for(int adjNode : adj.get(safeNode)){
                outdegree[adjNode]--;
                if(outdegree[adjNode] == 0) q.offer(adjNode);
            }
        }

        Collections.sort(result);

        return result;
    }
}