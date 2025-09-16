class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;

        reverse(n - k, n - 1, nums);
        reverse(0, n - k - 1, nums);
        reverse(0, n - 1, nums);
        
    }

    private void reverse(int low, int high, int[] nums) {
        while(low < high) {
            int temp = nums[low];
            nums[low] = nums[high];
            nums[high] = temp;
            low++;
            high--;
        }
    }
}