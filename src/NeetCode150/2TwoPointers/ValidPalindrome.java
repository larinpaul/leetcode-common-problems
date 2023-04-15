//// 2023/04/15 // 10:32 //

//// 125. Valid Palindrome

// A phrase is a palinrome if, after converting all uppercase letters into lowercase letters and removing all
// non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include
// letters and numbers

// Given a string s, return true if it is a palindrome, or false otherwise.

// Example 1:
// Input: s = "A man, a plan, a canal: Panama"
// Output: true
// Explanation: "Amanaplanacanalpanama" is a palindrome.

// Example 2:
// Input: s = "race a car"
// Output: false
// Explanation: "raceacar" is not a palindrome

// Example 3:
// Input: s = " "
// Output: true
// Explanation: s is an empty string "" after removing non-alphanumeric
// characters.
// Since an empty string reads the same forward and backward, it is a palindrome

// Constraints:
// 1 <= s.length <= 2 * 10^5
// s consists only of printable ASCII characters

class ValidPalindrome {
    // Define a method that takes a String as an input and returns a boolean
    // depending on whether it is a palindrome or not
    public static boolean isPalindrome(String s) {
        // Convert the string to lowercase and remove all non-alphanumeric characters
        s = s.toLowerCase();
        s = s.replaceAll("[^a-z0-9]", "");
        // Initialize two pointers at the start and end of the string
        int left = 0;
        int right = s.length() - 1;
        // Loop until the pointers meet or cross each other
        while (left < right) {
            // If the characters at the pointers are not equal, return false
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            // Otherwise, move the pointers towards the center
            left++;
            right--;
        }
        // If the loop ends without returning false, return true
        return true;
    }

    public static void main(String[] args) {
        // Test some examples
        System.out.println(isPalindrome("A man, a plan, a canal: Panama")); // true
        System.out.println(isPalindrome("race a car")); // false
        System.out.println(isPalindrome("race car")); // true
        System.out.println(isPalindrome(" ")); // true
    }

}






// The main idea is to compare the first and last characters of the string
// after removing all non-alphanumeric characters and converting to lowercase.
// If they are equal, we move the pointers towards the center
// and repeat the comparison. If they are not equal, we return false.
// If we read the center without finding any mismatch, we return true.

// Some alternative solutions are using recursion,
// revering the string and comparing with the original,
// or using a stack data structure












