import java.util.*;

class Solution {
    ArrayList<Integer> parent = new ArrayList<>();
    ArrayList<Integer> size = new ArrayList<>();
    
    public int removeStones(int[][] stones) {
        int totalStones = stones.length;
        if (totalStones == 0) return 0;
        
        // Find the maximum row and column values to determine array size
        int maxRow = 0;
        int maxCol = 0;
        for (int[] stone : stones) {
            maxRow = Math.max(maxRow, stone[0]);
            maxCol = Math.max(maxCol, stone[1]);
        }
        
        // Calculate the maximum possible index we'll need
        int maxIndex = maxRow + maxCol + 2; // +2 to handle the offset and 0-indexing
        
        
        for (int i = 0; i < maxIndex; i++) {
            parent.add(i);  
            size.add(1);    
        }
        
        // Union rows and columns for each stone
        for (int[] stone : stones) {
            int row = stone[0];
            int col = stone[1] + maxRow + 1; // Offset columns by maxRow+1 to avoid collision
            union(row, col);
        }
        
        int componentCount = 0;
        for (int i = 0; i < maxIndex; i++) {
            if (parent.get(i) == i && size.get(i) > 1) {
                componentCount++;
            }
        }
        
        return totalStones - componentCount;
    }
    

    private void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        
        // If already in the same component, do nothing
        if (rootX == rootY) return;
        
        // Union by size: attach smaller component to larger one
        if (size.get(rootX) < size.get(rootY)) {
            parent.set(rootX, rootY);
            size.set(rootY, size.get(rootY) + size.get(rootX));
        } else {
            parent.set(rootY, rootX);
            size.set(rootX, size.get(rootX) + size.get(rootY));
        }
    }
    
    // Find operation with path compression
    private int find(int x) {
        if (x != parent.get(x)) {
            parent.set(x, find(parent.get(x)));
        }
        return parent.get(x);
    }
}