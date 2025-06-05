class Solution {
    public double myPow(double x, int n) {

        long N = n;
        
        // If the exponent is negative, invert x and make exponent positive
        if(N < 0) {
            N = -N; // Make exponent positive
            x = 1/x;        
        }

        double result = 1;

        while(N != 0) {
            // (n & 1) checks whether the last bit of n is 1
            if((N & 1) == 1) {
                result = result * x; // Adding one multiple of x as the current bit is 1
            }

            x = x * x;

            N = N >> 1; // equivalent to n >>= 1; discarding remainder
        }
        
        return result;
    }
}

/*
The time complexity is O(log₂ |n|) because in each loop iteration, we reduce n by half using right shift (n >>= 1). So the number of steps is proportional to the number of bits in n, which is log₂ |n|.

Space complexity : O(1)
*/