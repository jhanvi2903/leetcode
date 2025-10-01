class Solution {
    public int longestOnes(int[] nums, int k) {
       int maxLength = 0;
       int left = 0;
       int countZeros = 0;

       for(int right = 0; right < nums.length; right++) {
        if(nums[right] == 0) countZeros++;

        while(countZeros > k) {
            if(nums[left] == 0) {
                countZeros--;
            }
            left++;
        }

        maxLength = Math.max(maxLength, right - left + 1);
       } 

       return maxLength;
    }
}