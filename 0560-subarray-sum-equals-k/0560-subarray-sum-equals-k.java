class Solution {
    public int subarraySum(int[] nums, int k) {
       int count = 0;
       int prefixSum = 0;
       HashMap<Integer, Integer> hm = new HashMap<>();
       hm.put(0, 1);

       for(int i = 0; i < nums.length; i++){
          prefixSum = prefixSum + nums[i];
          int rem = prefixSum - k;

          if(hm.containsKey(rem)){
             count = count + hm.get(rem);
          } 

          hm.put(prefixSum, hm.getOrDefault(prefixSum, 0)+ 1);
       }

       return count;
    }
}