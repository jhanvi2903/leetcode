class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxOnesCount = 0;

        int count = 0;
        for(int num : nums) {
            if(num == 1) {
               count++;
               maxOnesCount = Math.max(maxOnesCount, count);
            } else {
                count = 0;
            }
        } 

        return maxOnesCount;
    }
}