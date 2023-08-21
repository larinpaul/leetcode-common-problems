//// 2023/08/21 // 10:36 //

//// 139. Word Break // Medium //

// Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a
// space-separated sequence of one or more dictionary words.

// Note that the same word in the dictionary may be reused multiple times in the segmentation.

// Example 1:
// Input: s = "leetcode", wordDict = ["leet","code"]
// Output: true
// Explanation: Return true because "leetcode" can be segmented as "leet code".

// Example 2:
// Input: s = "applepenapple", wordDict = ["apple","pen"]
// Output: true
// Explanation: Return true because "applepenapple" can be segmented as
// "apple pen apple".
// Note that you are allowed to reuse a dictionary word.

// Example 3:
// Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
// Output: false

// Constraints:
// * 1 <= s.length <= 300
// * 1 <= wordDict.length <= 1000
// * 1 <= wordDict[i].length <= 20
// * s and wordDict[i] consist of only lowercase English letters.
// * All the strings of wordDict are unique.


import java.util.List;

class WordBreak {

    // Problem Explanation:
    // The problem asks us to determine whether a given string s can be
    // segmented into a space-separated sequence of one or more words from
    // a given dictionary wordDict. We need to check if there exists a valid
    // segmentation of s using words from wordDict.

    // For example, given s = "leetcode" and wordDict = ["leet","code"],
    // we can segment s as "leet code", which is a valid segmentation.

    // Solution:
    // To solve this problem we can use a dynamic programming approach.
    // Here's the general idea:
    // 1. Create a boolean array dp of size n+1, where n is the length of the
    // string s. Each element dp[i] will indicate whether the substring
    // ending at index i can be segmented into words rom wordDict.
    // 2. Initialize dp[0] as true to represent an empty string, which can
    // always be segmented.
    // 3. Iterate through each index i from 1 to n:
    // * For each index j from 0 to i-1, check if dp[j] is true (indicating
    // that the substring ending at index j can be segmented) and if the
    // substring from index j+1 to i (inclusive) is present in wordDict.
    // * If both conditions are satisfied, set dp[i] to true and break the
    // inner loop.
    // 4. Finally, return dp[n], which indicates whether the entire string s can
    // be segmented.

    // Code:
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }

    // Time complexity:
    // The time complexity of this solution is O(n^3), where n is the length of
    // the string s. The nested loops iterate through all possible substrings of s,
    // resulting in an O(n^2) time complexity. Additionally, the
    // wordDict.contains() operation has a complexity of O(n) in the worst
    // case, resulting in an overall time complexity of O(n^3).

    // Space Complexity:
    // The space complexity of this solution is O(n), where n is the length of the
    // string s. We use an additional boolean array dp of size n+1 to store the
    // intermediate results during the dynamic programming process.

}
