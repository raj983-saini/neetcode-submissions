
class Solution {

    public int rob(int[] nums) {

        int n = nums.length;

        if (n == 1) {
            return nums[0];
        }

        // Case 1: Exclude last house
        int[] dp1 = new int[n];
        Arrays.fill(dp1, -1);

        int case1 = solve(n - 2, nums, dp1, 0);

        // Case 2: Exclude first house
        int[] dp2 = new int[n];
        Arrays.fill(dp2, -1);

        int case2 = solve(n - 1, nums, dp2, 1);

        return Math.max(case1, case2);
    }

    int solve(int n, int[] nums, int[] dp, int first) {

        if (n < first) {
            return 0;
        }

        if (n == first) {
            return nums[n];
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        int pick = nums[n] + solve(n - 2, nums, dp, first);

        int notPick = solve(n - 1, nums, dp, first);

        return dp[n] = Math.max(pick, notPick);
    }
}