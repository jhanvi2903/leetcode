class Solution {
    public void setZeroes(int[][] matrix) {
        int rowLength = matrix.length;
        int colLength = matrix[0].length;

        boolean[] zeroRows = new boolean[rowLength];
        boolean[] zeroCols = new boolean[colLength];

        for(int row = 0; row < rowLength; row++) {
            for(int col = 0; col < colLength; col++) {
                if(matrix[row][col] == 0) {
                    zeroRows[row] = true;
                    zeroCols[col] = true;
                }
            }
        }

        for(int row = 0; row < zeroRows.length; row++) {
            if(zeroRows[row]) {
                for(int col = 0 ; col < colLength; col++) {
                    matrix[row][col] = 0;
                }
            }
        }

         for(int col = 0; col < zeroCols.length; col ++) {
            if(zeroCols[col]) {
                for(int row = 0 ; row < rowLength; row++) {
                    matrix[row][col] = 0;
                }
            }
        }
        
    }
}