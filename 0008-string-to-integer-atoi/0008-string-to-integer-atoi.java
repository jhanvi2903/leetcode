class Solution {
    public int myAtoi(String s) {
        int n = s.length();
        int sign = 1;
        long result = 0;
        int idx = 0;

        
        while(idx < n && s.charAt(idx) == ' ') {
            idx++;
        }

        if(idx < n && (s.charAt(idx) == '-' || s.charAt(idx) == '+')) {
            sign = s.charAt(idx) == '-' ? -1 : 1;
            idx++;
        }

        while(idx < n && Character.isDigit(s.charAt(idx))) {
            int digit = s.charAt(idx) - '0';

            result = (result * 10) + digit;

            if(sign * result < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }

            if(sign * result > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }

            idx++;
        }

        return (int)(sign*result);
    }
}