class Solution {
    public int characterReplacement(String s, int k) {
        int maxLength = 0;
        int left = 0;
        int[] freq = new int[26];
        int maxFreq = 0;

        for(int right = 0; right < s.length(); right++) {
            int currChar = s.charAt(right);

            freq[currChar - 'A']++;

            maxFreq = Math.max(maxFreq, freq[currChar - 'A']);

            int currLength = right - left + 1;
            int replacement = currLength - maxFreq;

            if(replacement > k) {
                freq[s.charAt(left) - 'A']--;
                left++;                  
            }

            maxLength = Math.max(maxLength,  right - left + 1);
        }
    

        return maxLength;
    }
}