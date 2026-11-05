class Solution {
    public int minCostClimbingStairs(int[] cost) {
     int []dp = new int[cost.length+1];
     Arrays.fill(dp,-1);
     return solve(cost.length ,cost , dp);
    }
    int solve(int n ,int[] cost, int[] dp){
        if(n == 1 || n==0){
            return 0;
        }
        if(dp[n] != -1){
            return dp[n];
        }
        return dp[n]= Math.min(solve(n-1,cost,dp)+cost[n-1]  ,solve(n-2,cost,dp) +cost[n-2]);
    }
}
