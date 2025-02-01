class Solution {
    public int searchInsert(int[] nums, int target) {

     // Trick: Find the ceil of a target to insert
     int result = nums.length; // If the target is greater than the last element in array, insert at last position
     int low = 0;
     int high = nums.length-1;

     while(low <= high){
        int mid = (low+high)/2;

        if(nums[mid] == target){
            return mid;
        }else if(nums[mid] > target){
            result = mid; // save in ceil
            high = mid-1;
        }else {
            low = mid+1;
        }
     }
        

        return result;
    }
}