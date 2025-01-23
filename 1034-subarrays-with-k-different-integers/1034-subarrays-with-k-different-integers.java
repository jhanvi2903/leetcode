class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        int atMostK = totalSubarray(nums, k);
        int reducedAtMostK = totalSubarray(nums, k - 1);
        return  atMostK - reducedAtMostK;
    }

    private static int totalSubarray(int[] nums, int k) {
        int total = 0;
        int left = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();

        for(int right = 0; right < nums.length; right++) {
            hm.put(nums[right], hm.getOrDefault(nums[right], 0) + 1);

            while(hm.size() > k){
                 hm.put(nums[left], hm.getOrDefault(nums[left] , 0) - 1);

                 if(hm.get(nums[left]) == 0){
                    hm.remove(nums[left]);
                 }

                 left++;
            }

            total = total + (right - left + 1);
        }

        return total;
    }
}