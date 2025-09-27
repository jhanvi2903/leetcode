class Solution {
    public void rotate(int[][] matrix) {
        int[][] mat = new int[matrix.length][matrix[0].length];


        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                mat[j][matrix.length - i - 1] = matrix[i][j];
            }
        }

        for(int i = 0; i < mat.length; i++) {
            for(int j = 0; j < mat[0].length; j++) {
                matrix[i][j] = mat[i][j];
            }
        }
        
    }
}