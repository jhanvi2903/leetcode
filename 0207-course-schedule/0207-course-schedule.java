class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
       int[] indegree = new int[numCourses];
       List<List<Integer>> adj = new ArrayList<>();

       for(int i = 0; i < numCourses; i++) {
          adj.add(new ArrayList<>());
       }

       for(int[] prerequisite : prerequisites) {
           int u = prerequisite[0];
           int v = prerequisite[1];
           indegree[u]++;
           adj.get(v).add(u);
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

        return processedCourses == numCourses;
    }
}