//// 2023/07/05 // 9:58 //

//// 84. Largest Rectangle in Histogram // Hard //

// Given an array of integers heights representing the histogram's bar height
// where the width of each bar is 1, return the area of the largest rectangle in the histogram.

// Example 1:
// Input: heights = [2,1,5,6,2,3]
// Output: 10
// Explanation: The above is a histogram where width of each bar is 1.
// The largest rectangle is shown in the red area, which has an area = 10 units.

// Example 2:
// Input: heights = [2,4]
// Output: 4

// Constraints:
// * 1 <= heights.length <= 10^5
// * 0 <= heights[i] <= 10^4

import java.util.Stack;

class LargestRectangleInHistogram {

    // Explanation:
    // To solve this problem we can use a stack data structure which will
    // help us keep track of the active bars in the histogram.
    // We will iterate through the given heights array and use the stack to store
    // indices of the bars. When we find a bar with a smaller height than
    // the bar at the top index of the stack, we know there is a potential
    // rectangle.
    // We then pop elements form the stack and calculate the area of the rectangles
    // formed by the popped bars.

    // We can calculate the area of the rectangle formed by the popped bar as follows:
    // heights[popped_bar_index] * (current_index - stack_top_index - 1)

    // Solution:
    // 1. Initialize an empty stack s.
    // 2. Iterate through the heights array:
    //  // * While the stack is not empty and heights[stack_top_index]:
    //  //  // * Pop the top element from the stack.
    //  //  // * Calculate the area of the rectangle, update the maximum are if the calculated are is greater.
    //  // * Push the current index to the stack.
    // 3. Iterate through the remaining elements in the stack:
    //  // * Pop the top element from the stack.
    //  // * Calculate the area of the rectangle, update the maximum are if the calculated are is greater.
    // 4. Return the maximum area.

    // Code:
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> s = new Stack<>();
        int maxArea = 0;

        for (int i = 0; i < heights.length; i++) {
            while (!s.isEmpty() && heights[i] < heights[s.peek()]) {
                int poppedIndex = s.pop();
                int area = heights[poppedIndex] * (s.isEmpty() ? i : i - s.peek() - 1);
                maxArea = Math.max(maxArea, area);
            }
            s.push(i);
        }

        while (!s.isEmpty()) {
            int poppedIndex = s.pop();
            int area = heights[poppedIndex] * (s.isEmpty() ? heights.length : heights.length - s.peek() - 1);
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }

    // Big O:

    // Time Complexity:
    // * The solution iterates through the heights array once,
    // performing a constant number of operations for each element.
    // * For each element, the solution may push or pop an element form the stack.
    // * Each element can be pushed onto the stack at most once and can be popped from the stack at most once.
    // * Therefore, the time complexity of the solution is O(n), where n is the length of the heights array.

    // Space Complexity:
    // * The solution uses a stack data structure to keep track of the indices of bars in non-decreasing order of heights.
    // * In the worst case, the stack can store all the elements in the heights array.
    // * Therefore, the space complexity of the solution is O(n), where n is the length of the heights arrray.

    // So:
    // The time complexity of the solution is O(n)
    // The space complexity is also O(n)

}
