class Solution {
    int[][] dir = {{1,0}, {0, 1}, {0, -1}, {-1, 0}};
    public int numIslands(char[][] grid) {
        int row = grid.length;
        int noOfIsland = 0;
        boolean[][] vis = new boolean[row][grid[0].length];

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == '1' && vis[i][j] == false) {
                   noOfIsland++;
                   dfs(vis, grid, i, j); 
                }
            }
        }

        return noOfIsland;
    }

    private void dfs(boolean[][] vis, char grid[][], int row, int col) {

        vis[row][col] = true;
       
        for(int[] d : dir){
           int x = row + d[0];
           int y = col + d[1];
           if(x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && vis[x][y] == false && grid[x][y] == '1') {
            vis[x][y] = true;
            dfs(vis, grid, x, y);
           }
        }

    }
}