class Solution {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        List<Integer> majorityElement = new ArrayList<>();

        for(int i = 0; i < nums.length; i++) {
            hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);
        }

        for(Map.Entry<Integer, Integer> num : hm.entrySet()) {
            if(num.getValue() > (nums.length/3)) {
                majorityElement.add(num.getKey());
            }
        }

        return majorityElement; 
        
    }
}