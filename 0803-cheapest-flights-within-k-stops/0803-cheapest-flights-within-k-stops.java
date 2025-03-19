class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        Queue<int[]> q = new LinkedList<>();
        int[] minCost = new int[n];
        List<List<int[]>> adj = new ArrayList<>();

        for(int i = 0; i < minCost.length; i++) {
            minCost[i] = Integer.MAX_VALUE;
        }

        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] flight : flights) {
           adj.get(flight[0]).add(new int[] {flight[1], flight[2]});
        }

        q.offer(new int[] {0, src, 0}); // stops, city, cost
        minCost[src] = 0;

        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int stops = curr[0];
            int city = curr[1];
            int cost = curr[2];

            for(int[] adjCity : adj.get(city)) {
                int adjCityNeigbour = adjCity[0];
                int price = adjCity[1];
                if(stops <= k  && minCost[adjCityNeigbour] > cost + price) {
                    minCost[adjCityNeigbour] = cost + price;
                    q.offer(new int[] {stops + 1, adjCityNeigbour, cost + price});
                }
            }
        }


        return minCost[dst] == Integer.MAX_VALUE ? -1 : minCost[dst];
        
    }
}