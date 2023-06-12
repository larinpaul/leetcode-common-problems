//// 2023/06/12 // 19:55 //

//// 55. Jump Game // Medium //

// You are given an integer array nums. You are initially positioned at the array's first index,
// and each element in the array represents your maximum jump length at that position.

// Return true if you can reach the last index, or false otherwise.

// Example 1:
// Input: nums = [2,3,1,1,4]
// Output: true
// Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.

// Example 2:
// Input: nums = [3,2,1,0,4]
// Output: false
// Explanation: You will always arrive at index 3 no matter what.
// Its maximum jump length is 0, which makes it impossible to reach the last index.

// Constraints:
// * 1 <= nums.length <= 10^4
// * 0 <= nums[i] <= 10^5

class JumpGame {

    // Solution:
    // We can solve this problem by using a greedy approach.
    // We can start from the first index and keep track of the
    // farthest index we can reach form the current index. For each index
    // that we visit, we update the farthest index that we can reach.
    // If ay any point the farthest index is less than or equal to the current index,
    // then we cannot reach the end of the array and wwe return false.
    // Otherwise, if we reach the end of the array, we return true.

    public boolean canJump(int[] nums) {
        int n = nums.length; // get the length of the input array
        int farthest = 0; // initialize the farthest index we can reach from the start
        for (int i = 0; i < n; i++) { // iterate over the input array
            if (i > farthest) { // if the current index is greater than the farthest index we can reach
                return false;   // ,then we cannot reach the end of teh array
            }
            farthest = Math.max(farthest, i + nums[i]); // update the farthest index we can reach
            if (farthest >= n - 1) { // if the farthest index we can reach is greater than or equal
                return true; // to the last index, then we can reach the end of the array
            }
        }
        return false; // if we cannot reach the end of the array, return false
    }

    // Time Complexity:
    // The time complexity of the above algorithm is O(n),
    // where n is the length of the input array nums.

    // Space complexity:
    // The space complexity of the above algorithm is O(1),
    // as we are not using any extra space other than a few variables.

}
