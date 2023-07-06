//// 2023/07/06 // 11:22 //

//// 153. Find Minimum in Rotated Sorted Array // Medium //

// Suppose an array of length n sorted in ascending order is rotated between 1 and n times.
// For example, the array nums = [0,1,2,4,5,6,7] might become:
// * [4,5,6,7,0,1,2] if it was rotated 4 times.
// * [0,1,2,4,5,6,7] if it was rotated 7 times.

// Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time
// results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].

// Given the sorted rotated array nums of unique elements,
// return the minimum element of this array.

// You must write an algorithm that runs in O(log n) time.

// Example 1:
// Input: nums = [3,4,5,1,2]
// Output: 1
// Explanation: The original array was [1,2,3,4,5] rotated 3 times.

// Example 2:
// Input: nums [4,5,6,7,0,1,2]
// Output: 0
// Explanation: The original array was [0,1,2,4,5,6,7] and it was rotated 4 times.

// Example 3:
// Input: nums = [11,13,15,17]
// Output: 11
// Explanation: The original array was [11,13,15,17] and it was rotated 4 times.

// Constraints:
// * n == nums.length
// * 1 <= n <= 5000
// * -5000 <= nums[i] <= 5000
// * All the integers of nums are unique.
// * nums is sorted and rotated between 1 and n times.

class FindMinimumRotatedSortedArray {

    // Explanation:
    // The problem asks to find the minimum element in a given sorted and rotated array in O(log n) time complexity.
    // To achieve this, we can implement a binary search algorithm.
    // The key observation here is that the minimum element
    // is the only one for which the previous element is greater than it.
    // Also, if the array is not rotated at all, then the minimum element is the first element.

    // Solution:
    // 1. Initialize two pointers, left and right, pointing to the beginning and the end of the array.
    // 2. While the left pointer is less than the right pointer:
    //  // 1. Calculate the middle index mid as (left + right) // 2.
    //  // 2. If the element at index mid is greater than the element at index mid + 1,
    //  // it means the minimum element is at index mid + 1. Return nums[mid + 1].
    //  // 3. If the element at index mid - 1 is greater than the element at index mid,
    //  // it means the minimum element is at index mid. Return nums[mid].
    //  // 4. If the element at index mid is greater than the element at index right,
    //  // it means the minimum element is in the right half of the array, so set left to mid + 1.
    //  // 5. Otherwise, the minimum element is in the left half of the array,
    //  // so set right to mid - 1.
    // 3. When the loop ends, return nums[left] as the minimum element.

    // Code:
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;

            if (mid > 0 && nums[mid - 1] > nums[mid]) {
                return nums[mid];
            }
            if (nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return nums[left];
    }

    // Big O:
    // The time complexity of this algorithm is O(log n) since we are using a binary search approach,
    // which narrows down the search space by half in each iteration.
    // The space complexity is O(1), as we are only using constant extra space
    // to store the pointers and indices.

}
