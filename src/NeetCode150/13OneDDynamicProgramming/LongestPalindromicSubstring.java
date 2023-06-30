//// 2023/06/30 // 17:12 //

//// Given a string s, return the longest palindromic substring in s.

// Example 1:
// Input: s = "babad"
// Output: "bab"
// Explanation: "aba" is also a valid answer.

// Example 2:
// Input: s = "cbbd"
// Output: "bb"

// Constraints:
// * 1 <= s.length <= 1000
// * s consist of only digits and English letters.

// Explanation:
// A palindrome is a string that is the same when read forward or backward, such as
// "racecar" or "madam". The longest palindromic substring of a given string is the longest substring
// that is also a palindrome. For example, the longest palindromic substring of "babad"
// is either "bab" or "aba". To find the longest palindromic substring,
// we can use a dynamic programming approach. We can define a boolean array dp[i][j]
// that indicates whether the substring from index i to index j of the original string
// is a palindrome or not.
// We cal fill this array using the following rules:
// * A single character is always a palindrome, so dp[i][i] = true for all i.
// * A two-character substring is a palindrome if both characters are the same,
// so dp[i][i+1] = true if s[i] == s[i+1].
// * A longer substring is a palindrome if its first and last characters are the same and its inner
// substring is also a palindrome, so dp[i][j] = true if s[i] == s[j] and dp[i+1][j-1] = true.

// We can fill the array in a bottom-up manner, starting from the shorter substrings and moving to the
// longer ones. We also keep track of the length and start index of the longest palindromic substring we
// have found so far. At the end, we return the substring from the start index to the start index plus the
// length.

class LongestPalindromeSubstring {

    class Solution {
        public String longestPalindrome(String s) {
            // Initialize the longest palindrome to be empty
            String longest = "";
            // Loop over each character in the string
            for (int i = 0; i < s.length(); i++) {
                // Check for odd-length palindromes centered at i
                String odd = expand(s, i, i);
                // Update the longest palindrome if needed
                if (odd.length() > longest.length()) {
                    longest = odd;
                }
                // Check for even-length palindromes centered at i and i+1
                String even = expand(s, i, i + 1);
                // Update the longest palindrome if needed
                if (even.length() > longest.length()) {
                    longest = even;
                }
            }
            // Return the longest palindrome
            return longest;
        }

        // Helper method to expand around a center and return the longest palindrome
        private String expand(String s, int left, int right) {
            // While the left and right pointers are within bounds and the characters match
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                // Move the pointers outward
                left--;
                right++;
            }
            // Return the substring between the pointers (exclusive)
            return s.substring(left + 1, right);
        }
    }


    // Big O:
    // The time complexity of this solution is O(n^2), where n is the length of the input string.
    // This is because we need to fill an n by n array with boolean values, which takes O(n^2) times.
    // The space complexity is also O(n^2), because we need to store an n by n array in memory.

}
