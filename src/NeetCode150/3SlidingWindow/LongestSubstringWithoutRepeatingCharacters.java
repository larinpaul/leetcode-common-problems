//// 2023/05/20 // 18:57 //

//// 3. Longest Substring Without Repeating Characters // Medium //

// Given a string, find the length of the longest substring without repeating characters.

// Example 1:
// Input: "abcabcbb"
// Output: 3
// Explanation: The answer is "abc", with the length of 3.

// Example 2:
// Input: s = "bbbbb"
// Output: 1
// Explanation: The answer is "b", with the length of 1.

// Example 3:
// Input: 3
// Explanation: The answer is "wke", with the length of 3.
// Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

// Constrains:
// * 0 <= s.length <= 5 * 10^4
// * s consists of English letters, digits, symbols and spaces.

import java.util.HashSet;
import java.util.Set;

class LongestSubstringWithoutRepeatingCharacters {

    // Solution:

    // The idea is to use a sliding window technique to keep track of the current
    // substring without repeating characters. We use a hash set to store the characters in the
    // current window and a variable to store the maximum length so far.
    // We iterate over the string and for each character, we check if it is already in the hash set.
    // If it is, we remove the characters from the left of the window
    // until we find the duplicate character and remove it as well.
    // Then we add the current character to the hash set and update the maximum length if needed.
    // If the character is not in the hash set, we simply add it to the hash set
    // adn update the maximum length if needed.

    // Explanation: The time complexity of this algorithm is O(n), where n is the length of the string,
    // because we only scan each character once and the size of the hash set is bounded
    // by the size of the alphabet. The space complexity is O(n), where m is the size of the alphabet,
    // because we only store at most m distinct characters in the hash set.

    public int lengthOfLongestSubstring(String s) {
        // Initialize a hash set to store the characters in the current window
        Set<Character> set = new HashSet<>();
        // Initialize a variable to store the maximum length so far
        int maxLen = 0;
        // Initialize two pointers to indicate the left and right boundaries of the window
        int left = 0;
        int right = 0;
        // Loop through the string
        while (right < s.length()) {
            // Get the current character
            char c = s.charAt(right);
            // Check if it is already in the hash set
            if (set.contains(c)) {
                // Remove the characters from the left of the window until we find the duplicate character and remove it as well
                while (left < right && s.charAt(left) != c) {
                    set.remove(s.charAt(left));
                    left++;
                }
                set.remove(s.charAt(left));
                left++;
            }
            // Add the current character to the hash set
            set.add(c);
            // Update the maximum length if needed
            maxLen = Math.max(maxLen, right - left + 1);
            // Move the right pointer forward
            right++;
        }
        // Return the maximum length
        return maxLen;
    }

    // Big O:
    // O(n) time and O(m) space, where n is the length of the string and m is the size of the alphabet

}






