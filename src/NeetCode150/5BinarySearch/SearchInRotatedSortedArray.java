//// 2023/07/07 // 11:49 //

//// 33. Search in Rotated Sorted Array // Medium //

// There is an integer array nums sorted in ascending order (with distinct values).

// Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k
// (1 <= k < nums.length) such that the resulting array is
// [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed).
// For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].

// Given the array nums after the possible rotation and an integer target,
// return the index of target if it is in nums, or -1 if it is not in nums.

// You must write an algorithm with O(log n) runtime complexity.

// Example 1:
// Input: nums = [4,5,6,7,0,1,2], target = 0
// Output: 4

// Example 2:
// Input: nums = [4,5,6,7,0,1,2], target = 3
// Output: -1

// Example 3:
// Input: nums = [1], target = 0
// Output: -1

// Constraints:
// * 1 <= nums.length <= 5000
// * -10^4 <= nums[i] <= 10^4
// * All values of nums are unique.
// * nums is an ascending array that is possibly rotated.
// * -10^4 <= target <= 10^4

class SearchInRotatedSortedArray {

    // Explanation:
    // In this problem, we are given a rotated sorted array and a target value.
    // Our task is to find the index of the target value in the given array.
    // If the target value is not present in the array, return -1.
    // The key requirement is that the algorithm should have a runtime complexity of O(log n).

    // To solve this problem, we can use a modified binary search algorithm.
    // Since the array is rotated, there are two ascending subarrays.
    // First, find the pivot index (the smallest element index) using binary search.
    // Then determine in which part of the array the target is present,
    // and perform binary search on that part to fnd the target.

    // Here's the solution with code:
    public int search(int[] nums, int target) {
        int pivotIndex = findPivotIndex(nums);

        if (pivotIndex == -1) {
            return binarySearch(nums, 0, nums.length - 1, target);
        }

        if (nums[pivotIndex] == target) {
            return pivotIndex;
        }

        if (target >= nums[0]) {
            return binarySearch(nums, 0, pivotIndex - 1, target);
        } else {
            return binarySearch(nums, pivotIndex + 1, nums.length - 1, target);
        }
    }

    private int findPivotIndex(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    private int binarySearch(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    // Runtime complexity analysis (Big O):
    // 1. Finding the pivot index - O(log n)
    // 2. Binary search - O(log n
    // Total complexity:
    // O(log n) + O(log n) = O(log n)

}
