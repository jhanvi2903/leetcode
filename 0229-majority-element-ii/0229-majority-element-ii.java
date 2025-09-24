class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int count1 = 0;
        int count2 = 0;
        int candidate1 = Integer.MIN_VALUE;
        int candidate2 = Integer.MIN_VALUE;  
        List<Integer> result = new ArrayList<>();

        for(int i = 0; i < nums.length; i++) {
            if(count1 == 0 && nums[i] != candidate2) {
                count1 = 1;
                candidate1 = nums[i]; 
            }else if(count2 == 0 && nums[i] != candidate1) {
                count2 = 1;
                candidate2 = nums[i];
            }else if(nums[i] == candidate1) {
                count1++;
            }else if(nums[i] == candidate2) {
                count2++;
            }else {
                count1--;
                count2--;
            }
        }

        int countcheck1 = 0;
        int countcheck2 = 0;

        for(int i = 0; i < nums.length; i++) {
            if(candidate1 == nums[i]) countcheck1++;
            if(candidate2 == nums[i]) countcheck2++;
        }

        if(countcheck1 > (nums.length / 3)) result.add(candidate1);
        if(countcheck2 > (nums.length / 3)) result.add(candidate2);

        return result;    
    }
}