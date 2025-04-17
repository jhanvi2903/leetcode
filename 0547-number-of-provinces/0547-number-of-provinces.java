class Solution {
    public int findCircleNum(int[][] isConnected) {
        int rows = isConnected.length;
        int col = isConnected[0].length;

        int countProvince = 0; // Counts total disconnected component
        boolean[] vis = new boolean[rows]; 
        for(int i = 0; i < rows; i++){
            if(vis[i] == false){
                countProvince++;
                dfs(i, vis, isConnected);
            }
        }

      return countProvince;
    }

    private void dfs(int node, boolean[] vis, int[][] isConnected){
         
         vis[node] = true;
         
         for(int col = 0; col < isConnected.length; col++ ){
             if(isConnected[node][col] == 1 && !vis[col]){
                dfs(col, vis, isConnected);
             }
         }
    }
}
