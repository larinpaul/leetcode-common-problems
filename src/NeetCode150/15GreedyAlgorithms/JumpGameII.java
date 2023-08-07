//// 2023/08/07 // 13:01 //

//// 45. Jump Game II // Medium //

// You are given an 0-indexed array of integers nums of length n. You are initially positioned at nums[0].

// Each element nums[i] represents the maximum length of a forward jump from index i.
// In other words, if you are at nums[i], you can jump to any nums[i + j] where:
// * 0 <= j <= nums[i] and
// * i + j < n

// Return the minimum number of jumps to reach nums[n - 1]. The test cases are generated
// such that you can reach nums[n - 1].

// Example 1:
// Input: nums = [2,3,1,1,4]
// Output: 2
// Explanation: The minimum number of jumps to reach the last index is 2.
// Jump 1 step from index 0 to 1, then 3 steps to the last index.

// Example 2:
// Input: nums = [2,3,0,1,4]
// Output: 2

// Constraints:
// * 1 <= nums.length <= 10^4
// * 0 <= nums[i] <= 1000
// * It's guaranteed that you can reach nums[n - 1].

class JumpGameII {

    // One possible solution is to use a greedy approach, where you always choose the jump
    // that can reach the farthest position in the array. To do this, you need to keep track of
    // three variables:
    // * jumps: the number of jumps you have made so far.
    // * end: the end of the current jump range, which is initially nums[0].
    // * maxPos: the farthest position you can reach by jumping from any index within the current jump range.

    // You can iterate through the array from left to right, and update these variables as follows:
    // * If you reach the end of the array, you return jumps as the answer.
    // * If you reach the end of the current jump range, you increment jumps by one,
    // and set end to maxPos, which is the new jump range.
    // * For each index i within the current jump range, you update maxPos by taking the
    // maximum of maxPos and i + nums[i], which is the farthest position you can reach
    // by jumping from index i.

    public int jump(int[] nums) {
        // Initialize the variables
        int jumps = 0;
        int end = 0;
        int maxPos = 0;

        // Iterate through the array
        for (int i = 0; i < nums.length - 1; i++) {
            // Update maxPos by taking the maximum of maxPos and i + nums[i]
            maxPos = Math.max(maxPos, i + nums[i]);

            // If we reach the end of the current jump range, update jumps and end
            if (i == end) {
                jumps++;
                end = maxPos;
            }
        }

        // Return jumps
        return jumps;
    }

    // Big O:

    // The time complexity of this solution is O(n), where n is the length fo the array,
    // because we only iterate through the array once.

    // The space complexity is O(1),
    // because we only use constant extra space for the variables.

}
