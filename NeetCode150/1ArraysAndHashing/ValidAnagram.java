//// 2023/04/14 // 23:58 //

//// 2042. Valid Anagram

// Given two strings s and t, return true if t is an anagram of s, and false otherwise

// An Anagram is a word or phrase formed by rearranging the letters of a different
// word or phrase, typically using all the original letters exactly one.

// Example 1:
// Input: s = "anagram", t = "nagaram"
// Output: true

// Example 2:
// Input: s = "rat", t = "car"
// Output: false

// Constraints:
// 1 <= s.length, t.length <= 5 * 10^4
// s and t consist of lowercase English letters.

// Follow up: What if the inputs contain Unicode characters?
// How would you adapt your solution to such a case?

class ValidAnagram {

    // This method checks if two strings are anagrams of each other
    public boolean isAnagram(String s, String t) {
        // If the two strings have different length, they can't be anagrams
        if (s.length() != t.length()) return false;
        // Create an array to store the frequency of each character
        int[] store = new int[26];
        // Iterate over each chacracter in both strings
        for (int i = 0; i < s.length(); i++) {
            // Increment the count of the characters in the first string
            store[s.charAt(i) - 'a']++;
            // Decrement the count of the characters in the second string
            store[t.charAt(i) - 'a']--;
        }
        for (int n : store) if (n != 0) return false;
        // If we reach this coint, the two strings are anagrams!
        return true;
    }


}




