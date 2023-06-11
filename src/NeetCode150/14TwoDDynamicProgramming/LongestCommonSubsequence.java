//// 2023/06/11 // 15:56 //

//// 1143. Longest Common Subsequence // Medium //

// Given two string text1 and text2, return the length of their longest common subsequence.
// If there is no common subsequence, return 0.

// A subsequence of a string is a new string generated from the original string with some characters (can be none)
// deleted without changing the relative order of the remaining characters.

// * For example, "ace" is a subsequence of "abcde".

// A common subsequence of two string is a subsequence that is common to both string.

// Example 1:
// Input: text1 = "abcde", text2 = "ace"
// Output: 3
// Explanation: The longest common subsequence is "ace" and its length is 3.

// Example 2:
// Input: text1 = "abc", text2 = "abc"
// Output: 3
// Explanation: The longest common subsequence is "abc' and its length is 3.

// Example 3:
// Input: text1 = "abc", text2 = "def'
// Output: 0
// Explanation: There is no such common subsequence, so the result is 0.

// Constraints:
// * 1 <= text1.length, text2.length <= 1000
// * text1 and text2 consist of only lowercase English characters.

class LongestCommonSubsequence {

    // Explanation:
    // The longest common subsequence (LCS) of two strings is the longest
    // sequence of characters that appears in both strings, in the same order. For
    // example, the LCS of the strings "abcde" and "ace" is "ace", which is 3 characters long

    // The LCS problem can be solved using dynamic programming. The idea is to
    // create a table where each entry represents the length of the longest common
    // subsequence of the prefixes of the two string up to that point.
    // For example, the same for the strings "abcde" and "ace" would look like this:
//            | text1 | text2 | LCS |
//            |-------|---|---|
//            |   a   | a | 1 |
//            |  ab   | a | 1 |
//            |  abc  | a | 2 |
//            |  abcd | a | 2 |
//            | abcde | a | 3 |
//            |    a  | c | 1 |
//            |   ab  | c | 1 |
//            |  abc  | c | 2 |
//            |  abcd | c | 2 |
//            | abcde | c | 3 |

    // The LCS can be found by starting at the bottom right corner of the table
    // and working upwards. The value in the bottom right corner is the length of the LCS.
    // To find the value in any other cell, we look at the two values in the cells
    // above it and take the maximum of the two, plus 1 if the corresponding
    // character in the two strings are equal.

    // For example, to find the value in the cell for "abcd" and "ace", we look at the
    // values in the cells for "abc" and "ace" and take the maximum, which is 2.
    // We then add 1 because the corresponding characters in the two string are
    // equal. This gives us a value of 3, which is the length of the LCS of "abcd" and "ace'.

    // Solution:
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();

        // Create a table to store the lengths of the longest common subsequence
        // fo the prefixes of the two strings
        int[][] dp = new int[n + 1][m + 1];

        // Initialize the table.
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // Return the value in the bottom right corner of the table, which is the lenngth of the LCS.
        return dp[n][m];
    }

    // Big O:

    // The time complexity of the above solution is O(mn), where m is the length of
    // string1 and n is the length of string2. This is because the table has m+1 rows
    // and n+1 columns, and each entry in the table takes O(1) time to compute.

    // The space complexity of the above solution is O(mn), which is the space required to store the table.

}
