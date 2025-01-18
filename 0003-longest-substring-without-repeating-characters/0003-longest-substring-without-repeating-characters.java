class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> hm = new HashMap<>();

        int left = 0;
        int maxlen = 0;

        for(int i = 0 ; i < s.length(); i++){

            if(hm.containsKey(s.charAt(i))){
                left = Math.max(left, hm.get(s.charAt(i)) + 1);
            }

            hm.put(s.charAt(i), i);
            maxlen = Math.max(maxlen, i - left + 1);
        }

        return maxlen;
    }
}