//// 2023/04/15 // 12:18 //

//// 20. Valid Parentheses // Easy

// Given a string s containing just the characters '(', ')', '{', '}', '[' amd ']',
// determine if the input string is valid.

// An input string is valid if:
// Open brackets must be closed by the same type of brackets.
// Open brackets must be closed in the correct order.
// Every close bracket has a corresponding open bracket of the same type.

// Example 1:
// Input: s = "()"
// Output: true

// Example 2:
// Input: s = "()[]{}"
// Output: true

// Example 3:
// Input: s = "(]"
// Output: false

// Constraints:
// 1 <= s.length <= 10^4
// s consists of parentheses only '()[]{}'.

// Import the Stack class from java.util package
import java.util.Stack;

class ValidParentheses {

    // Define a method that takes a String of parentheses
    // and returns a boolean value
    public boolean isValid(String s) {
        // Create a Stack object to store the opening parentheses
        Stack<Character> stack = new Stack<>();
        // Loop through each character of the String
        for (char c : s.toCharArray()) {
            // If the character is an opening parenthesis, push it to the stack
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }
            // If the character is a closing parenthesis,
            // check if it matches with the top of the stack
            else if (c == ')' && !stack.isEmpty() && stack.peek() == '(') {
                // If it matches, pop the stack
                stack.pop();
            }
            else if (c == '}' && !stack.isEmpty() && stack.peek() == '{') {
                // If it matches, pop the stack
                stack.pop();
            }
            else if (c == ']' && !stack.isEmpty() && stack.peek() == '[') {
                // If it matches, pop the stack
                stack.pop();
            }
            // If the character is not a valid parenthesis or does not match
            // with the top of the stack, return false
            else {
                return false;
            }
        }
        // After looping through the string, check if the stack is empty or not
        // If the stack is empty, it means all the parentheses are matched
        // and valid, so return true
        // If the stack is not empty, it means some parentheses are not matched
        // or valid, so return false
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(new ValidParentheses().isValid("()")); // true
        System.out.println(new ValidParentheses().isValid("()[]{}")); // true
        System.out.println(new ValidParentheses().isValid("(]")); // false
        System.out.println(new ValidParentheses().isValid("()-")); // false
    }

}





