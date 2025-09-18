class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int result = Integer.MAX_VALUE;
        Arrays.sort(nums);

        for(int i = 0; i < nums.length; i++) {

            int left = i + 1;
            int right = nums.length - 1;

            while(left < right) {
                int currSum = nums[i] + nums[left] + nums[right];

                if(Math.abs(target - currSum) < Math.abs(target - result)) {
                    result = currSum;
                }
               
                if(currSum > target) {
                    right--;
                } else if(currSum < target){
                    left++;
                } else {
                    return result;
                }
            }
        }

       return result;        
    }
}