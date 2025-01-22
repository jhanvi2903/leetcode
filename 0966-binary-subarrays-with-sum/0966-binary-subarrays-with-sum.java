class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {

        HashMap<Integer, Integer> hm = new HashMap<>();
        int subarrayCount = 0;
        int prefixSum = 0;

        hm.put(0, 1);

        for(int i = 0; i < nums.length; i++){
            prefixSum = prefixSum + nums[i];

            int rem = prefixSum - goal;

            if(hm.containsKey(rem)){
                subarrayCount = subarrayCount + hm.get(rem);
            }

            hm.put(prefixSum, hm.getOrDefault(prefixSum, 0) + 1);
        }

       return subarrayCount;
    }
}