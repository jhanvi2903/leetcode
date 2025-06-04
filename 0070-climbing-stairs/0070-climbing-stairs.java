class Solution {
    public int climbStairs(int n) {
       HashMap<Integer, Integer> memo = new HashMap<>();
       return climb(n, memo);
    }

    private int climb(int n, HashMap<Integer, Integer> memo) {
        if(n == 0) return 1;
        if(n < 0) return 0;

        if(memo.containsKey(n)) return memo.get(n);

        int ways = climb(n-1, memo) + climb(n-2, memo);
        memo.put(n, ways);

        return ways;
    }
}