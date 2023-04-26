//// 2023/04/26 // 11:19 //

//// 136. Single Number // Easy //

// Given a non-empty array of integers nums, every element appears twice except for one.
// Find that single one.

// You must implement a solution with a linear runtime complexity and use only constant extra space.

// Example 1:
// Input: nums = [2,2,1]
// Output: 1

// Example 2:
// Input: nums = [4,1,2,1,2]
// Output: 4

// Example 3:
// Input: nums = [1]
// Output: 1

// Constraints:
// * 1 <= nums.length <= 3 * 10^4
// * -3 * 10^4 <= nums[i] <= 3 * 10^4
// * Each element in the array appears twice except for one element which appears only once.

class SingleNumber {

    public int singleNumber(int[] nums) {
        // Initialize a variable to store the result
        int result = 0;
        // Loop through the array of numbers
        for (int num : nums) {
            // Use bitwise XOR operation to update the result
            // XOR has the property that a ^ a = 0 and a ^ 0 = a
            // So if a number appears twice, it will cancel out with itself
            // And the single number will remain in the result
            result ^= num;
        }
        // Return the result
        return result;
    }

    // The time complexity of this solution is O(n), where n is the length of the array,
    // because we need to iterate through all the elements once

    // The space complexity of this solution is O(1),
    // because we only use a constant extra variable to store teh result.

    public int singleNumberTraditionalLoop(int[] nums) {

        // Initialize a variable to store the result
        int result = 0;
        // Loop through the array of numbers using an index variable
        for (int i = 0; i < nums.length; i++) {
            // Use bitwise XOR operation to update the result
            // XOR has the property that a ^ a = 0 and a ^ 0 = a
            // So if a number appears twice, it will cancel out with itself
            // And the single number will remain in the result
            result ^= nums[i];
        }
        // Return the result
        return result;
    }

}




