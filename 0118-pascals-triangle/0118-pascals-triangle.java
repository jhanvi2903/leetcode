class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        result.add(firstRow);

        for(int i = 1; i < numRows; i++) {
            List<Integer> currRow = new ArrayList<>();
            currRow.add(1);

            List<Integer> prevRowList = result.get(i - 1);
            for(int j = 1; j < i; j++) {
                currRow.add(prevRowList.get(j - 1) + prevRowList.get(j));
            }

            currRow.add(1);

            result.add(currRow);
        }

        return result;       
    }
}