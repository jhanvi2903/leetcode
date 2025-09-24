class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for(int k = m, j = 0; j < n; j++) {
            nums1[k++] = nums2[j]; 
        }

        Arrays.sort(nums1);
    }
}