//// 2023/08/14 // 10:22 //

//// 72. Edit Distance // Medium //

// Given two strings word1 and word2, return the minimum number of operations required to convert
// word1 to word2.

// You have the following three operations permitted on a word:
// * Insert a character
// * Delete a character
// * Replace a character

// Example 1:
// Input: word1 = "horse", word2 = "ros"
// Output: 3
// Explanation:
// horse -> rorse (replace 'h' with 'r')
// rorse -> rose (remove 'r')
// rose -> ros (remove 'e')

// Example 2:
// Input: word1 = "intention", word2 = "execution"
// Output: 5
// Explanation:
// intention -> inention (remove 't')
// inention -> enention (replace 'i' with 'e')
// enention -> exention (replace 'n' with 'x')
// exention -> exection (replace 'n' with 'c')
// exection -> execution (insert 'u')

// Constraint:
// * 0 <= word1.length, word2.length <= 500
// * word1 and word2 consist of lowercase English letters.


class EditDistance {

    // To solve the problem, we can use dynamic programming. We define a 2D
    // DP array dp where dp[i][j] represents the minimum number of
    // operations required to convert word1[0:i-1] to word2[0:j-1].

    // We initialize the first row and the first column of the dp array as follows:
    // * dp[0][j] represents the number of operations requires to convert
    // an empty string to word2[0:j-1], which is j (inserting j characters).
    // * dp[i][0] represents the number of operations required to convert
    // word1[0:i-1] to an empty string, which is i (deleting i characters).

    // For the rest of the dp array, we can fill in the values using the following
    // recursive formula:
    // * If word1[i-1] is equal to word2[j-1], we don't need to perform
    // any operation. So dp[i][j] = dp[i-1][j-1].
    // * If word1[i-1] is not equal to word2[j-1], we have three options:
    // 1. Replace word1[i-1] with word2[j-1]: dp[i][j] = dp[i-1][j-1] + 1.
    // 2. Delete word1[i-1]:dp[i][j] = dp[i-1][j] + 1.
    // 3. Insert word2[j-1] after word1[i-1]:dp[i][j] = dp[i][j-1] + 1.
    // The minimum number of operations among these three options
    // will be the value of dp[i][j].

    // After filling in the dp array, the minimum number of operations required
    // to convert word1 to word2 will be stored in dp[word1.length()] [word2.length()].

    // Here's the implementation in Java:
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }

        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    int replace = dp[i - 1][j - 1] + 1;
                    int delete = dp[i - 1][j] + 1;
                    int insert = dp[i][j - 1] + 1;
                    dp[i][j] = Math.min(replace, Math.min(delete, insert));
                }
            }
        }

        return dp[m][n];
    }

    // Big O:

    // The time complexity of this solution is O(m * n), where m and n are the
    // lengths of word1 and word2, respectively.
    // We fill in a 2D array of size (m + 1) x (n + 1) in a nested loop.

    // The space complexity is also O(m * n) because of the dp array.

}
