class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int[] prevInterval = intervals[0];

        List<int[]> mergeList = new ArrayList<>();
        mergeList.add(prevInterval);

        for(int i = 1; i < intervals.length; i++) {
            int[] currInterval = intervals[i];

            if(prevInterval[1] >= currInterval[0]) {
                prevInterval[1] = Math.max(prevInterval[1], currInterval[1]);
            } else {
                mergeList.add(currInterval);
                prevInterval = currInterval;
            }
        }
        
        return mergeList.toArray(new int[mergeList.size()][]);
    }
}