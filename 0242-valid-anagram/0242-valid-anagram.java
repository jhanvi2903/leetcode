class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> hm = new HashMap<>();

        if(s.length() != t.length()) return false;

        for(char c : s.toCharArray()) {
            hm.put(c, hm.getOrDefault(c, 0) + 1);
        } 

        for(char c : t.toCharArray()) {
            if(!hm.containsKey(c) || hm.get(c) == 0) {
                return false;
            } else {
                hm.put(c, hm.get(c) - 1);
            }
        }

        return true;
    }
}