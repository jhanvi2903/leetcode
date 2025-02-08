class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<List<Integer>> adj = new ArrayList<>();
         int[] indegree = new int[graph.length];

        for(int i = 0; i < graph.length; i++) {
            adj.add(new ArrayList<>());
        }
        
        for(int i = 0; i < graph.length; i++) {
            for(int j = 0; j < graph[i].length; j++) {
                adj.get(graph[i][j]).add(i);
                indegree[i]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < indegree.length; i++) {
            if(indegree[i] == 0) q.offer(i);
        }


       List<Integer> result = new ArrayList<>();
        while(!q.isEmpty()) {
            int node = q.poll();
            result.add(node);

            for(int adjNode : adj.get(node)){
                indegree[adjNode]--;
                if(indegree[adjNode] == 0) q.offer(adjNode);
            }
        }

        Collections.sort(result);

        return result;
    }
}