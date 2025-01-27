class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int[] result = new int[nums1.length + nums2.length]; // using more space
        int k = 0;
        double median = 0;

        for(int i = 0; i < nums1.length; i++) {
            result[k++] = nums1[i];
        }

        for(int j = 0; j < nums2.length; j++) {
            result[k++] = nums2[j];
        }

        Arrays.sort(result);
        int len = result.length;

        if(len % 2 == 1) {
            median = (double)result[len / 2];
        } else {
            int firstNum = result[len / 2 - 1];
            int secNum = result[len / 2];
            median = (double)(firstNum + secNum) / 2;
        }

      return median;
    }
}