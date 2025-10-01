class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int left = 0;
        Map<Character, Integer> hm = new HashMap<>();

        for(int right = 0; right < s.length(); right++) {
            char currChar = s.charAt(right);

            if(hm.containsKey(currChar) && hm.get(currChar) >= left) {
                left = hm.get(currChar) + 1;
            }

            hm.put(currChar, right);
            maxLength = Math.max(maxLength, right - left + 1);     
        }

        return maxLength;       
    }
}