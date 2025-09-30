class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int breakPointIndex = -1;

        for(int i = n - 2; i >= 0; i--) {
            if(nums[i] < nums[i + 1]) {
                breakPointIndex = i;
                break;
            }
        }

        if(breakPointIndex == - 1) {
            reverse(0, n - 1, nums);
            return;
        }

        
        if(breakPointIndex >= 0) {
            int j = n - 1;
            while(nums[j] <= nums[breakPointIndex]) {
                j--;
            }
            swap(breakPointIndex, j, nums);  
            reverse(breakPointIndex + 1, n - 1, nums);
        }    
    }

    private void swap(int left, int right, int[] nums) { 
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    private void reverse(int left, int right, int nums[]) {
        while(left < right) {
            swap(left, right, nums);
            left++;
            right--;
        }

    }
}