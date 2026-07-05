
class Solution {

    int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};

    public int orangesRotting(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;

        // Step 1: Add all rotten oranges to queue & count fresh
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        // If no fresh oranges
        if (fresh == 0) return 0;

        int minutes = 0;

        // Step 2: BFS level by level
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean rottedThisMinute = false;

            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();

                for (int[] dir : directions) {
                    int x = curr[0] + dir[0];
                    int y = curr[1] + dir[1];

                    // Boundary + fresh orange check
                    if (x >= 0 && y >= 0 && x < m && y < n && grid[x][y] == 1) {
                        grid[x][y] = 2;
                        queue.offer(new int[]{x, y});
                        fresh--;
                        rottedThisMinute = true;
                    }
                }
            }

            // Increase minute only if something rotted
            if (rottedThisMinute) minutes++;
        }

        // If fresh oranges remain → impossible
        return fresh == 0 ? minutes : -1;
    }
}
