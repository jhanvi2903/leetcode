class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        if(digits.length() == 0) return result;

        Map<Character, String> digitToLetters = new HashMap<>();
        digitToLetters.put('2', "abc");
        digitToLetters.put('3', "def");
        digitToLetters.put('4', "ghi");
        digitToLetters.put('5', "jkl");
        digitToLetters.put('6', "mno");
        digitToLetters.put('7', "pqrs");
        digitToLetters.put('8', "tuv");
        digitToLetters.put('9', "wxyz");

        helper(digits, digitToLetters, result, 0, new StringBuilder());

        return result;
    }

    private void helper(String digits, Map<Character, String> digitToLetters , List<String> result, int index, StringBuilder comb) {
        if(index == digits.length()) {
            result.add(comb.toString());
            return;
        }

        String letters = digitToLetters.get(digits.charAt(index));
        for(char letter : letters.toCharArray()) {
            comb.append(letter);
            helper(digits, digitToLetters, result, index + 1, comb);
            comb.deleteCharAt(comb.length() - 1);
        }

    }
}