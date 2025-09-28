class Solution {
    public void rotate(int[][] matrix) {
        int length = matrix.length;


        for(int row = 0; row < length; row++) {
            for(int col = row + 1; col < length; col++) {
                int temp = matrix[row][col];
                matrix[row][col] = matrix[col][row];
                matrix[col][row] = temp;
            }
        }

        for(int row = 0; row < length; row++) {
            int low = 0;
            int high = length - 1;

            while(low < high) {
                int temp = matrix[row][low];
                matrix[row][low] = matrix[row][high];
                matrix[row][high] = temp;
                low++;
                high--;
            }
        }
        
    }
}