//// 2023/04/15 // 14:50 //

//// 704. Binary Search // Easy

// Given an array of integers nums which is sorted in ascending order, and an
// integer target, write a function to search target in nums. If target exists,
// then return its index. Otherwise, return -1.

// You must write an algorithm with O(log n) runtime complexity.

// Example 1:
// Input: nums = [-1,0,3,5,9,12], target = 9
// Output: 4
// Explanation: 9 exists in nums and its index is 4

// Example 2:
// Input: nums = [-1,0,3,5,9,12], target = 2
// Output: -1
// Explanation: 2 does not exist in nums so return -1

// Constraints:
// 1 <= nums.length <= 10^4
// -10^4 < nums[i], target < 10^4
// All the integers in nums are unique
// nums is sorted in ascending order.

class BinarySearch {

    public int search(int[] nums, int target) {
        // Initialize two pointers: low and high
        int low = 0;
        int high = nums.length - 1;
        // Loop until low is less than or equal to high
        while (low <= high) {
            // Calculate the middle index of the array
            int mid = low + (high - low) / 2;
            // Compare the target with the middle element of the array
            if (target == nums[mid]) {
                // If they are equal, return the middle index as the answer
                return mid;
            }
            else if (target < nums[mid]) {
                // If the target is smaller than the middle element,
                // update high to mid - 1
                high = mid -1;
            }
            else {
                // If the target is larger than the middle element,
                // update low to mid + 1
                low = mid + 1;
            }
        }
        // If the loop ends without finding the target, return -1
        return -1;
    }

}
// We use
// low + (high - low) / 2
// instead of
// (low + high) / 2
// to avoid integer overflow.
// If low and high are very large numbers, their sum might exceed the maximum value
// that an int can store, which could cause unexpected results.
// By using low + (high - low) / 2,
// we ensure that the expression is always within the range of in values.







