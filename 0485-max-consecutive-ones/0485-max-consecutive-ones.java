class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxOnesCount = 0;

        int count = 0;
        for(int num : nums) {
            if(num == 1) {
               count++;
            } else {
                maxOnesCount = Math.max(maxOnesCount, count);
                count = 0;
            }
        } 

        maxOnesCount = Math.max(maxOnesCount, count);

        return maxOnesCount;
    }
}