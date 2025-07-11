class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> hs = new HashSet<>(wordDict);
        Map<String, Boolean> memo = new HashMap<>();
        return helper(s, hs, 0, "", memo);
    }

    private boolean helper(String s, HashSet<String> hs, int index, String substr, Map<String, Boolean> memo ) {

        String key = index + "|" + substr;

        if(memo.containsKey(key)) return memo.get(key);

        if (index == s.length()) {
            boolean result = substr.isEmpty();
            memo.put(key, result);
            return result;
        }

        substr += s.charAt(index);

        // If current substr is a word, try restarting with next char
        if (hs.contains(substr)) {
            boolean result = helper(s, hs, index + 1, "", memo);
            if (result == true) {
                memo.put(key, result);
                return result;
            }
        }

        // Continue building substr
        boolean result = helper(s, hs, index + 1, substr, memo);
        memo.put(key, result);
        return result;
    }
}


// Not optimized code - gets TLE error due to that
// class Solution {
//     public boolean wordBreak(String s, List<String> wordDict) {
//         HashSet<String> hs = new HashSet<>(wordDict);
//         return helper(s, hs, 0, "");
//     }

//     private boolean helper(String s, HashSet<String> hs, int index, String substr) {
//         if (index == s.length()) {
//             return substr.isEmpty();
//         }

//         substr += s.charAt(index);

//         // If current substr is a word, try restarting with next char
//         if (hs.contains(substr)) {
//             if (helper(s, hs, index + 1, "")) return true;
//         }

//         // Continue building substr
//         return helper(s, hs, index + 1, substr);
//     }
// }
