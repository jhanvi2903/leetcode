class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Needed: Firstly to identify source node and then to process all the incoming edges from other nodes 
       int[] indegree = new int[numCourses];

       List<List<Integer>> adj = new ArrayList<>();

       for(int i = 0; i < numCourses; i++) {
          adj.add(new ArrayList<>());
       }

       for(int[] prerequisite : prerequisites) {
           int v = prerequisite[0];
           int u = prerequisite[1];
           indegree[v]++; // Adding indegree as there is an edge from u to v
           adj.get(u).add(v);
       }

       // Source node with the indegree 0 should be added in the Queue first
        Queue<Integer> q = new LinkedList<>(); 
        for(int i = 0; i < indegree.length; i++) {
            if(indegree[i] == 0) {
                q.offer(i);
            }
        }

        int finishedCourses = 0;
        int[] resultCourseOrder = new int[numCourses]; // course order
        int i = 0;
        while(!q.isEmpty()) {
            int course = q.poll();
            resultCourseOrder[i++] = course;
            finishedCourses++; // processed courses

            for(int nextAdjCourse : adj.get(course)) {
                indegree[nextAdjCourse]--;

                //Once all the incoming edges has been processed, add in queue  
                if(indegree[nextAdjCourse] == 0) {
                    q.add(nextAdjCourse);
                }
            }   
        }

        // If all courses are finished, return order else return empty array
        return finishedCourses == numCourses ? resultCourseOrder : new int[0];
    }
}