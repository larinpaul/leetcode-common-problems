//// 2023/07/23 // 11:46 //

//// 131. Palindrome Partitioning // Medium //

// Given a string s, partition s uch that every substring of the partition if a palindrome
// . Return all possible palindrome partitioning of s.

// Example 1:
// Input: s = "aab"
// Output: [["a","a","b"],["aa","b"]]

// Example 2:
// Input: s = "a"
// Output: [["a"]]

// Constraints:
// * 1 <= s.length <= 16
// * s contains only lowercase English letters.

import java.util.ArrayList;
import java.util.List;

class PalindromePartitioning {

    // Explanation
    // This problem can be solved using depth-first search (DFS) and dynamic programming (DP).

    // First, we need to build a 2D DP array. DP[i][j] will be true if the
    // substring s[i...j] can form a palindrome, otherwise it's false. THen
    // we do a DFS traversal of the string, each time we find a palindrome
    // substring, we add it to the current partition list and do a recursion
    // on the rest of the string. If we've reached the end of the string, it
    // means we've found a valid partitioning, so we add the current
    // partition list to the result list.

    // Solution
    // First, we need to initialize a list that will store the result and a list
    // that will store the current partition. We also need to initialize a DP array.

    // Then we start from the first character and move to the right. For
    // each position, we check if the substring starting from the leftmost
    // character to the current character forms a palindrome. If it does,
    // we add it to the current partition list and recursively partition the
    // remaining substring. When we have partitioned the entire string,
    // we add the current partition to the result.

    // The time complexity is O(n*(2^n)) where n is the length of the
    // string because in the worst case, we could end up with all the
    // substring of the string which takes O(2^n) and to generate a
    // substring, it takes O(n) time.

    // Code
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> currentPartition = new ArrayList<>();
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                if (s.charAt(i) == s.charAt(j) && (i - j <= 2 || dp [j + 1][i - 1])) {
                    dp[j][i] = true;
                }
            }
        }
        dfs(result, dp, 0, s, currentPartition);
        return result;
    }

    private void dfs(List<List<String>> result, boolean[][] dp, int start, String s, List<String> currentPartition) {
        if (start == s.length()) {
            List<String> temp = new ArrayList<>(currentPartition);
            result.add(temp);
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if (dp[start][i]) {
                currentPartition.add(s.substring(start, i + 1));
                dfs(result, dp, i + 1, s, currentPartition);
                currentPartition.remove(currentPartition.size() - 1);
            }
        }
    }

    // Big O

    // Time Complexity
    // The time complexity of the above solution is O(n*(2^n)) where n is
    // the length of the string. This is because in the worst-case scenario,
    // we could end up with all the substrings of the string which takes
    // O(2^n) and to generate a substring, it takes O(n) time.

    // The space complexity is O(n^2) due to the DP array and the
    // recursion stack. The DP array is a square matrix of size n x n and in
    // the worst case, the depth of the recursive call stack can go up to n.

}
