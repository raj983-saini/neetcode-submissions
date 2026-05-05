class Solution {
    int [][]dirt= {{-1,0},{0,-1},{1,0},{0,1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        boolean [][]pre = new boolean[n][m];
        boolean [][]atl = new boolean[n][m];

         for(int i=0;i<m;i++){
            dfs(0,i,heights,pre);
            dfs(n-1,i,heights,atl);
         }
         for(int i=0;i<n;i++){
            dfs(i,0,heights,pre);
            dfs(i,m-1,heights,atl);
         }
         List<List<Integer>> ans = new ArrayList<>();
         for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(pre[i][j] && atl[i][j]){
                    ans.add(Arrays.asList(i, j));
                }
            }
         }
         return ans;
        
    }
    public void dfs(int i,int j,int[][] grid,boolean [][]visit){
        if(visit[i][j]){
            return;
        }
        visit[i][j]=true;
        for(int[]dir:dirt){
            int nj = i+dir[0];
            int nr = j+dir[1];

            if(nj<0||nr<0||nj>=grid.length||nr>=grid[0].length){
            continue;
        }
        if (grid[nj][nr] >= grid[i][j]) {
                dfs(nj, nr, grid, visit);
            }
        }
    }
}
