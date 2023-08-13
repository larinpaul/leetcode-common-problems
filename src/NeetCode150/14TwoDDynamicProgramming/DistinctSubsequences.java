//// 2023/08/13 // 10:13 //

//// 115. Distinct Subsequences // Hard //

// Given two strings s and t, return the number of distinct subsequences of s which equals t.

// The test cases are generated so that the answer fits on a 32-bit signed integer.

// Example 1:
// Input: s = "rabbit", t = "rabbit"
// Output: 3
// Explanation:
// As shown below, there are 3 ways you can generate "rabbit" from s.
// rabb b it
// ra b bbit
// rab b bit

// Example 2:
// Input: s = "babgbag", t = "bag"
// Output: 5
// Explanation:
// As shown below, there are 5 ways you can generate "bag" from s.
// BAbGbag
// BAbgbaG
// BabgbAG
// baBgbAG
// babgBAG

// Constraints:
// * 1 <= s.length, t.length <= 1000
// * s and t consist of English letters.


class DistinctSubsequences {

    // The problem we are trying to solve is called distinct subsequences.
    // A subsequence of a string is a new string that is formed from the original
    // string by deleting some (can be none) of the characters
    // without disturbing the relative positions of the remaining characters.
    // For example, "ace" is a subsequence of "abcde" but "aec" is
    // not. A distinct subsequence is a subsequence that
    // does not appear more than once in the original string.

    // The goal of this problem is to find the number of distinct subsequences
    // of s that equal t. For example, if s = "rabbit" and t = "rabbit",
    // there are 3 distinct subsequences: "rabbit", "rabbit", and "rabbit".

    // One way to approach this problem is to use dynamic programming.
    // Dynamic programming is a technique that breaks down a complex problem
    // into smaller and simpler subproblems, and stores the results
    // of these subproblems in a table or an array,
    // so that they can be reused later.

    // To apply dynamic programming to this problem we can define a two-dimensional
    // array dp, where dp[i][j] represents the number of distinct subsequences
    // of s[0...i-1] that equal t[0...j-1]. The base case is when j = 0,
    // which means t is an empty string. In this case, there is only one way
    // to form an empty string from any s,
    // which is to delete all the characters. So dp[i][0] = 1 for all i.

    // The recursive case is when j > 0, which means t has at least one character.
    // In this case, we have two options:
    // * If s[i-1] == t[j-1], we can either use s[i-1] as part of the subsequence,
    // or ignore it. The number of distinct subsequences in the first option
    // is equal to dp[i-1][j-1], since we need to match the remaining characters of s and t.
    // The number of distinct subsequences in the second option is equal to dp[i-1][j],
    // since we still need to match t[j-1] with some character in s[0...i-1].
    // Therefore, dp[i][j] = dp[i-1][j-] + dp[i-1][j].
    // * If s[i-1] != t[j-1], we cannot use s[i-1] as part of the subsequence,
    // so we have to ignore it. The number of distinct subsequences in this case
    // is equal to dp[i-1][j], since we still need to match t[j-1]
    // with some character is s[0...i-2]. Therefore, dp[i][j] = dp[i-1][j].

    // The final answer is dp[s.length()][t.length()], which represents
    // the number of distinct subsequences of s that equal t.

    // Here is the code for this solution in Java:
    public int numDistinct(String s, String t) {
        // initialize a two-dimensional array with size (s.length() + 1) x (t.length() + 1)
        int[][] dp = new int[s.length() + 1][t.length() + 1];

        // fill the first column with 1, since there is only one way to form an empty string from any s
        for (int i = 0; i <= s.length(); i++) {
            dp[i][0] = 1;
        }

        // fill the rest of the array using the recursive formula
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                // if s[i-1] == t[j-1], we can either use it or ignore it
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                }
                // if s[i-1] != t[j-1], we have to ignore it
                else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        // return the final answer
        return dp[s.length()][t.length()];
    }

    // Big O

    // The time complexity of this solution is O(s.length() * t.length()),
    // since we need to fill a two-dimensional array
    // with size (s.length() + 1) x (t.length() + 1).

    // The space complexity is also O(s.length() * (t.length()),
    // since we need to store the array.

}
