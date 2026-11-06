class Solution {
    public int rob(int[] nums) {
       int []dp = new int[nums.length+1];
       Arrays.fill(dp,-1);
       return solve(nums.length -1 , nums , dp); 
    }
    int solve(int n , int[] nums , int []dp){
        if(n<0){
            return 0;
        }
        if(n==0){
            return nums[0];
        }
        if(dp[n] != -1){
            return dp[n];
        }
        int pick = nums[n] + solve(n - 2, nums, dp);

        // Skip current house
        int notPick = solve(n - 1, nums, dp);

        return dp[n] = Math.max(pick , notPick);
    }
}
