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

        q.offer(new int[] {0, src}); // cost, city
        minCost[src] = 0;

        int stops = 0;

        while(!q.isEmpty() && stops <= k ) {
          int size = q.size();

           while(size -- > 0){ 
            int[] curr = q.poll();
            int cost = curr[0];
            int city = curr[1];
            for(int[] adjCity : adj.get(city)) {
                int adjCityNeigbour = adjCity[0];
                int price = adjCity[1];
                int costAdjCity = cost + price;
                if(minCost[adjCityNeigbour] > costAdjCity) {
                    minCost[adjCityNeigbour] = costAdjCity;
                    System.out.println(costAdjCity);
                    q.offer(new int[] {costAdjCity, adjCityNeigbour});
                }
            }
           }

            stops++;
        }

        return minCost[dst] == Integer.MAX_VALUE ? -1 : minCost[dst];    
    }
}