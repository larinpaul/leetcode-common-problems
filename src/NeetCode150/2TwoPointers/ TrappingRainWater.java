//// 2023/04/15 // 13:32 //

//// https://leetcode.com/problems/trapping-rain-water/

//// 42. Trapping Rain Water // Hard

// Given n non-negative integers representing an elevation map where
// the width of each bar is 1, compute how much water it can trap after raining.

// Example 1:
// Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
// Output: 6
// Explanation: The above elevation map (black section) is
// represented by array [0,1,0,2,1,0,1,3,2,1,2,1].
// In this case, 6 units of rain water (blue section)
// are being trapped.

// Example 2:
// Input: height = [4,2,0,3,2,5]
// Output: 9

// Constraints:
// n == height.length
// 1 <= n <= 2 * 10^4
// 0 <= height[i] <= 10^5

class Solution {
    // Define a method that takes an array of height and return the amount of water trapped
    public int trap(int[] height) {
        // Initialize two pointers: left and right
        int left = 0;
        int right = height.length - 1;
        // Initialize two variables: maxLeft and maxRight to store
        // the maximum height on the left and right sides
        int maxLeft = 0;
        int maxRight = 0;
        // Initialize a variable: result to store
        // the total amount of water trapped
        int result = 0;
        // Loop until left and right pointers meet
        while (left <= right) {
            // If the height on the left is smaller than the height on the right
            if (height[left] < height[right]) {
                // If the height on the left is greater than maxLeft, update maxLeft
                if (height[left] > maxLeft) {
                    maxLeft = height[left];
                }
                // Otherwise, add the difference between maxLeft and height[left]
                // to the result
                else {
                    result += maxLeft - height[left];
                }
                // Move the left pointer one step forward
                left++;
            }
            // Otherwise, if the height on the right is smaller or equal
            // to the height on the left
            else {
                // If the height on the right is greater than maxRight,
                // update maxRight
                if (height[right] > maxRight) {
                    maxRight = height[right];
                }
                // Otherwise, add the difference between maxRight
                // and height[right] to the result
                else {
                    result += maxRight - height[right];
                }
                // Move the right pointer one step backward
                right--;
            }
        }
        // Return the result
        return result;
    }

    public static void main(String[] args) {
        // Test some examples
        System.out.println(new TrappingRainWater().trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1})); // 6
        System.out.println(new TrappingRainWater().trap(new int[]{4, 2, 0, 3, 2, 5})); // 9

    }

    // The solution is based on using two pointers: left and right
    // to traverse the array from both ends. The idea is to keep track of the maximum height
    // on both sides and compare them. If the height on one side is smaller than the other side,
    // it means that there is a potential to trap water on that side.
    // The amount of water trapped on that side is equal
    // to the difference between the maximum height and the current height.
    // We add this amount to the result and move the pointer on that side.
    // We repeat this process until both pointers meet.

    // The time complexity of this solution is O(n), where n is the length of the array.
    // The space complexity is O(1), as we only use constant extra space.

}
