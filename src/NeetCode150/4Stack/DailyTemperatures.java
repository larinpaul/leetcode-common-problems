//// 2023/07/03 //10:55 //

//// 739. Daily Temperatures // Medium //

// Given an array of integers temperatures represents the daily temperatures, return an array
// answer such that answer[i] is the number of days you have to wait after the ith day to get
// a warmer temperature. If there is no future day for which this is possible,
// keep answer[i] == 0 instead.

// Example 1:
// Input: temperatures = [73,74,75,71,69,72,76,73]
// Output: [1,1,4,2,1,1,0,0]

// Example 2:
// Input: temperatures = [30,40,50,60]
// Output: [1,1,1,0]

// Example 3:
// Input: temperatures = [30,60,90]
// Output: [1,1,0]

// Constraints:
// * 1 <= temperatures.length <= 10^5
// * 30 <= temperatures[i] <= 100

// Solution:
// We can use a stack to store the indices of the temperatures that are waiting for a warmer
// We iterate through the array from right to left, and for each temperature, we pop the stack until we
// find a higher temperature or the stack is empty. The answer for that index is the difference between
// the current index and the top of the stack, or zero if the stack is empty.
// We then push the current index to the stack and continue.

// Explanation:
// The stack helps us keep track of the temperatures that are in decreasing order from right
// to left. When we encounter a higher temperature, we know that it is the next warmer day for all the
// temperatures in the stack that are lower than it. We can then calculate the number of days by
// subtracting the indices. By iterating from right to left, we ensure that we process
// the temperatures in reverse chronological order.

import java.util.Stack;

class DailyTemperatures {

    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        Stack<Integer> stack = new Stack<>(); // store indices of temperatures
        for (int i = n - 1; i >= 0; i--) { // iterate from right to left
            int temp = temperatures[i];
            while (!stack.isEmpty() && temp >= temperatures[stack.peek()]) { // pop lower temperatures
                stack.pop();
            }
            answer[i] = stack.isEmpty() ? 0 : stack.peek() - i; // calculate days or zero
            stack.push(i); // push current index
        }
        return answer;
    }

    // Big O:
    // The time complexity is O(n), where n is the length of the array, because we iterate through the
    // array once and each element is pushed and popped at most once.
    // The space complexity is O(n), because we use a stack that can potentially store all the elements.

}
