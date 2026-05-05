class Solution {

    int[][] dirt = {{0,1},{1,0},{0,-1},{-1,0}};

    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visit = new boolean[m][n];
        int totMax = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1 && !visit[i][j]){
                    int area = dfs(i, j, grid, visit);
                    totMax = Math.max(totMax, area);
                }
            }
        }
        return totMax;
    }

    public int dfs(int i, int j, int[][] grid, boolean[][] visit){
        // boundary + water + visited check
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length)
            return 0;

        if(grid[i][j] == 0 || visit[i][j])
            return 0;

        visit[i][j] = true;

        int area = 1; // count current land

        for(int[] dir : dirt){
            area += dfs(i + dir[0], j + dir[1], grid, visit);
        }

        return area;
    }
}
