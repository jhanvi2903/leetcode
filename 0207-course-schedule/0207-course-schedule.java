class Solution {
    // Topological Sort✨ Solution with\U0001f9e9Kahn’s Algorithm \U0001f4da(BFS)
    //We need to figure out if we can complete all courses \U0001f393 by checking the prerequisites \U0001f517. If there’s a cycle \U0001f504 in the dependency graph, it’s impossible \U0001f6ab to finish all courses. However, if the graph is a DAG ✅ (Directed Acyclic Graph), we can complete all the courses.

// Time complexity: O(V + E)
// Space complexity: O(V + E)
    public boolean canFinish(int numCourses, int[][] prerequisites) {
       int[] indegree = new int[numCourses];
       List<List<Integer>> adj = new ArrayList<>();

       for(int i = 0; i < numCourses; i++) {
          adj.add(new ArrayList<>());
       }

       for(int[] prerequisite : prerequisites) {
           int v = prerequisite[0];
           int u = prerequisite[1];
           indegree[v]++; // Adding indegree of the first node in array as there is an edge from v to u
           adj.get(u).add(v);
       }

        Queue<Integer> q = new LinkedList<>(); 
        for(int i = 0; i < indegree.length; i++) {
            if(indegree[i] == 0) {
                q.offer(i);
            }
        }

        int processedCourses = 0;
        while(!q.isEmpty()) {
            int course = q.poll();
            processedCourses++;

            for(int nextAdjCourse : adj.get(course)) {
                indegree[nextAdjCourse]--;
                if(indegree[nextAdjCourse] == 0) {
                    q.add(nextAdjCourse);
                }
            }   
        }

        // If all the nodes are processed, therefore no cycle exist
        // If all the nodes are not processed, so cycle exist
        return processedCourses == numCourses;
    }
}