class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();

        for(int num : nums) {
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        }

        for(Map.Entry<Integer, Integer> num : hm.entrySet()) {
            if(num.getValue() == 1) {
                result = num.getKey();
            }
        }

        return result;    
    }
}