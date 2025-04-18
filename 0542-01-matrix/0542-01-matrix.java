class Solution {
    // Using BFS:
    // Time complexity = O(row * col)
    // Space complexity = O(row * col)
    public int[][] updateMatrix(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;
        int[][] vis = new int[row][col]; // visited matrix
        int[][] dis = new int[row][col]; // distance matrix
        Queue<int[]> q = new LinkedList<>();

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(mat[i][j] == 0) {
                    q.add(new int[] {i, j, 0});
                    vis[i][j] = 1;
                }
            }
        }
      
      // Early return - if only 0's are present, it will decrease the execution time
       if(q.size() == row * col) return mat;

       int[][] directions = {{1,0}, {-1, 0}, {0, 1}, {0, -1}};
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int i = curr[0];
            int j = curr[1];
            int d = curr[2];
            dis[i][j] = d; //Add distance in distance matrix

            for(int[] dir : directions) {
                int x = i + dir[0];
                int y = j + dir[1];
                //Add in queue if the cell is not out of bound & never visited
                if(x >= 0 && x < row && y >= 0 && y < col && vis[x][y] != 1) {
                  q.add(new int[]{x, y, d + 1});
                  vis[x][y] = 1;
                }
            }
        }

        return dis;
    }
}