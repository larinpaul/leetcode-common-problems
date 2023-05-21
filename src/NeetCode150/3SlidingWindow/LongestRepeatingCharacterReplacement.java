//// 2023/05/21 // 22:43 //

//// 424. Longest Repeating Character Replacement

// You are given a string s and an integer k.
// You can choose any character of the string and change it to any other uppercase English character.
// You can perform this operation at most k times.

// Return the length of the longest substring containing the same letter
// you get after performing the above operations.

// Example 1:
// Input: s = "ABAB", k = 2
// Output: 4
// Explanation: Replace the two 'A's with two 'B's or vice versa.

// Example 2:
// Input: s = "AABABBA", k = 1
// Output: 4
// Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
// The substring "BBBB" has the longest repeating letters, which is 4.
// There may exists other ways to achieve this answer too.

// Constraints:
// * 1 <= s.length <= 10^5
// * s consists of only upppercase English letters.
// * 0 <= k <= s.length

// This is a coding problem that can be solved using the sliding window technique.
// The idea is to maintain a window of characters that can be converted into a homogeneous
// substring (a substring of repeated characters) by changing at most k characters.
// We keep tack of the most frequent character in the window and the number of changes required to
// make the window homogeneous. We update the window by expanding it to the right if possible,
// or shrinking it from the left if not. We also update the maximum length of the
// homogeneous substring we have seen so far.

// Here is a possible solution, explanation, code and big O for this problem:

// Solution: Use a sliding window technique with a frequency map of characters in the window.

// Explanation:
// * Initialize a frequency map that stores the count of each character in the window.
// * Initialize two pointers, left and right, that mark the boundaries of the window.
// * Initialize a variable maxCount that stores the maximum frequency of any character in the window.
// * Initialize a variable maxLength that stores the maximum length of the homogeneous substring seen so far.
// * Loop through the string s with the right pointer, and update the frequency map with the current character.
// * Update maxCount with the maximum frequency of any character in the window.
// * If the window size (right - left + 1) minus maxCount is greater than k, it means we
// cannot make the window homogeneous by changing at most k character.
// In this case, we need to shrink the window from the left until this condition is false.
// We also need to update the frequency map and maxCount accordingly.
// * Update maxLength with the maximum of itself and the current window size.
// * Return maxLength as the final answer.

class LongestRepeatingCharacterReplacemenent {

    public int characterReplacement(String s, int k) {
        // frequency map of characters in the window
        int[] freq = new int[26];
        // left and right pointers of the window
        int left = 0;
        int right = 0;
        // maximum frequency of any character in the window
        int maxCount = 0;
        // maximum length of homogeneous substring
        int maxLength = 0;
        // loop through the string with right pointer
        while (right < s.length()) {
            // update frequency map with current character
            char c = s.charAt(right);
            freq[c - 'A']++;
            // update maxCount with maximum frequency
            maxCount = Math.max(maxCount, freq[c - 'A']);
            // if window size minus maxCount is greater than k
            // we cannot make it homogeneous by changing at most k characters
            // so we need to shrink the window from left
            while (right - left + 1 - maxCount > k) {
                // update frequency map and maxCount accordingly
                char d = s.charAt(left);
                freq[d - 'A']--;
                maxCount = getMaxCount(freq);
                // move left pointer forward
                left++;
            }
            // update maxLength with maximum of itself and current window size
            maxLength = Math.max(maxLength, right - left + 1);
            // move right pointer forward
            right++;
        }
        // return maxLength as final answer
        return maxLength;
    }

    // helper method to get maximum frequency from frequency map
    private int getMaxCount(int[] freq) {
        int max = 0;
        for (int f : freq) {
            max = Math.max(max, f);
        }
        return max;
    }

    // Big O:
    // * Time complexity: O(n), where n is the length of s.
    // We loop through s once with right pointer,
    // and move left pointer at most n times.
    // Each update of frequency map and maxCount takes constant time.
    // * Space complexity: O(1), since we use a fixed array of length 26 to store frequencies.

}
