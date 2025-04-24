//Time Complexity: O(E log V)
//Space Complexity: O(V + E)

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        
        // min heap, sorting based on the minimum time
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]); 
        int[] minTime = new int[n+1]; // To return max time among all
        List<List<int[]>> adj = new ArrayList<>();

        for(int i = 1; i < n+1; i++) {
            minTime[i] = Integer.MAX_VALUE;
        }

        for(int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] time : times) {
            adj.get(time[0]).add(new int[] {time[1], time[2]});
        }
 
        pq.offer(new int[] {0, k});

        minTime[k] = 0;

        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            int node = curr[1];
            int time = curr[0];

            for(int[] adjNode : adj.get(node)) {
                int des = adjNode[0];
                int adjTime = adjNode[1];
                if(minTime[des] > time + adjTime){
                    minTime[des] = time + adjTime;
                    pq.offer(new int[] {time + adjTime, des});
                }
            }
        }

        int time = -1;
        for(int i = 1; i < minTime.length; i++){
            time = Math.max(time, minTime[i]); // To return max time among all
        }

        if(time == Integer.MAX_VALUE) {
            time = -1;
        }

        return time;
    }
}