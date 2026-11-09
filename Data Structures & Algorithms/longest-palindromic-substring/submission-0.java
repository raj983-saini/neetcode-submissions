class Solution {
    public String longestPalindrome(String s) {

        int n = s.length();

        boolean[][] dp = new boolean[n][n];

        int maxLength = 1;
        int start = 0;

        // Traverse from right to left
        for (int i = n - 1; i >= 0; i--) {

            // Every single character is a palindrome
            dp[i][i] = true;

            // Check substrings ending at j
            for (int j = i + 1; j < n; j++) {

                if (s.charAt(i) == s.charAt(j)) {

                    // Length 2 or 3, or inner substring is palindrome
                    if (j - i <= 2 || dp[i + 1][j - 1]) {

                        dp[i][j] = true;

                        int length = j - i + 1;

                        if (length > maxLength) {
                            maxLength = length;
                            start = i;
                        }
                    }
                }
            }
        }

        return s.substring(start, start + maxLength);
    }
}