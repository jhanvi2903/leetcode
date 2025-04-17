class Solution {
    public int orangesRotting(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int countFreshOrange = 0;

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == 2) {
                    q.offer(new int[] {i, j});
                }

                if(grid[i][j] == 1) {
                    countFreshOrange++;
                }
            }
        }

        if(countFreshOrange == 0) return 0; // No fresh orange

        if(q.isEmpty()) return -1; // It means there are no rotten range

        int min = -1;
        int[][] directions = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
        while(!q.isEmpty()) {
            int size = q.size();
            for(int k = 0; k < size; k++){
                int[] curr = q.poll();
                int x = curr[0];
                int y = curr[1];
                for(int[] dir : directions) {
                    int i = x + dir[0];
                    int j = y + dir[1];

                    if(i >= 0 && i < row  && j >= 0 && j < col && grid[i][j] == 1) {
                        grid[i][j] = 2;
                        countFreshOrange--;
                        q.offer(new int[] {i , j});
                    }
                }
            }
             min++;
        }

        if(countFreshOrange == 0) return min;

        return -1;
    }
}