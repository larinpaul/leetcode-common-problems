//// 2023/05/19 // 15:03 //

//// 11. Container With Most Water // Medium //

// You are given an integer array height of length n.
// There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

// Find two lines that together with the x-axis form a container,
// such that the containter contains the most water.

// Return the maximum amount of water a container can store.

// Notice that you may not slant the container.

// Example 1:
// Picture
// Input: height = [1,8,6,2,5,4,8,3,7]
// Output: 49
// Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7].
// In this case, the max area of water (blue section) the container can contain is 49.

// Example 2:
// Input: height = [1,1]
// Output: 1

// Constraints:
// * n == height.length
// 2 <= n <= 10^5
// * 0 <= height[i] <= 10^4

class ContainerWithMostWater {

    // This is a classic problem that can be solved using the two pinter technique.
    // The idea is to use two indices, one at the beginning and one at the end of the array, and move them
    // inward until they meet.
    // At each step, we calculate the area of the container formed by the two lines
    // and update the maximum area if it is larger. We also move the pointer with the smaller height inward,
    // because moving the pointer with the larger height will not increase the area.

    public int maxArea(int[] height) {

        // Initialize two pointers
        int left = 0; // left pointer
        int right = height.length - 1; // right pointer
        // Initialize max are
        int maxArea = 0;
        // Loop until pointers meet
        while (left < right) {
            // Calculate current area
            int currentArea = Math.min(height[left], height[right]) * (right - left);
            // Update max area if larger
            maxArea = Math.max(maxArea, currentArea);
            // Move the pointer with smaller height inward
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        // Return max area
        return maxArea;
    }

    // Explanation:

    // * We start with the widest possible container, i.e., the one formed by the first adn last lines.
    // * We calculate the area of this container by multiplying the minimum of the two heights
    // and the distance between them.
    // * We compare this area with the current maximum are and update it if it is larger.
    // * We then move one of the pointers inward to find a new container.
    // We choose to move the pointer with the smaller height because moving the other pointer
    // will not increase the height of the container and will only decrease its width, resulting in a smaller are.
    // * We repeat this process until the pointers meet, which means we have considered all possible containers.
    // * We return the maximum area that we have found.

    // The big O for this solution is:
    // * Time complexity: O(n), where n is the length of the array.
    // We only need to scan the array once with two pointers.
    // * Space complexity: O(1), we only use constant extra space for variables.

}
