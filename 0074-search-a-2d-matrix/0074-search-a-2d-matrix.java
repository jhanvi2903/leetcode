class Solution {

    public static boolean binary(int[] matrix, int target){
         
         int low = 0;
         int high = matrix.length-1;

         while(low <= high){
            int mid = (low+high)/2;

            if(matrix[mid] == target){
                return true;
            }else if(matrix[mid] > target ){
                high = mid-1; // Move left
            }else{
                low = mid+1; // Move right
            }

         }

         return false;
    }

    public boolean searchMatrix(int[][] matrix, int target) {

        
        for(int i = 0; i <= matrix.length-1; i++){
            if(matrix[i][0] <= target && target <= matrix[i][matrix[0].length-1]){
                return binary(matrix[i],target);
            }
        }

        return false;
    }
}