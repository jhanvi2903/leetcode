class Solution {
   public List<List<String>> solveNQueens(int n) {
        List<List<String>> results = new ArrayList<>();
        char[][] board = new char[n][n];
        for (char[] row : board) Arrays.fill(row, '.');

        boolean[] usedRows = new boolean[n];
        boolean[] usedLeftDiagonal = new boolean[2 * n - 1];   // row - col + n - 1
        boolean[] usedRightDiagonal = new boolean[2 * n - 1];  // row + col

        placeQueens(0, n, board, usedRows, usedLeftDiagonal, usedRightDiagonal, results);
        return results;
    }

    private void placeQueens(int col, int n, char[][] board,
                             boolean[] usedRows,
                             boolean[] usedLeftDiagonal,
                             boolean[] usedRightDiagonal,
                             List<List<String>> results) {
        if (col == n) {
            results.add(constructBoard(board));
            return;
        }

        for (int row = 0; row < n; row++) {
            int leftDiagIndex = row - col + n - 1;
            int rightDiagIndex = row + col;

            if (usedRows[row] || usedLeftDiagonal[leftDiagIndex] || usedRightDiagonal[rightDiagIndex])
                continue;

            board[row][col] = 'Q';
            usedRows[row] = true;
            usedLeftDiagonal[leftDiagIndex] = true;
            usedRightDiagonal[rightDiagIndex] = true;

            placeQueens(col + 1, n, board, usedRows, usedLeftDiagonal, usedRightDiagonal, results);

            // Backtrack
            board[row][col] = '.';
            usedRows[row] = false;
            usedLeftDiagonal[leftDiagIndex] = false;
            usedRightDiagonal[rightDiagIndex] = false;
        }
    }

    private List<String> constructBoard(char[][] board) {
        List<String> list = new ArrayList<>();
        for (char[] row : board) {
            list.add(new String(row));
        }
        return list;
    }
}