//// 2023/08/28 // 8:51 //

//// 678. Valid Parenthesis String // Medium //

// Given a string s containing only three types of characters: '(', ')' and '*', return true if s is valid.

// The following rules define a valid string:
// * Any left parenthesis '(' must have a corresponding right parenthesis ')'.
// * Any right parenthesis ')' must have a corresponding left parenthesis '('.
// * Left parenthesis '(' must also go before the corresponding right parenthesis ')'.
// * '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty
// string "".

// Example 1:
// Input: s = "()"
// Output: true

// Example 2:
// Input: s = "(*)"
// Output: true

// Example 3:
// Input: s = "(*))"
// Output: true

// Constraints:
// * 1 <= s.length <= 100
// * s[i] is '(', ')' or '*'.


import javax.print.DocFlavor;

class ValidParenthesisString {

    // To solve this problem of determining whether a given string of
    // parentheses and asterisks is valid, we can use a greedy approach.

    // Explanation:
    // 1. We can keep track of the minimum and maximum possible number of
    // open parentheses encountered so far.
    // 2. Iterate through the string from left to right.
    // 3. For each character encountered:
    // * If it is '(', increment both the minimum and maximum counts.
    // * If it is ')', decrement both the minimum and maximum counts.
    // * If it is '*', we have three options:
    // ** Treat it as an empty string,decrement the maximum count.
    // ** Treat it as an opening parenthesis '(', increment both the
    // minimum and maximum counts.
    // ** Treat it as a closing parenthesis ')', decrement both the
    // minimum and maximum counts.
    // * At any point, if the maximum count becomes negative, it means
    // there are more closing parentheses than opening parentheses
    // and asterisks encountered so far, and it is not possible to form a
    // valid string. Return false.
    // * If the minimum count becomes negative, update it to 0 because
    // we cannot have a negative number of opening parentheses.
    // 4. After iterating through the string, if the minimum count is 0, it means
    // that all opening parentheses have been balanced with corresponding
    // closing parentheses or treated as empty strings. Return true;
    // Otherwise, return false.

    public boolean checkValidString(String s) {
        int minCount = 0;
        int maxCount = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                minCount++;
                maxCount++;
            } else if (c == ')') {
                minCount = Math.max(minCount - 1, 0);
                maxCount--;
                if (maxCount < 0) {
                    return false;
                }
            } else { // c == '*'
                minCount = Math.max(minCount - 1, 0);
                maxCount++;
            }
        }

        return minCount == 0;
    }

    // The time complexity of this solution is O(n), where n is the length of the string.
    // It iterates through the string once, performing constant-time operations for each character.
    // Therefore, the overall time complexity is linear.

}
