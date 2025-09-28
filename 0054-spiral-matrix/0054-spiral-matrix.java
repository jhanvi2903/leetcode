class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        int topRow = 0;
        int bottomRow = matrix.length - 1;
        int leftCol = 0;
        int rightCol = matrix[0].length - 1;

        while(topRow <= bottomRow && leftCol <= rightCol) {
            for(int i = leftCol; i <= rightCol; i++) {
                result.add(matrix[topRow][i]);
            }

            topRow++;

            for(int i = topRow; i <= bottomRow; i++) {
                result.add(matrix[i][rightCol]);
            }

            rightCol--;

            if(topRow <= bottomRow) {
                for(int i = rightCol; i >= leftCol; i--) {
                result.add(matrix[bottomRow][i]);
            }

            bottomRow--;
            }
            

            if(leftCol <= rightCol) {
                for(int i = bottomRow; i >= topRow; i--) {
                result.add(matrix[i][leftCol]);
            }

            leftCol++;
            }
            
        }

        return result;
        
    }
}