class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> hm = new HashMap<>();
        int duplicateNum = -1;
        int missingNum = -1;

        int total =  (n * (n + 1)) / 2;

        for(int i = 0; i < nums.length; i++) {
            hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);
        }

        int sum = 0;
        for(Map.Entry<Integer, Integer> uniqueNum: hm.entrySet()) {
            if(uniqueNum.getValue() >= 2) {
                duplicateNum = uniqueNum.getKey();
            }

            sum += uniqueNum.getKey();
        }

        missingNum = total - sum;

       return new int[]{duplicateNum, missingNum};     
    }
}