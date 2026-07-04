class Solution {

    int[][] dirt = {{0,1},{1,0},{0,-1},{-1,0}};

    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean visit[][] = new boolean[n+1][m+1];
        for(boolean [] vis:visit){
            Arrays.fill(vis,false);
        }
        int cnt =0;
        for(int i =0;i<n;i++){
            for(int j=0;j<m;j++){
            if(grid[i][j] == '1' && !visit[i][j]){
                cnt++;
                dfs(grid,i,j,visit);
            }
            }
        }
        return cnt;
          }
          public void dfs(char[][] grid, int i,int j,boolean [][] visit){
            if(i<0 || j<0 || i>=grid.length ||j>=grid[0].length){
                return;
            }
            if(grid[i][j] == '0' || visit[i][j] ){
                return;
            }
            visit[i][j] = true;
            for(int dir[] : dirt){
                dfs(grid,i+dir[0] , j+dir[1],visit);
            }
          }
}
