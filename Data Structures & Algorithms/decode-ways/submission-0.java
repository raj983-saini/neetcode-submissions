class Solution {
    public int numDecodings(String s) {
        int n = s.length();

        if (n == 0) return 0;

        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        return solve(0, s, dp);
    }

    public int solve(int i, String s, int[] dp) {

        if (i == s.length()) return 1;

        if (s.charAt(i) == '0') return 0;

        if (dp[i] != -1) return dp[i];

        int oneDigit = solve(i + 1, s, dp);

        int twoDigit = 0;

        if (i + 1 < s.length()) {
            int num = (s.charAt(i) - '0') * 10
                    + (s.charAt(i + 1) - '0');

            if (num >= 10 && num <= 26) {
                twoDigit = solve(i + 2, s, dp);
            }
        }

        return dp[i] = oneDigit + twoDigit;
    }
}