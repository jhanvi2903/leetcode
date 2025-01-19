class Solution {
    public int longestOnes(int[] nums, int k) {
        int countZero = 0;
        int maxLen = 0;
        int left = 0;

        // Sliding Window + 2 Pointer
        for(int right = 0; right < nums.length; right++){
            if(nums[right] == 0){
                countZero++;
            }

            if(countZero <= k){
                maxLen = Math.max(maxLen, right - left + 1);
            } else {
                if(nums[left] == 0) countZero--;
                    left ++;
            }
        }

       return maxLen;
    }
}