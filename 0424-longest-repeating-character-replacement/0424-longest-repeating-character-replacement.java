class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int start = 0;
        int maxFreq = 0;
        int maxLen = 0;

        for (int end = 0; end < s.length(); end++) {
            char c = s.charAt(end);
            freq[c - 'A']++;
            maxFreq = Math.max(maxFreq, freq[c - 'A']);

            while ((end - start + 1) - maxFreq > k) {
                freq[s.charAt(start) - 'A']--;
                start++;
            }

            maxLen = Math.max(maxLen, end - start + 1);
        }

        return maxLen;
    }
}