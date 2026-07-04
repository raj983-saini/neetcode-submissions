class Solution {
    int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}};

    public void islandsAndTreasure(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();

        // Add all gates
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        while (!queue.isEmpty()) {

            int[] curr = queue.poll();

            for (int[] d : dir) {

                int ni = curr[0] + d[0];
                int nj = curr[1] + d[1];

                if (ni < 0 || nj < 0 || ni >= m || nj >= n)
                    continue;

                if (grid[ni][nj] != Integer.MAX_VALUE)
                    continue;

                grid[ni][nj] = grid[curr[0]][curr[1]] + 1;
                queue.offer(new int[]{ni, nj});
            }
        }
    }
}