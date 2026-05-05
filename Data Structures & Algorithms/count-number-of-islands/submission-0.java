class Solution {

    int[][] dirt = {{0,1},{1,0},{0,-1},{-1,0}};

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visit = new boolean[m][n];
        int cnt = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1' && !visit[i][j]){
                    cnt++;                 // new island found
                    dfs(i, j, grid, visit);
                }
            }
        }
        return cnt;
    }

    public void dfs(int i, int j, char[][] grid, boolean[][] visit){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length)
            return;

        if(grid[i][j] == '0' || visit[i][j])
            return;

        visit[i][j] = true;

        for(int[] dir : dirt){
            dfs(i + dir[0], j + dir[1], grid, visit);
        }
    }
}
