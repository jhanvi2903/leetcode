class Solution {
    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        List<int[]> list = new ArrayList<>();

        for(int i = 0; i < intervals.length; i++){
            if(list.size() == 0 || intervals[i][0] > list.get(list.size()-1)[1]){
               list.add(new int[] {intervals[i][0], intervals[i][1]});
            }else {
               list.get(list.size()-1)[1] =  Math.max( list.get(list.size()-1)[1], intervals[i][1]); 
            }
        }

        return list.toArray(new int[list.size()][]);      
    }
}