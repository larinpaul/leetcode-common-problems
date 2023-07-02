//// 2023/07/02 // 21:51 //

//// 22. Generate Parentheses // Medium //

// Given n pairs of parentheses, write a function to generate all combinations of
// well-firmed parentheses.

// Example 1:
// Input: n = 3
// Output: ["((()))","(()())","(())()","()(())","()()()"]

// Example 2:
// Input: n = 1
// Output: ["()"]

// Constraints:
// * 1 <= n <= 8

import java.util.ArrayList;
import java.util.List;

class GenerateParentheses {

    // This is a problem of generating all valid combinations of n paris of parentheses.
    // A possible solution is to use backtracking, which is a technique of exploring all possible
    // choices and discarding the ones that are invalid.

    // The idea is to maintain a string builder that stores the current combination of parentheses,
    // and two counters that keep track of the number of left adn right parentheses used so far.
    // We start with an empty string and zero counters, and recursively add either a left or a right
    // parenthesis to the string, as long as the counters are within the range of n and the number
    // of left parentheses is not less than the number of right parentheses.
    // Whenever we reach a combination where both counters are equal to n,
    // we add the string to the result list.

    // Explanation:
    // * We use a list to store all the valid combinations of parentheses that we generate.
    // * We use a string builder to store the current combination of parentheses that we are building.
    // * We use two counters to keep track of how many left and right parentheses we have used
    // so far in the current combination.
    // * We use a helper method that takes the result list, the string builder,
    // and the two counters as parameters.
    // * In the helper method, we have two cases: base case and recursive case.
    // * The base case is when we have used all n pairs of parentheses iun the current combination.
    // In this case, we add the string builder's content to the result list and return from the recursion.
    // * The recursive case is when we still have some parentheses left to use. In this case, we have two
    // choices: either add a left parenthesis or a right parenthesis to the current combination.
    // * We can add a left parenthesis if we have not used all n left parentheses yet. To do this,
    // we append a "(" to the string builder and recursively call the helper method with increment left counter.
    // After returning from the recursion, we remove the last character from the string builder
    // to backtrack and undo our choice.
    // * We can add a right parenthesis if we have used more left parentheses than right parentheses so
    // far. This ensures that we always have a valid combination where there are no more closing
    // parentheses than opening parentheses at any point. To do this, we append a ")" to the string
    // builder and recursively call the helper method with incremented right counter.
    // After returning from the recursion, we remove the last character from the string builder
    // to backtrack and undo out choice.
    // * We repeat this process until we have explored all possible combinations.

    public List<String> generateParenthesis(int n) {
        // Initialize an empty list to store the results
        List<String> result = new ArrayList<>();
        // Call the helper method with an empty string builder adn zero counters
        backtrack(result, new StringBuilder(), 0, 0, n);
        // Return the result list
        return result;
    }

    private void backtrack(List<String> result, StringBuilder sb, int left, int right, int n) {
        // Base case: if both counters are equal to n, we have a vaid combination
        if (left == n && right == n) {
            // Add the string to the result list
            result.add(sb.toString());
            // Return from the recursion
            return;
        }

        // Recursive case: try adding either a left or a right parenthesis
        // If the left counter is less than n, we can add a left parenthesis
        if (left < n) {
            // Append a left parenthesis to the string builder
            sb.append("(");
            // Recursively explore the next choices with incremented left counter
            backtrack(result, sb, left + 1, right, n);
            // Remove the last character from the string builder to backtrack
            sb.deleteCharAt(sb.length() - 1);
        }

        // If the right counter is less than the left counter, we can add a right parenthesis
        if (right < left) {
            // Append a right parenthesis to the string builder
            sb.append(")");
            // Recursively explore the next choices with incremented right counter
            backtrack(result, sb, left, right + 1, n);
            // Remove the last character from the string builder to backtrack
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    // Big O:

    // The time complexity of this solution is O(4^n / sqrt(n)), which is derived from using Catalan numbers
    // to count the number of valid combinations of n pairs of parentheses.

    // The space complexity is O(n) which is mainly due to
    // using a string builder of length n and recursion stack of depth n.

}
