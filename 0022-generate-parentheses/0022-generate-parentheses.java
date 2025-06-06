class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        helper(n, "", 0, 0, result);
        return result;
    }

    private void helper(int n, String s, int open, int close,  List<String> result) {
        if(s.length() == n * 2) {
            result.add(s);
            return;
        }

        if(open < n) {
            helper(n, s + "(", open + 1, close, result);
        }

        if(close < open) {
            helper(n, s + ")", open, close + 1, result);
        }

    }
}