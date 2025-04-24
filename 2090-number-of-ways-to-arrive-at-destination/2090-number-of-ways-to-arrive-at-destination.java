//Time Complexity: O(E log V)
//Space Complexity: O(V + E)
class Solution {
    public int countPaths(int n, int[][] roads) {

        List<List<int[]>> adj = new ArrayList<>();
        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[0] , b[0]));
        long[] minDis = new long[n];
        int[] paths = new int[n];

        for(int i = 0; i < minDis.length; i++) {
            minDis[i] = Long.MAX_VALUE;
        }

        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] road : roads) {
            int u = road[0];
            int v = road[1];
            int dis = road[2];
            adj.get(u).add(new int[] {v, dis});
            adj.get(v).add(new int[] {u, dis});
        }

        pq.offer(new long[] {0, 0});
        minDis[0] = 0;
        paths[0] = 1;
        while(!pq.isEmpty()) {
            long[] curr = pq.poll();
            long d = curr[0];
            long node = curr[1];

          
            for(int[] adjNodes : adj.get((int)node)) {
                int adjNode = adjNodes[0];
                int adjDis = adjNodes[1];
                if(minDis[(int)adjNode] > d + adjDis) {
                    minDis[(int)adjNode] = d + adjDis;
                    pq.offer(new long[] {d + adjDis, adjNode});
                    paths[(int)adjNode] = paths[(int)node];
                }else if(minDis[adjNode] == d + adjDis) {
                    paths[(int)adjNode] = (paths[(int)adjNode] + paths[(int)node])% ((int) 1e9 + 7) ;
                }
            }
        }
        

        return paths[n-1]% ((int) 1e9 + 7);
    }
}