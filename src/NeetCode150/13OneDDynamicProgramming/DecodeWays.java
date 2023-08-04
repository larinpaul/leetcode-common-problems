//// 2023/08/04 // 13:52 //

//// 91. Decode Ways // Medium //

// A message containing letters from A-Z can be encoded into numbers using the following mapping:
// 'A' -> "1"
// 'B' -> "2"
// ...
// 'Z' -> "26"

// To decode an encoded message, all the digits must be grouped then mapped back into letters using the
// reverse of the mapping above (there may be multiple ways). For example, "11106" can be mapped into:
// * "AAJF" with the grouping (1 1 10 6)
// * "KJF" with grouping (11 10 6)

// Note that the grouping (1 11 06) is invalid because "06" cannot be mapped into 'F' since "6" is
// different from "06".

// Given a string s containing only digits, return the number of ways to decode it.

// The test cases are generated so that the answer fits in a 32-bit integer.

// Example 1:
// Input: s = "12"
// Output: 2
// Explanation: "12" could be decoded as "AB" (1 2) or "L" (12).

// Example 2;
// Input: s = "226"
// Output: 3
// Explanation: "226" could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).

// Example 3:
// Input: s = "06"
// Output: 0
// Explanation: "06" cannot be mapped to "F" because of the leading zero
// ("6" is different from "06").

// Constraints:
// * 1 <= s.length <= 100
// * s contains only digits and may contain leading zero(s).

class DecodeWays {

    // The problem is asking us to find the number of ways to decode a string to digits into
    // letters, using the mapping given in the problem statement. For example, "12" can be
    // decoded as "AB" or "L", so the answer is 2.

    // To solve this problem, you can use a dynamic programming approach. Dynamic
    // programming is a technique that breaks down a complex problem into smaller
    // subproblems, and solves them by reusing the results of previous subproblems. This way,
    // you can avoid unnecessary computations and save time.

    // The idea is to use an array dp of length n+1, where n is the length of the input string s.
    // dp[i] will store the number of ways to decode the substring s[0...i-1]. The base cases are:
    // * dp[0] = 1, because there is one way to decode an empty string.
    // * dp[1] = 0 if s[0] is '0', or 1 otherwise, because there is no way to decode a string
    // starting with '0', and one way to decode a single digit.

    // Then, for i from 2 to n, we can update dp[i] by considering two cases:
    // * If s[i-1] is not '0', then we can decode it as a single digit, and add dp[i-1] to dp[i].
    // * If s[i-2] and s[i-1] from a valid two-digit number between 10 and 26, then we can
    // decode it as a letter, and add dp[i-2] to dp[i].

    // The final answer will be dp[n], which is the number of ways to decode the whole string.

    // Here is the code in Java that implement this algorithm:
    public int numDecodings(String s) {
        // get the length of the input string
        int n = s.length();
        // create an array to store the number of ways for each substring
        int[] dp = new int[n+1];
        // base cases
        dp[0] = 1; // one way to decode an empty string
        dp[1] = s.charAt(0) == '0' ? 0 : 1; // no way to decode a string starting with '0'
        // loop from 2 to n
        for (int i = 2; i <= n; i++) {
            // get the last two digits
            int oneDigit = Integer.parseInt(s.substring(i-1, i));
            int twoDigits = Integer.parseInt(s.substring(i-2, i));
            // if the last digit is not '0', we can decode it as a single digit
            if (oneDigit > 0) {
                dp[i] += dp[i-1];
            }
            // if the last two digits form a valid number between 10 and 26,
            // we can decode it as a letter
            if (twoDigits >= 10 && twoDigits <= 26) {
                dp[i] += dp[i-2];
            }
        }
        // return the final answer
        return dp[n];
    }

    // The time complexity of this solution is O(n), where n is the length of the input string,
    // because we only need to iterate through the string once and update each element of the array in constant time.
    // THe space complexity is also O(n), because we need an array of
    // size n+1 to store the results.

}
