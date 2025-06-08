class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();

        helper(k, n, subset, result, 0,0, 1, 9);
        return result;      
    }

    private void helper(int limit, int target, List<Integer> subset, List<List<Integer>> result, int count, int sum, int start, int end) {
        if(count == limit) {
            if(sum == target) result.add(new ArrayList<>(subset));
            return;
        }

        if(start > end) return;

        subset.add(start);
        helper(limit, target, subset, result, count+1, sum + start, start + 1, end);

        subset.remove(subset.size() - 1);
        helper(limit, target, subset, result, count, sum, start + 1, end);
        
    }
}