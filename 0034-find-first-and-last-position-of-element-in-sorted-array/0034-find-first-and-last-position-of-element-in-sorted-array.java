class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        int left = binarySearch(nums, target, true);
        int right = binarySearch(nums, target, false);
        result[0] = left;
        result[1] = right;
        return result;        
    }

    public int binarySearch(int[] nums, int target, boolean isSearchingLeft) {
        int left = 0;
        int right = nums.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] > target) {
                right = mid - 1; // Move left
            } else if (nums[mid] < target) {
                left = mid + 1; // Move right
            } else {
                result = mid;
                if (isSearchingLeft) {
                    right = mid - 1; // Go to left portion to find first occurrence: Goal is to move to the extreme left
                } else {
                    left = mid + 1; // Go to right portion to find the last occurrence: Goal is to move to the extreme right
                }
            }
        }

        return result;
    }

}