class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int majorityElement = -1;

        for(int i = 0; i < nums.length; i++) {
            hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);
        }

        for(Map.Entry<Integer, Integer> num : hm.entrySet()) {
            if(num.getValue() > (nums.length/2)) {
                majorityElement = num.getKey();
            }
        }

        return majorityElement;     
    }
}