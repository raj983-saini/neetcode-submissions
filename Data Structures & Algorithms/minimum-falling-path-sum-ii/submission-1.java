class Solution {
    public int minFallingPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        int[][] dp = new int[m][n];
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        
        int min = Integer.MAX_VALUE;
        // Try starting from every column in the first row (row 0)
        for (int col = 0; col < n; col++) {
            min = Math.min(min, solve(0, col, dp, grid));
        }
        return min;
    }

    private int solve(int row, int col, int[][] dp, int[][] grid) {
        // Out of column bounds
        int n = grid.length;

        if (col < 0 || col >= grid[0].length) {
            return (int) 1e9;
        }
        // Reached the bottom row
        if (row == grid.length - 1) {
            return grid[row][col];
        }
        // Return cached result if already computed
        if (dp[row][col] != Integer.MAX_VALUE) {
            return dp[row][col];
        }
        int minNext = Integer.MAX_VALUE;
        // Try every column in the next row except the current column
        for (int nextCol = 0; nextCol < n; nextCol++) {
            if (nextCol != col) {
                minNext = Math.min(minNext, solve(row + 1, nextCol, dp, grid));
            }
        }

        return dp[row][col] = grid[row][col] + minNext;
    }
}