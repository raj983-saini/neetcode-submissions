class Solution {
    public int countSubstrings(String s) {

        int n = s.length();
        int count = 0;

        boolean[][] dp = new boolean[n][n];

        // Traverse from right to left
        for (int i = n - 1; i >= 0; i--) {

            // Length 1: Every character is a palindrome
            dp[i][i] = true;
            count++;

            // Check all substrings starting at i
            for (int j = i + 1; j < n; j++) {

                if (s.charAt(i) == s.charAt(j)) {

                    if (j - i <= 2 || dp[i + 1][j - 1]) {

                        dp[i][j] = true;
                        count++;
                    }
                }
            }
        }

        return count;
    }
}