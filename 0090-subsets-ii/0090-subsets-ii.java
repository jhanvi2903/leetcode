class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        Arrays.sort(nums);
        helper(nums, result, subset, 0);
        return result;
    }

    private void helper(int[] nums, List<List<Integer>> result, List<Integer> subset, int index) {
        result.add(new ArrayList<>(subset));
        for(int i = index; i < nums.length; i++) {
            if(i > index && nums[i] == nums[i-1]) continue;

            subset.add(nums[i]);
            helper(nums, result, subset, i + 1);
            subset.remove(subset.size() - 1);
        }

    }
}