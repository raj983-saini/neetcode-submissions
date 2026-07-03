class Solution {

    int perimeter = 0;

    int[][] dir = {
        {-1, 0},
        {1, 0},
        {0, 1},
        {0, -1}
    };

    public int islandPerimeter(int[][] grid) {

        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                if (grid[i][j] == 1) {
                    dfs(grid, visited, i, j);
                    return perimeter;
                }
            }
        }

        return 0;
    }

    public void dfs(int[][] grid, boolean[][] visited, int i, int j) {

        visited[i][j] = true;

        for (int[] d : dir) {

            int ni = i + d[0];
            int nj = j + d[1];

            if (ni < 0 || nj < 0 || ni >= grid.length || nj >= grid[0].length || grid[ni][nj] == 0) {
                perimeter++;
            }
            else if (!visited[ni][nj]) {
                dfs(grid, visited, ni, nj);
            }
        }
    }
}