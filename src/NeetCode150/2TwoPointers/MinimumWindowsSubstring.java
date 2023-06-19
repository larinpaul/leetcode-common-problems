//// 2023/06/19 // 15:42 //

//// 76. Minimum Window Substring // Hard //

// Given two strings s and t of lengths m and n respectively, return the minimum window
// substring of s such that every character in t (including duplicates) is included in the
// window. If there is no such substring, return the empty string "".

// The testcases will be generated such that the answer is unique.

// Example 1:
// Input: s = "ADOBECODEBANC", t = 'ABC"
// Output: "BANC"
// Explanation: The minimum window substring "BANC" includes 'A',
// 'B', and 'C' from string t.

// Example 2:
// Input: s = "a", t = "a"
// Output: "a"
// Explanation: The entire string s is the minimum window.

// Example 3:
// Input: s = "a", t = "aa"
// Output: ""
// Explanation: Both 'a's from t must be included in the window.
// Since the largest window of s only has one 'a', return empty
// string.

// Constraints:
// * m == s.length
// * n == t.length
// * 1 <= m, n < 10^5
// * s and t consist of uppercase and lowercase English letters.

// Follow up: Could you find an algorithm that runs in O(m + n) time?

import java.util.HashMap;
import java.util.Map;

class MinimumWindowSubstring {

    // Explanation:

    // The idea is to use a sliding window technique to find the minimum window substring that
    // contains all the characters of t. We use two pointers, left and right, to maintain the current
    // window boundaries. We also use a hashmap, freq, to store the frequency of each character
    // in t, and another hashmap, window, to store the frequency of each character in the current
    // window. We also keep track of the number of matched characters, which is the number of
    // characters in t that have the same frequency in the current window as in t.

    // We start by moving the right pointer until we find a valid window, i.e., a window that contains
    // all the characters of t. To check if the window contains all characters of t, we compare the
    // count variable with the size of freq.

    // When we find a valid window, we try to shrink it b moving the left pointer until we reach an
    // invalid window, i.e., a window that misses some characters of t. We update the minimum
    // window substring if we find a smaller valid window. We repeat this process until we reach
    // the end of s.

    public String  minWindow(String s, String t) {

        // initialize the hashmap for t
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : t.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        // initialize the hashmap for the current window
        Map<Character, Integer> window = new HashMap<>();

        // initialize the pointers and the matched count
        int left = 0;
        int right = 0;
        int count = 0; // count of characters in t found in current window

        // initialize the minimum window substring in its length
        String minWindow = "";
        int minLength = Integer.MAX_VALUE;

        // loop until right reaches the end of s
        while (right < s.length()) {
            // get the current character at right
            char c = s.charAt(right);

            // if c is in t, update its frequency in window and check if it matches with freq
            if (freq.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).intValue() == freq.get(c).intValue()) {
                    count++; // increment the matched count
                }
            }

            // while we have a valid window, try to shrink it by moving left
            while (left <= right && count == freq.size()) {
                // update the minimum window substring and its length if we find a smaller valid window
                int currLen = right - left + 1;
                if (currLen < minLength) {
                    minLength = currLen;
                    minWindow = s.substring(left, right + 1);
                }

                // get the curretn character at left
                char d = s.charAt(left);

                // if d is in t, update its frequency in window and check if it breaks the match with freq
                if (freq.containsKey(d)) {
                    window.put(d, window.get(d) - 1);
                    if (window.get(d).intValue() < freq.get(d).intValue()) {
                        count--; // decrement the matched count
                    }
                }

                // move left forward
                left++;
            }

            // move right forward
            right++;
        }

        // return the minimum window substring or empty string if not found
        return minWindow;
    }

    // Big O:

    // The time complexity of this algorithm is O(m + n), where m is the length of s and n is the
    // length of t. This is because we traverse each character of s and t at most twice, once by the
    // right pointer and once by the left pointer.

    // The space complexity of this algorithm is O(n), where n is the length of t.
    // This is because we use two hashmaps of size n to store the frequency of characters in t
    // adn the frequency of characters in the current window.

}
