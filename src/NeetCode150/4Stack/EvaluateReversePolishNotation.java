//// 2023/05/24 // 11:38 //

//// 150. Evaluate Reverse Polish Notation // Medium //

// You are given an array of strings tokens that represents
// an arithmetic expression in a Reverse Polish Notation.

// Evaluate the expression. Return an integer that represents the value of the expression.

// Note that:
// * The valid operators are '+', '-', '*', and '/'.
// * Each operand may be an integer or another expression.
// * The division between two integers always truncates towards zero.
// * There will not be any division by zero.
// * The input represents a valid arithmetic expression in a reverse polish notation.
// * The answer and all the intermediate calculations can be represented in a 32-bit integer.

// Example 1:
// Input: tokens = ["2","1","+","3","*"]
// Output: 9
// Explanation:
// ((2 + 1) * 3) = 9

// Example 2:
// Input: tokens = ["4","13","5","/","+"]
// Output: 6
// Explanation: (4 + (13 / 5)) = 6

// Example 3:
// Input: tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
// Output: 22
// Explanation: ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
// = ((10 * (6/ (12 * -11))) + 17) + 5
// = ((10 * (6 / -132)) + 17) + 5
// = ((10 * 0) + 17) + 5
// = (9 + 17) + 5
// = 17 + 5
// = 22

// Constraints:
// * 1 <= tokens.length <= 10^4
// * tokens[i] is either an operator: "+", "-", "*", or "/", or an integer in the range [-200, 200].

import java.util.Stack;

class EvaluateReversePolishNotation {

    // Solution: The idea is to use a stack to store the operands and evaluate the expression
    // from left to right. For each token, we check if it is an operator or an operand.
    // If it is an operand, we push it to the stack. If it is an operator, we pop two operands
    // from the stack and apply the operator to them. Then we push the result back to the stack.
    // At the end, the stack will have only one element which is the final answer.

    // The reason why wee use a stack is to follow the order of operations in reverse
    // polish notation. For example, if we have tokens = ["2","1","+","3","*"],
    // then the stack will look like this:

    // token // stack // operation //
    // 2    // [2]  // push 2
    // 2    // [2,1]  // push 1
    // +    // [3]  // pop 2 and 1, add them and push 3
    // 2    // [3,3]  // push 3
    // *    // [9]  // pop 3 and 3, multiply them and push 9

    // Code:
    public int evalRPN(String[] tokens) {
        // Initialize a stack to store operands
        Stack<Integer> stack = new Stack<>();
        // Loop through all tokens
        for (String token : tokens) {
            // Check if token is an operator
            if (isOperator(token)) {
                // Pop two operands from the stack
                int right = stack.pop();
                int left = stack.pop();
                // Apply the operator to them
                int result = applyOperator(token, left, right);
                // Push the result back to the stack
                stack.push(result);
            } else {
                // Token is an operand, parse it as an integer and push it to the stack
                int num = Integer.parseInt(token);
                stack.push(num);
            }
        }
        // Return the final answer
        return stack.pop();
    }

    // Helper method to check if a token is an operator
    private boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    // Helper method to apply an operator to two operands
    private int applyOperator(String token, int left, int right) {
        switch (token) {
            case "+":
                return left + right;
            case "-":
                return left - right;
            case "*":
                return left * right;
            case "/":
                return left / right;
            default:
                return 0;
        }
    }

    // Big O:
    // The time complexity of this algorithm is O(n), where n is the length of tokens array.
    // This is because we traverse each token once and push and pop each operand at most once.
    // The space complexity is O(n), where n is the length of token array.
    // This is because we use a stack to store operands.
    // In the worst case, when all tokens are operands, we will
    // push all tokens to the stack.

}



