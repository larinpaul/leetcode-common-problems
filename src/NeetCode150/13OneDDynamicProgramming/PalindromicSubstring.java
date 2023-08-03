//// 2023/08/03 // 22:38 //

//// 647. Palindromic Substrings // Medium //

// Given a string s, return the number of palindromic substrings in it:

// A string is a palindrome when it reads the same backward as forward.

// A substring is a contiguous sequence of characters within the string.

// Example 1:
// Input: s = "abc"
// Output: 3
// Explanation: Three palindromic strings: "a", "b", "c".

// Example 2:
// Input: s = "aaa"
// Output: 6
// Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".

// Constraints:

// * 1 <= s.length <= 1000
// * s consists of lowercase English letters.

class PalindromicSubstring {

    // Explanation:
    // To count the number of palindromic substrings in a given string, we can use
    // a technique called expand around center. This means that for each character or
    // pair of characters in the string, we try to expand the substring around them
    // as long as it is still a palindrome. For example, if the string is "aba",
    // we can expand around the center "b" to get "aba", and we can also expand around
    // the centers "a" and "a" to get "a" and "a". We can use two pointers, left and right,
    // to keep track of the boundaries of the substring, and increment the count
    // whenever we find a palindrome.

    // Solution:
    // To implement the expand around center technique, we can use a helper function
    // that takes the string and the left and right pointers as parameters, and returns
    // the number of palindromes found by expanding around them. We can call this function
    // for each character and each pair of characters in the string, and add up
    // the results to get the final answer.

    // Code:
    public int countSubstrings(String s) {
        // initialize the count to 0
        int count = 0;
        // loop through each character and pair of characters in the string
        for (int i = 0; i < s.length(); i++) {
            // expand around the center i
            count += expand(s, i, i);
            // expand around the center i and i + 1
            count += expand(s, i, i + 1);
        }
        // return the final count
        return count;
    }

    // helper function to expand around a center and return the number of palindromes found
    private int expand(String s, int left, int right) {
        // initialize the result to 0
        int result = 0;
        // while the pointers are within bounds and the substring is a palindrome
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            // increment the result
            result++;
            // move the pointers outward
            left--;
            right++;
        }
        // return the result
        return result;
    }

    // Big O:
    // The time complexity of this solution is O(n^2), where n is the length of the string.
    // This is because we loop through each character and pair of characters in the string,
    // which takes O(n) time, and for each center we expand until we reach the boundaries
    // or break the palindrome condition, which takes O(n) time in the worst case.
    // The space complexity is O(1), since we only use constant extra space
    // for the pointers and variables.

}
