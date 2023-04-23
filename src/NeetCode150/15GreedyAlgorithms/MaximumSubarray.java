//// 2023/04/23 // 16:41 //

//// 53. Maximum Subarray // Medium //

// Given an integer array nums, find the largest subarray with the largest sum, and return its sum.

// Example 1:
// Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
// Output: 6
// Explanation: The subarray [4,-1,2,1] has the largest sum 6.

// Example 2:
// Input: nums = [1]
// Output: 1
// Explanation: The subarray [1] has the largest sum 1,

// Example 3:
// Input: nums = [5,4,-1,7,8]
// Output: 23
// Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.

// Constraint:
// * 1 <= nums.length <= 10^3
// * -10^4 <= nums[i] <= 10^4

// Follow up: If you have figured out the O(n) solution, try coding another solution
// using the divide and conquer approach, which is more subtle.

// Here is one possible solution using Kadane's algorithm1,
// which is an efficient single-pass algorithm that solves the problem in O(n) time and O(1) space.

import java.util.Arrays;

class Solution {
    public int maxSubArray(int[] nums) {
        // Initialize the current sum and the maximum sum to the first element
        int currentSum = nums[0];
        int maxSum = nums[0];

        // Loop through the rest of the array
        for (int i = 1; i < nums.length; i++) {
            // Update the current sum by adding the current element
            currentSum += nums[i];

            // If the current element is larger than the current sum,
            // then it is better to start a new subarray from the current element
            if (nums[i] > currentSum) {
                currentSum = nums[i];
            }

            // Update the maximum sum by comparing it with the current sum
            if (currentSum > maxSum) {
                maxSum = currentSum;
            }
        }
        // Return the maximum sum
        return maxSum;
    }
}

// The idea behind this algorithm is to keep track of two variables:
// The current sum and the maximum sum.
// The current sum represents the sum of a subarray that ends at the current element.
// The maximum sum represents the largest sum among all possible subarrays.

// We start by initializing both variables to the first element of the array.
// Then we loop through the rest of the array, updating both variables as we go.
// For each element, we add it to the current sum, and then check if it is larger than the current sum.
// If it is, then we start a new subarray from that element,
// since it will give a larger sum than continuing with the previous subarray.
// Then we compare the current sum with the maximum sum, and update the maximum sum if necessary.

// The time complexity of this algorithm is O(n), since we only loop through the array once.
// The space complexity is O(1), since we only use two variables.

// The divide and conquer approach is more subtle because it is not obvious how to
// divide the problem into smaller subproblems and how to combine the results.
// The linear time approach is more straightforward because it only requires
// one pass through the array and some simple updates.
// The divide and conquer approach may also help you understand the problem better
// and learn some useful techniques for other problems.

//// Here is the divide and conquer solution:


class MaximumSubarray {

    public int maxSubArray(int[] nums) {
        // base case: if the array has only one element, return it
        if (nums.length == 1) {
            return nums[0];
        }
        // divide the array into two halves
        int mid = nums.length / 2;
        int[] left = Arrays.copyOfRange(nums, 0, mid);
        int[] right = Arrays.copyOfRange(nums, mid, nums.length);
        // recursively find the maximum subarray sum in each half
        int leftMax = maxSubArray(left);
        int rightMax = maxSubArray(right);
        // find the maximum subarray sum that crosses the middle
        int crossMax = maxCrossingSum(nums, mid);
        // return the maximum of the three sums
        return Math.max(Math.max(leftMax, rightMax), crossMax);
    }

    // helper method to find the maximum subarray sum that crosses the middle
    private int maxCrossingSum(int[] nums, int mid) {
        // initialize the left and right sums to the middle element
        int leftSum = nums[mid - 1];
        int rightSum = nums[mid];
        // initialize the current sums to the left and right sums
        int currLeftSum = leftSum;
        int currRightSum = rightSum;
        // loop from the middle to the left and update the left sum
        for (int i = mid - 2; i >= 0; i--) {
            currLeftSum += nums[i];
            leftSum = Math.max(leftSum, currLeftSum);
        }
        // loop from the middle to the right and update the right sum
        for (int i = mid + 1; i < nums.length; i++) {
            currRightSum += nums[i];
            rightSum = Math.max(rightSum, currRightSum);
        }
        // return the sum of the left and right sums
        return leftSum + rightSum;
    }
}
