//// 2023/06/25 // 16:26 //

//// 215. Kth Largest Element in an Array // Medium //

// Given an integer array nums and an integer k, return the kth largest element in the array.

// Note that is it the kth largest element in the sorted order, not the kth distinct element.

// You must solve it in O(n) time complexity.

// Example 1:
// Input: nums = [3,2,1,5,6,4], k = 2
// Output: 5

// Example 2:
// Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
// Output: 4

// Constraints:
// * 1 <= k <= nums.length <= 10^5
// * -10^4 <= nums[i] <= 10^4

import java.util.Random;

class KthLargestElementInAnArray {

    // Use a quickselect algorithm to find the kth largest element in O(n) time on average
    // The idea is to partition the array around a pivot element and compare its index with k
    // If the index is equal to k, we have found the kth largest element
    // If the index is greater than k, we recurse on the left subarray
    // If the index is less than k, we recurse on the right subarray
    // We can a use a random pivot to avoid the worst case scenario of (N^2) time

    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        Random rand = new Random();
        while (left <= right) {
            // Choose a random pivot and swap it with the last element
            int pivotIndex = rand.nextInt(right - left + 1) + left;
            swap(nums, pivotIndex, right);
            // Partition the array around the pivot and return its index
            int index = partition(nums, left, right);
            // Compare the index with k and adjust the boundaries accordingly
            if (index == n - k) {
                return nums[index]; // We have found the kth largest element
            } else if (index > n - k) {
                right = index - 1; // Recurse on the left subarray
            } else {
                left = index + 1; // Recurse on the right subarray
            }
        }
        return - 1; // This should never happen
    }

    private int partition(int[] nums, int left, int right) {
        // Use the last element as the pivot and move all elements smaller than it to the left
        // Return the final position of the pivot
        int pivot = nums[right];
        int i = left;
        for (int j = left; j < right; j++) {
            if (nums[j] < pivot) {
                swap(nums, i, j);
                i++;
            }
        }
        swap(nums, i, right);
        return i;
    }

    private void swap(int[] nums, int i, int j) {
        // Swap two elements in an array
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // Code complexity:
    // * The average time complexity is O(n) since each partitioning step reduces the size of the search
    // space by half on average. The expected number of partitioning steps is O(log n), and each step
    // takes O(n) time to scan and move elements.
    // Therefore, the total average time complexity is O(n * log n) / 2 = O(n).
    // * The worst case time complexity is O(n^2), if we are unlucky and always choose a bad pivot that
    // partitions the array into one very large subarray and one very small subarray. In this case, each
    // partitioning step only reduces the size of teh search space by one element, adn we need O(n)
    // steps to find the kth largest element.
    // Therefore, the total worst time complexity is O(n * n) / 2 = O(n^2)
    // * The space complexity is O(1), since we only use constant extra space for swapping and randomization.

    // The explanation of the solution:
    // * We use a quickselect algorithm, which is a variation of quicksort, to find the kth largest element in
    // O(n) time on average. The worst case time complexity is O(n^2), but we can avoid it by choosing a
    // random pivot element
    // * The quickselect algorithm works by partitioning the array around a pivot element and comparing
    // its index with k. The partitioning step moves all elements smaller than the pivot to the left and all
    // elements larger than or equal to the pivot to the right. The index of the pivot after partitioning is its
    // final position in the sorted order.
    // * If the index of the pivot is equal to n-k, where n is the length of the array, then we have found the
    // kth largest element and we can return it.
    // * If the index of the pivot is greater than n-k, then we know that the kth largest element is in the left
    // subarray, so we recurse on that subarray and ignore the right subarray.
    // * If the index of the pivot is less than n-k, then we know that the kth largest element is in the right
    // subarray, so we recurse on that subarray and ignore the left subarray.
    // * We repeat this process until we find the kth largest element or until we run out of bounds.

}
