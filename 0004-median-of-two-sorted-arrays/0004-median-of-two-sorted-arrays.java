class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        // Using 2 pointers
        int len1 = nums1.length;
        int len2 = nums2.length;
        int count1 = 0, count2 = 0;
        int m1 = 0, m2 = 0;
        double median = 0;

        for(int i = 0; i <= (len1 + len2)/ 2; i++) {
            m2 = m1;
            if(count1 < len1 && count2 < len2) {
                if(nums1[count1] < nums2[count2]){
                    m1 = nums1[count1];
                    count1++;
                } else {
                    m1 = nums2[count2];
                    count2++;
                }
            } else if (count1 < len1) {
                m1 = nums1[count1];
                count1++;
            } else {
                m1 = nums2[count2];
                count2++;
            }
        }

        if((len1 + len2) % 2 == 1) {
            median = (double)m1;
        } else {
            median = (double) (m1 + m2)/2;
        }


       return median;
    }
}