//// 2023/08/26 // 7:33 //

//// 97. Interleaving String // Medium //

// Given string s1, s2, and s3, find whether s3 is formed by an
// interleaving of s1 and s2.

// An interleaving of two strings s and t is a configuration where s and t
// are divided into n and m substrings respectively, such that:
// * s = s1 + s2 + ... + sn
// * t = t1 + t2 + ... + tm
// |n - m| <= 1
// * The interleaving is s1 + t1 + s2 + t2 + s3 + t3 + ...
// or t1 + s1 + t2 + s2 + t3 + s3 + ...
// Note: a + b is the concatenation of string a and b.

// Example 1:
// Image
// Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
// Output: true
// Explanation: One way to obtain s3 is:
// Split s1 into s1 = "aa" + "bc" + "c", and s2 into s2 = "dbbc" + "a".
// Interleaving the two splits, we get "aa" + "dbbc" + "bc" + "a" + "c" = "aadbbcbcac".
// Since s3 can be obtained by interleaving s1 and s2, we return true.

// Example 2:
// Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
// Output: false
// Explanation: Notice how it is impossible to interleave
// s2 with any other string to obtain s3.

// Example 3:
// Input: s1 = "", s2 = """, s3 = ""
// Output: true

// Constraints:
// * 0 <= s1.length, s2.length <= 100
// * 0 <= s3.length <= 200
// * s1, s2, and s3 consist of lowercase English letters.

// Follow up: Could you solve it using only O(s2.length) additional memory space?


class InterleavingString {

    // Optimal Solution:
    // To solve this problem we can use a dynamic programming approach with
    // a 2D table. Let dp[i][j] represent whether the first i characters of s1
    // and the first j characters of s2 can form the first i+j characters of s3.

    // The recurrence relation for dp[i][j] can be defined as follows:
    // dp[i][j] = (dp[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j-1)) ||
    //            (dp[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1))

    // In simpler terms, dp[i][j] is true if either dp[i-1][j] is true and the
    // (i-1)-th character of s1 matches the (i+j-1)-th character of s3, or
    // dp[i][j-1] is true and the (j-1)-th character of s2 matches
    // the (i+j-1)-th character of s3.

    // To fill the dp table, we initialize dp[0][0] as true (since both s1 and s2
    // are empty strings) and fill the first row and the first column of dp based
    // on the matching characters of s1, s2, and s3.

    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        int p = s3.length();

        if (m + n != p) {
            return false; // Lengths do not match
        }

        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;

        // Fill the first row
        for (int j = 1; j <= n; j++) {
            dp[0][j] = dp[0][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
        }

        // Fill the first column
        for (int i = 1; i <= m; i++) {
            dp[i][0] = dp[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1);
        }

        // Fill the remaining cells
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) ||
                        (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
            }
        }

        return dp[m][n];
    }

    // Time Complexity:
    // The time complexity of this solution is O(m * n), where m is the length of
    // s1 and n is the length of 22. We fill the dp table of size (m+1) x (n+1)
    // with m * n cells, and each cell computation takes constant time.

    // Space complexity:
    // The space complexity of this solution is O(m * n), where m is the length of
    // s1 and n is the length of s2. We use a 2D table dp to store the results of
    // subproblems, which requires (m+1) x (n+1) cells. Therefore, the overall
    // space complexity is O(m * n).

}
