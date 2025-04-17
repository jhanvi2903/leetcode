// class Solution {
//     public int findCircleNum(int[][] isConnected) {
//         int rows = isConnected.length;
//         int col = isConnected[0].length;

//         int countProvince = 0; // Counts total disconnected component
//         boolean[] vis = new boolean[rows]; 
//         for(int i = 0; i < rows; i++){
//             if(vis[i] == false){
//                 countProvince++;
//                 dfs(i, vis, isConnected);
//             }
//         }

//       return countProvince;
//     }

//     private void dfs(int node, boolean[] vis, int[][] isConnected){
         
//          vis[node] = true;
         
//          for(int col = 0; col < isConnected.length; col++ ){
//              if(isConnected[node][col] == 1 && !vis[col]){
//                 dfs(col, vis, isConnected);
//              }
//          }
//     }
// }

// Using adjacency list - not optimized
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int rows = isConnected.length;
        int col = isConnected[0].length;

          List<List<Integer>> adj = new ArrayList<>();
          
        // Creating empty lists(Equal to no of rows/nodes) in list
        for(int i = 0; i < rows; i++){
           adj.add(new ArrayList());
        }

        // Adding the adjacent nodes in the list from matrix
        //Note: Eliminate self loop
        for(int i = 0; i < rows; i++){
            for(int j= 0; j < col; j++){
                if(isConnected[i][j] == 1 && i != j){ 
                   adj.get(i).add(j);
                   adj.get(j).add(i);
                }
            }
        }

        int countProvince = 0; // Counts total disconnected component
        boolean[] vis = new boolean[adj.size()]; 
        for(int i = 0; i < adj.size(); i++){
            if(vis[i] == false){
                countProvince++;
                dfs(i, vis, adj);
            }
        }

      return countProvince;
    }

    private void dfs(int i, boolean[] vis, List<List<Integer>> adj){
         
         vis[i] = true;
         
         for(Integer el : adj.get(i)){
             if(vis[el] == false){
                dfs(el, vis, adj);
             }
         }
    }
}