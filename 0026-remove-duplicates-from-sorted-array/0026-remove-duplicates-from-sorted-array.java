class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0; // To track Unique elements

        // j : To find Unique elements
        for(int j = 1; j < nums.length; j++) {
            if(nums[i] != nums[j]) {
                nums[i + 1] = nums[j];
                i++;
            } 
        }
        
        return i + 1;
    }
}