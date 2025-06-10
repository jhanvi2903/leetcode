class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> sublist = new ArrayList<>();

        helper(s, 0, sublist, result);

        return result;
    }

    private void helper(String s, int index, List<String> sublist, List<List<String>> result) {
        if(index == s.length()) {
            result.add(new ArrayList<>(sublist));
            return;
        }

        for(int i = index; i < s.length(); i++) {
            String substr = s.substring(index, i + 1);
            if(isPalindrome(substr)) {
                sublist.add(substr);
                helper(s, i + 1, sublist, result);
                sublist.remove(sublist.size() - 1);
            }
        }

    }

    private boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;

        while(left < right) {
            if(str.charAt(left) != str.charAt(right)) return false;

            left++;
            right--;
        }

        return true;
    }


}