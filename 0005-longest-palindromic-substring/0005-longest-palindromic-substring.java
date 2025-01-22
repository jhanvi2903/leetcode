class Solution {
    public String longestPalindrome(String s) {
        // Types of Palindrome 
        // 1. Odd length - aba
        // 2. Even length - abba
        // Considering i at b in both the ways
        // In first case, it will compare with itself and move to the left & right of i
        // In second case, it compares with the next b, as they are equal, left moves to left of i & right moves to right of i+1
        if(s == null || s.length() == 1){
            return s;
        } 

// To maintain the start & end index of the longest substring palindrome
        int start = 0;
        int end = 0;

        for(int i = 0; i < s.length(); i++){
            int odd = expandAroundCenter(s, i, i);
            int even = expandAroundCenter(s, i, i+1);
            int maxLen = Math.max(odd, even);

            if(maxLen > end - start){
                start = i - (maxLen - 1)/2;
                end = i + maxLen/2;
            }
        }
        
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right){
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }

        return right - left - 1;
    }
}