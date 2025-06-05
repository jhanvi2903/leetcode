class Solution {
    public int myAtoi(String s) {
        int n = s.length();
        int sign = 1;
        long result = 0; // Use long to detect overflow
        int idx = 0;

   
        // 1. Skip whitespace     
        while(idx < n && s.charAt(idx) == ' ') {
            idx++;
        }

         // 2. Handle optional sign
        if(idx < n && (s.charAt(idx) == '-' || s.charAt(idx) == '+')) {
            sign = s.charAt(idx) == '-' ? -1 : 1;
            idx++;
        }

        // 3. Parse digits
        while(idx < n && Character.isDigit(s.charAt(idx))) {

            // char to int conversion: 
            //'0' unicode value is 48
            // Similarly '1' unicode value is 49 and so on
            int digit = s.charAt(idx) - '0'; 

            result = (result * 10) + digit;

            // Rounding the result
            if(sign * result < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }

            // Rounding the result
            if(sign * result > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }

            idx++;
        }

        return (int)(sign*result); // Converting long to int
    }
}

// Time Complexity : O(n) , where n is the length of string
// Space Complexity : O(1)