class Solution {
    public int longestOnes(int[] nums, int k) {
        int countZero = 0;
        int maxLen = 0;
        int left = 0;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                countZero++;
            }

            if(countZero <= k){
                maxLen = Math.max(maxLen, i - left + 1);
            } else {
                if(nums[left] == 0) countZero--;
                    left ++;
            }
        }

       return maxLen;
    }
}