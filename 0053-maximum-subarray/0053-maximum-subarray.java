class Solution {
    public int maxSubArray(int[] nums) {

        int max = nums[0];
        int sum = nums[0];

        for(int i = 1; i < nums.length; i++){
            //Check the single number & the same number added to sum
             sum = Math.max(sum + nums[i], nums[i]); 

             //Check the new sum and the previous sum stored in max
             max = Math.max(max, sum); 
        }

        return max;
        
    }
}
