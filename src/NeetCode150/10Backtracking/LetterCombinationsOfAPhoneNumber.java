//// 2023/07/24 // 17:13 //

//// 17. Letter Combinations of a Phone Number // Medium //

// Given a string containing digits from 2-9 inclusive, return all possible letter
// combinations that the number could represent. Return the answer in any order.

// A mapping of digits to letters (just like on the telephone buttons) is given below. Note
// that 1 does not map to any letters.

// Image

// Example 1:
// Input: digits = "23"
// Output: ["ad","ae","af","bd","be","bf","cd","ce","cf

// Example 2:
// Input: digits = ""
// Output: []

// Example 3:
// Input: digits = "2"
// Output: ["a","b","c"]

// Constraints:
// * 0 <= digits.length <= 4
// * digits[i] is a digit in the range ['2', '9'].

import java.util.ArrayList;
import java.util.List;

class LetterCombinationsOfAPhoneNumber {

    // This problem can be solved with the help of a depth-first search
    // (DFS) algorithm. We can use an array or a hashmap to maintain the
    // mapping of digits to the letters. For each digit, we can get the
    // corresponding letters and then for each letter, we recursively get
    // the letter combinations for the remaining digits.

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }

        String[] mapping = {
                "0",
                "1",
                "abc",
                "def",
                "ghi",
                "jkl",
                "mno",
                "pqrs",
                "tuv",
                "wxyz",
        };

        letterCombinationsRecursive(result, digits, "", 0, mapping);
        return result;
    }

    private void letterCombinationsRecursive(
            List<String> result,
            String digits,
            String current,
            int index,
            String[] mapping
    ) {
        // Base case: if the current combination is the same length as the input digits, it's a valid combination
        if (index == digits.length()) {
            result.add(current);
            return;
        }

        // Get the letters corresponding to the current digits
        String letters = mapping[digits.charAt(index) - '0'];
        for (int i = 0; i < letters.length(); i++) {
            // Append each letter to the current combination and recurse on the remaining digits
            letterCombinationsRecursive(result, digits, current + letters.charAt(i), index + 1, mapping);
        }
    }

    // Big O:

    // The time complexity of this solution is O(4^n) where n is the
    // length of the input string. This is because in the worst case every
    // digit of the phone number can be 7 or 9 and we have 4 choices for
    // each digit.

    // The space complexity is also O(4^n) for the same reason because
    // in the worst case, if every digit is 7 or 9, we will end up with 4^n combinations

}
