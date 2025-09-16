class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;

        int xor1 = 0;
        for(int i = 0; i <= nums.length; i++) {
            xor1 ^= i;
        }

        int xor2 = 0;
        for(int i = 0; i < n; i++) {
            xor2 ^= nums[i];
        }

        int missingNum = xor1 ^ xor2;

        return missingNum;       
    }
}