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

/*
Note:

Time complexity for inserting element in hashSet/ HashMap:
 for 1 element : O(1)
 for n element : O(n)

 Time complexity for inserting element in TreeSet/ TreeMap/ PriorityQueue:
 for 1 element : O(log n)
 for n element : O(n log n)

 Brute Force : Use pick and don't pick approach
 sort the array so that elements will appear in sorted order
 use set of list so that duplicate subset will not be stored
 then put the element from set to list and then return the list
*/