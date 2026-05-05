class Solution {
    int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}};

    public void islandsAndTreasure(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> q = new LinkedList<>();

        // Step 1: push all gates (0) into queue
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    q.offer(new int[]{i, j});
                }
            }
        }

        // Step 2: BFS
        while (!q.isEmpty()) {
            int[] cell = q.poll();

            for (int[] d : dir) {
                int ni = cell[0] + d[0];
                int nj = cell[1] + d[1];

                // valid empty room
                if (ni >= 0 && nj >= 0 && ni < m && nj < n && grid[ni][nj] == Integer.MAX_VALUE) {
                    grid[ni][nj] = grid[cell[0]][cell[1]] + 1;
                    q.offer(new int[]{ni, nj});
                }
            }
        }
    }
}
