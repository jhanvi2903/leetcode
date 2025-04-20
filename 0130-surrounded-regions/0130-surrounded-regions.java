class Solution {
    public void solve(char[][] board) {

        if (board.length == 0 || board[0].length == 0 || board.length < 2 || board[0].length < 2) return;

        
        int row = board.length;
        int col = board[0].length;
        int[][] vis = new int[row][col]; // visited array
    

        for(int j = 0; j < row; j++) {
             if(board[j][0] == 'O'){ // 1st column
                dfs(board, vis, j, 0);
            }

           if(board[j][col-1] == 'O') { // last column
                dfs(board, vis, j, col-1);
            }
        }

        
        for(int i = 0; i < col; i++) {
            if(board[0][i] == 'O') { // 1st row
              dfs(board,vis, 0, i);  
            }

            if(board[row-1][i] == 'O') { // last row
                dfs(board,vis,row-1, i);
            }
        }
         
        for(int i = 0; i < vis.length; i++){
            for(int j = 0; j < vis[0].length; j++){
                if(vis[i][j] != 1 && board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }

    }

    public void dfs(char[][] board, int[][] vis, int row, int col) {
        vis[row][col] = 1; // Mark visited

        int[][] dirs = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
        for (int[] dir: dirs) {
            int i = dir[0] + row;
            int j = dir[1] + col;
            
            // Move in 4 directions to mark 'O' as visited
            if (i >= 0 && i < board.length && j >=0 && j < board[0].length && board[i][j] == 'O' && vis[i][j] != 1) {
                dfs(board, vis, i, j);
            }
        }
    }
}