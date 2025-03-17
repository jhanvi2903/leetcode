class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        
        // Early return - no clear path
        if(grid[0][0] != 0 || grid[grid.length - 1][grid[0].length - 1] != 0) return -1;

        Queue<int[]> q = new LinkedList<>();

        // visited array - Avoids revisiting, Prevents infinite loops, Ensures correctness:
        boolean[][] vis = new boolean[grid.length][grid[0].length];

        q.offer(new int[] {0, 0, 1});
        vis[0][0] = true;

        // To move in 8 directions
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {-1, -1}, {-1, 1}, {1, -1}};
        
        while(!q.isEmpty()) {
            int[] cell = q.poll();

            int row = cell[0];
            int col = cell[1];
            int len = cell[2];

            // Return, once we reach last cell
            if(row == grid.length - 1 && col == grid[0].length - 1) return len;

            for(int[] dir : directions) {
               int x = row + dir[0];
               int y = col + dir[1];

               if(x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && !vis[x][y] && grid[x][y] == 0) {
               q.offer(new int[] {x, y, len + 1});
                 vis[x][y] = true; 
               }
            }

        }
        
        // If the last cell was never reached, return -1 stating no clear path 
        return -1;
    }
}