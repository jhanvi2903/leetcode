class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        Map<Integer, Integer> hm = new HashMap<>();
        hm.put(0,1);

        for(int num : nums) {
            sum = sum + num;
            int requiredPrevSum = sum - k;

            if(hm.containsKey(requiredPrevSum)) {
                count = count + hm.get(requiredPrevSum);
            }

            hm.put(sum, hm.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}