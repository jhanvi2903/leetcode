class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();

        Arrays.sort(candidates);
        helper(candidates, target, subset, result, 0, 0);
        return result;
    }

    private void helper(int[] candidates, int target,  List<Integer> subset, List<List<Integer>> result, int index, int sum) {

        if(target == sum) {
            result.add(new ArrayList<>(subset));  
        }         

        for(int i = index; i < candidates.length; i++) {
            if(i > index && candidates[i] == candidates[i-1]) continue;
            if(target < sum) break;


            subset.add(candidates[i]);
            helper(candidates, target, subset, result, i + 1, sum + candidates[i]);

            subset.remove(subset.size() - 1);
        }
        
    
    }
}