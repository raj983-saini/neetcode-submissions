class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
       int [][]dp = new int[m+1][n+1];
        for(int arr[]:dp){
            Arrays.fill(arr,-1);
        }
        return solve(m-1 , n-1 , dp,grid);
    }
    int solve(int m,int n, int[][] dp , int[][] grid){
        if(m < 0 || n <0){
             return (int) 1e9;
        }
        if(m == 0 && n == 0){
            return grid[0][0];
        }
        if(dp[m][n] != -1){
            return dp[m][n];
        }
        return dp[m][n] = Math.min(solve(m , n-1 , dp,grid) +grid[m][n] ,  +solve( m-1 ,n , dp,grid) +grid[m][n] );
    }
}