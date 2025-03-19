class Solution {
    public int minimumEffortPath(int[][] heights) {
        int[][] dis = new int[heights.length][heights[0].length]; // to store minimum effort
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]); // min heap distance

        for(int i = 0; i < dis.length; i++) {
            for(int j = 0; j < dis[0].length; j++) {
                dis[i][j] = Integer.MAX_VALUE;
            }
        }

        pq.offer(new int[] {0, 0, 0}); // distance,row, col
        dis[0][0] = 0;

        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while(!pq.isEmpty()) {
            int[] pair = pq.poll();
            int d = pair[0];
            int row = pair[1];
            int col = pair[2];

            if (d > dis[row][col]) continue;

            if (row == dis.length - 1 && col == dis[0].length - 1) return d;

            for(int[] dir : directions) {
                int r = row + dir[0];
                int c = col + dir[1];

                if(r >= 0 && r < heights.length && c >= 0 && c < heights[0].length) {
                    // To consider maximum distance in path
                    // select maximum distance in path till now by comparing previous cell distance and the current cell distance = prev cell - curr cell
                    int difference = Math.max(Math.abs(heights[r][c] - heights[row][col]), d);
                    if(dis[r][c] > difference) {
                        dis[r][c] = difference;
                        pq.offer(new int[] {difference,r, c});
                    }
                }
            }
        }

        return -1;
    }
}
