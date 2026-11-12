class Solution {
    public int uniquePaths(int m, int n) {
         int [][]dp = new int[m+1][n+1];
        for(int arr[]:dp){
            Arrays.fill(arr,-1);
        }
        return solve(m-1 , n-1 , dp);
    }
    int solve(int m,int n, int[][] dp){
        if(m < 0 || n <0){
            return 0;
        }
        if(m == 0 && n == 0){
            return 1;
        }
        if(dp[m][n] != -1){
            return dp[m][n];
        }
        return dp[m][n] = solve(m , n-1 , dp) +solve( m-1 ,n , dp);
    }
}