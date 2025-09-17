class Solution {
    public int[] singleNumber(int[] nums) {
        int[] result = new int[2];
        HashMap<Integer, Integer> hm = new HashMap<>();

        for(int num : nums) {
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        }

        int index = 0; 
        for(Map.Entry<Integer, Integer> num : hm.entrySet()) {
            if(num.getValue() == 1) {
                result[index++] = num.getKey();
            }
        }

        return result;    
    }
}