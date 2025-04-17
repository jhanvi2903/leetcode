class Solution {
    // Time complexity: O(m × n)
    // Space complexity: O(m × n)
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        Queue<int[]> q = new LinkedList<>();
        int originalColor = image[sr][sc];

        if(originalColor == color) return image;
        
        image[sr][sc] = color;
        
        q.offer(new int[] {sr, sc});

        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while(!q.isEmpty()) {
            int size = q.size();
            for(int k = 0; k < size; k++){
                int[] curr = q.poll();
                int x = curr[0];
                int y = curr[1];
                for(int[] dir: directions) {
                    int i = x + dir[0];
                    int j = y + dir[1];
                    if(i >= 0 && i < image.length && j >= 0 && j < image[0].length && image[i][j] == originalColor) {
                        image[i][j] = color;
                        q.offer(new int[] {i, j});
                    }
                }
            }
        }

        return image;

    }
}