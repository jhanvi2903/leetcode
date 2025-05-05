import java.util.*;

class Solution {
    // ArrayList to store the parent of each node in the DSU
    ArrayList<Integer> parent;
    // ArrayList to store the size of each connected component
    ArrayList<Integer> size;
    
    // Returns the maximum number of stones that can be removed
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
        
        // Initialize our ArrayLists
        parent = new ArrayList<>();
        size = new ArrayList<>();
        
        // Initialize each element in the ArrayLists
        for (int i = 0; i < maxIndex; i++) {
            parent.add(i);  // Each node is initially its own parent
            size.add(1);    // Each component initially has size 1
        }
        
        // Union rows and columns for each stone
        for (int[] stone : stones) {
            int row = stone[0];
            int col = stone[1] + maxRow + 1; // Offset columns by maxRow+1 to avoid collision
            union(row, col);
        }
        
        // Count connected components by checking nodes that are their own parent and have size > 1
        int componentCount = 0;
        for (int i = 0; i < maxIndex; i++) {
            if (parent.get(i) == i && size.get(i) > 1) {
                componentCount++;
            }
        }
        
        // Maximum stones removable = total stones - number of connected components
        return totalStones - componentCount;
    }
    
    // Union operation to merge two components
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