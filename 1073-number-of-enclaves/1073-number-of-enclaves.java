class Solution {
    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int numEnclaves(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] vis = new int[row][col];
        int countEnclosedOnes = 0;

       // Traverse 1st col & last col
        for(int i = 0; i < row; i++) {
            if(grid[i][0] == 1 && vis[i][0] != 1) {
              dfs(grid, vis, i, 0);
            }

            if(grid[i][col - 1] == 1 && vis[i][col-1] != 1){
             dfs(grid, vis, i, col-1);
            }
        }

        // Traverse 1st row & last row
        for(int j = 0; j < col; j++) {
            if(grid[0][j] == 1 && vis[0][j] != 1) {
                dfs(grid, vis, 0, j);
            }

            if(grid[row-1][j] == 1 && vis[row-1][j] != 1) {
                dfs(grid, vis, row-1, j);
            }
        }

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++){
                if(vis[i][j] != 1 && grid[i][j] == 1){
                    countEnclosedOnes++;
                }
            }
        }

       return countEnclosedOnes;
    }

    private void dfs(int[][] grid, int[][] vis, int row, int col) {
        vis[row][col] = 1;

        for(int[] dir : directions) {
            int i = row + dir[0];
            int j = col + dir[1];

            if(i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == 1 && vis[i][j] != 1) {
                dfs(grid, vis, i, j);
            }
        }
    }
}