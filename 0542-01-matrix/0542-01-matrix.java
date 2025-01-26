class Solution {
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

       int[][] directions = {{1,0}, {-1, 0}, {0, 1}, {0, -1}};
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int i = curr[0];
            int j = curr[1];
            int d = curr[2];
            dis[i][j] = d; 

            for(int[] dir : directions) {
                int x = i + dir[0];
                int y = j + dir[1];
                if(x >= 0 && x < row && y >= 0 && y < col && mat[x][y] == 1 && vis[x][y] != 1) {
                  q.add(new int[]{x, y, d + mat[x][y]});
                  vis[x][y] = 1;
                }
            }
        }

        return dis;
    }
}