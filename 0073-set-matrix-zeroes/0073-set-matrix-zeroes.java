class Solution {
    public void setZeroes(int[][] matrix) {
        int rowLength = matrix.length;
        int colLength = matrix[0].length;


        boolean[] zerorows = new boolean[rowLength];
        boolean[] zerocols = new boolean[colLength];

        for(int row = 0; row < rowLength; row++) {
            for(int col = 0; col < colLength; col++) {
                if(matrix[row][col] == 0) {
                    zerorows[row] = true;
                    zerocols[col] = true;
                }
            }
        }

        for(int row = 0; row < zerorows.length; row++) {
            if(zerorows[row] == true) {
                for(int col = 0 ; col < colLength; col++) {
                    matrix[row][col] = 0;
                }
            }
        }

         for(int col = 0; col < zerocols.length; col ++) {
            if(zerocols[col] == true) {
                for(int row = 0 ; row < rowLength; row++) {
                    matrix[row][col] = 0;
                }
            }
        }
        
    }
}