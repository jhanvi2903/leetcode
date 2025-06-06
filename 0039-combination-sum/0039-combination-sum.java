class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();

        helper(candidates, target, subset, result, 0, 0);
        return result;
    }

    private void helper(int[] candidates, int target,  List<Integer> subset, List<List<Integer>> result, int index, int sum) {
        if(target == sum) {
            result.add(new ArrayList<>(subset));
            return;
        }

        if(sum > target || index >= candidates.length) {
            return;
        }

        subset.add(candidates[index]);
        helper(candidates, target, subset, result, index, sum + candidates[index]);

        subset.remove(subset.size() - 1);
        helper(candidates, target, subset, result, index + 1, sum);
    }
}