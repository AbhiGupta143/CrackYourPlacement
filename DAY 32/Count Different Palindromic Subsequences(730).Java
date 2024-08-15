class Solution {
    // Define the modulus constant for the problem
    private static final int MOD = 1_000_000_007;

    public int countPalindromicSubsequences(String s) {
        int n = s.length(); // Length of the string
      
        // 3D dynamic programming array to store results
        long[][][] dp = new long[n][n][4];
      
        // Base case: single character strings
        for (int i = 0; i < n; ++i) {
            dp[i][i][s.charAt(i) - 'a'] = 1;
        }
      
        // Loop over all possible substring lengths
        for (int len = 2; len <= n; ++len) {
            // Iterate over all possible starting points for substring
            for (int start = 0; start + len <= n; ++start) {
                int end = start + len - 1; // Calculate end index of substring
                // Try for each character a, b, c, d
                for (char c = 'a'; c <= 'd'; ++c) {
                    int charIndex = c - 'a'; // Convert char to index (0 to 3)
                    // Case 1: Characters at both ends match the current character
                    if (s.charAt(start) == c && s.charAt(end) == c) {
                        // Count is sum of inner substring counts + 2 (for the two characters added)
                        dp[start][end][charIndex] = 2 + dp[start + 1][end - 1][0]
                            + dp[start + 1][end - 1][1] + dp[start + 1][end - 1][2]
                            + dp[start + 1][end - 1][3];
                        dp[start][end][charIndex] %= MOD; // Ensure mod operation
                    }
                    // Case 2: Only the start character matches
                    else if (s.charAt(start) == c) {
                        dp[start][end][charIndex] = dp[start][end - 1][charIndex];
                    }
                    // Case 3: Only the end character matches
                    else if (s.charAt(end) == c) {
                        dp[start][end][charIndex] = dp[start + 1][end][charIndex];
                    }
                    // Case 4: Neither end matches the character
                    else {
                        dp[start][end][charIndex] = dp[start + 1][end - 1][charIndex];
                    }
                }
            }
        }
      
        // Summation of counts for 'a', 'b', 'c', 'd' for the whole string
        long result = 0;
        for (int k = 0; k < 4; ++k) {
            result += dp[0][n - 1][k];
        }
      
        return (int) (result % MOD); // Final result with mod operation
    }
}
