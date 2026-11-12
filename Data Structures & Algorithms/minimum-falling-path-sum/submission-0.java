class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
    int [][]dp = new int[m+1][n+1];
        for(int arr[]:dp){
            Arrays.fill(arr,Integer.MAX_VALUE);
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0 ; i<n ;i++){
            int ans = solve(0 , i , dp,matrix);
          if( ans < min){
            min = ans;
          }
        }
        return min;
    }
    int solve(int m,int n, int[][] dp, int[][] matrix){
        if(n < 0 || n>= matrix.length){
            return (int) 1e9;
        }
        if( m == matrix.length-1){
            return matrix[m][n];
        }
        if(dp[m][n] != Integer.MAX_VALUE){
            return dp[m][n];
        }
        return dp[m][n] =matrix[m][n] + Math.min( solve(m+1,n,dp,matrix) , Math.min(solve(m+1 , n-1 , dp,matrix) ,solve( m+1 ,n+1 , dp,matrix)));
    }
}