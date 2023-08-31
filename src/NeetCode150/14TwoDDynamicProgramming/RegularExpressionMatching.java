//// 2023/08/31 // 9:06 //

//// 10. Regular Expression Matching // Hard //

// Given an input string s and a pattern p, implement regular expression matching with support for '.' and
// '*' where:
// * '.' Matches any single character
// * '*' Matches zero or more of the preceeding element.

// The matching should cover the entire input string (not partial).

// Example 1:
// Input: s = "aa", p = "a"
// Output: false
// Explanation: "a" does not match the entire string "aa".

// Example 2:
// Input: s = "aa", p = "a*"
// Output: true
// Explanation: '*' means zero or more of the preceeding element, 'a'. Therefore,
// by repeating 'a' once, it becomes "aa".

// Example 3:
// Input: s = "ab", p = ".*"
// Output: true
// Explanation: ".*" means "zero or more (*) of any characters (.)".

// Constraints:
// * 1 <= s.length <= 20
// * 1 <= p.length <= 20
// * s contains only lowercase English letters.
// * p contains only lowercase English letters, '.', and '*'.
// * It is guaranteed for each appearance of the character '*',
// there will be a previous valid character to match.

class RegularExpressionMatching {

    // To solve the "Regular Expression Matching" problem, we need to
    // implement a regular expression matching algorithm that supports the '.'
    // and '*' characters. Here's an explanation of the problem, and optimal
    // solution, the code, and the time complexity analysis:

    // Optimal Solution:
    // To solve this problem, we can use a dynamic programming approach.
    // We'll create a two-dimensional boolean array dp, where dp[i][j]
    // represents whether the substring s[0...i-1] matches the pattern
    // p[0...j-1]. We'll initialize dp[0][0] as true sine an empty pattern
    // matches an empty string.

    // We'll fill in the dp array by iterating over all possible substrings of s and
    // patterns of p. For each position (i, j) in the dp array, we'll consider
    // three cases:
    // 1. The characters at s[i-1] and p[j-1] match exactly or p[j-1] is '.':
    // * In this cade, dp[i][j] depends on whether the substring
    // s [0...i-2] matches the pattern p[0...j-2] (i.e., dp[i-1][j-1] is true.
    // 2. The character at p[j-1] is '*':
    // * In this case, we have two subclasses:
    //   ** The character before '*' in p matches the character at s[i-1] or is '.':
    //    *** In this subclass, dp[i][j] depends on whether the
    //        substring s[0...i-2] matches the pattern p[0...j-1]
    //        (i.e., dp[i-1][j] is true).
    // * The character before '*' in p does not match the character at s[i-1]:
    //   ** In this subcase, dp[i][j] depends on whether the
    //      substring s[0...i-1] matches the pattern p[0...j-3]
    //      *i.e., dp[i][j-2] is true).
    // 3. The characters at s[i-1] and p[j-1] do not match:
    // * In this case, dp[i][j] is false.

    // After filling the dp array, the value of dp[s.length()][p.length()]
    // will represent whether the entire input string s matches the pattern p.

    // Java Code:
    // Here's the Java code that implements the optimal solution:
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;

        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    if (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.') {
                        dp[i][j] = dp[i - 1][j] || dp[i][j - 2];
                    } else {
                        dp[i][j] = dp[i][j - 2];
                    }
                }
            }
        }

        return dp[m][n];
    }

    // Time Complexity Analysis:
    // The time complexity of this solution is O(m * n), where m is the length of
    // the string s and n is the length of the pattern p. We fill in an m x n DP
    // array, and each cell update takes constant time.

    // Therefore, the optimal solution has a time complexity of O(m * n).

    // Space complexity Analysis:
    // The space complexity is O(m * n) as well because we use a two-dimensional DP array


    //// But there's another solution, with even faster speed, but that uses more memory:

    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        Boolean[][] memo = new Boolean[m + 1][n + 1];
        return isMatchRecursive(s, p, 0, 0, memo);
    }

    private boolean isMatchRecursive(String s, String p, int i, int j, Boolean[][] memo) {
        if (memo[i][j] != null) {
            return memo[i][j];
        }

        boolean result;

        if (j == p.length()) {
            result = (i == s.length());
        } else {
            boolean currentMatch = (i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.'));

            if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
                result = isMatchRecursive(s, p, i, j + 2, memo) ||
                        (currentMatch && isMatchRecursive(s, p, i + 1, j, memo));
            } else {
                result = currentMatch && isMatchRecursive(s, p, i + 1, j + 1, memo);
            }
        }

        memo[i][j] = result;
        return result;
    }


}
