class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
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
        int[] result = new int[numCourses];
        int i = 0;
        while(!q.isEmpty()) {
            int course = q.poll();
            result[i++] = course;
            processedCourses++;

            for(int nextAdjCourse : adj.get(course)) {
                indegree[nextAdjCourse]--;
                if(indegree[nextAdjCourse] == 0) {
                    q.add(nextAdjCourse);
                }
            }   
        }

        if(processedCourses != numCourses) {
            return new int[0];
        }

       
        return result;
    }
}