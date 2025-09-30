class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int index = -1;

        for(int i = n - 2; i >= 0; i--) {
            if(nums[i] < nums[i + 1]) {
                index = i;
                break;
            }
        }

        if(index == - 1) {
            reverse(0, n - 1, nums);
            return;
        }

        
        int j = n - 1;
        while(nums[j] <= nums[index]) {
            j--;
        }

        swap(index, j, nums);  
        reverse(index + 1, n - 1, nums);
    }

    private void swap(int low, int high, int[] nums) { 
        int temp = nums[low];
        nums[low] = nums[high];
        nums[high] = temp;
    }

    private void reverse(int low, int high, int nums[]) {
        while(low < high) {
            swap(low, high, nums);
            low++;
            high--;
        }

    }
}