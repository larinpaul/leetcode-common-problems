//// 2023/05/22 // 23:01 //

//// 567. Permutation in String // Medium //

////

// Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.

// In other words, return true if one of s1's permutations is the substring of s2.

// Example 1:
// Input: s1 = "ab", s2 == "eidbaooo"
// Output: true
// Explanation: s2 contains one permutation of s1 ("ba").

// Example 2:
// Input: s1 = "ab", s2 = "eidboaoo"
// Output: false

// Constraints:
// * 1 <= s1.length, s2.length <= 10^4
// * s1 and 2 consist of lowercase English letters.

class PermutationInString {

    // Explanation:
    // * We first check some edge cases where the input strings are null
    // or the length of s1 is greater than the length of s2.
    // In these cases, we return false.
    // * We then create an array of size 26 to store the frequency of each character in s1.
    // We iterate over s1 and increment the corresponding index in the array for each character.
    // For example, if s1 = "ab", then freq[0] = 1 and freq1 = 1.
    // * We also initialize a variable count to store the number of characters that need to match
    // in the sliding window. Initially, this is equal to the length of s1.
    // * We then use two pointers, left and right, to represent the boundaries of the sliding window.
    // Initially, both are at index 0.
    // * We use a while loop to move the right pointer until it reaches the end of s1.
    // In each iteration, we do the following:
    // - We get the character at the right pointer and update the frequency array
    // by decrementing the corresponding index. For example, if rc = 'e', then freq[4]-.
    // - We also check if the frequency of this character was positive before decrementing.
    // This means that this character is present in s1 adn we need to match it in the window.
    // So we decrement the count variable as well.
    // For example, if rc = 'a' and freq[0] = 1, then count-- and freq[0] = 0.
    // - We then increment the right pointer by one.
    // - We check if the count variable is zero. This means that we have matched all the characters in s1
    // within the current window. So we return true as we have found a permutation.
    // - We also check if the window size is equal to the length of s1. This means that we
    // need to move the left pointer as well to maintain a fixed window size.
    // So we have to do the following:
    // -- We get the character at the left pointer and update the frequency array by
    // incrementing the corresponding index. For example, if lc = 'n', then freq1++.
    // -- We also check if the frequency of this character was non-negative before incrementing.
    // This means that this character was present in s1 adn we have removed it from the window.
    // So we increment the count variable as well.
    // For example, if lc = 'a' and freq[0] = 0, then count++ and freq[0] = 1.
    // -- We then increment the left pointer by one.
    // - If we exit the while loop without returning true, it means
    // that we have not found any permutation of s1 in s2. So we return false.

    public boolean checkInclusion(String s1, String s2) {
        // edge cases
        if (s1 == null || s2 == null || s1.length() > s2.length()) return false;
        // create a frequency map for s1
        int[] freq = new int[26];
        for (char c : s1.toCharArray()) {
            freq[c - 'a']++;
        }
        // use a sliding window to check s2
        int left = 0, right = 0, count = s1.length();
        while (right < s2.length()) {
            // move right pointer and update count and frequency
            char rc = s2.charAt(right);
            if (freq[rc - 'a'] > 0) {
                count--;
            }
            freq[rc - 'a']--;
            right++;
            // if count is zero, we found a permutation
            if (count == 0) return true;
            // if window size is equal to s1 length, move left pointer and update count and frequency
            if (right - left == s1.length()) {
                char lc = s2.charAt(left);
                if (freq[lc - 'a'] >= 0) {
                    count++;
                }
                freq[lc - 'a']++;
                left++;
            }
        }
        // no permutation found
        return false;
    }

    // The time complexity of this solution is O(n), where n is the length of s2.
    // This is because we only iterate over each character in s2 once using the sliding window technique.

    // The space complexity of this solution is O(1), because we only use a constant size array to
    // store the frequency of characters in s1.

}
