class Solution {
    public boolean check(int[] nums) {
        int breakCount = 0;

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > nums[(i + 1) % nums.length]) breakCount++;
        }

     return breakCount <= 1 ? true : false;    
    }
}