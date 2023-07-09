//// 2023/07/09 // 13:42 //

//// 4. Median of Two Sorted Arrays // Hard //

// Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median
// of the two sorted arrays.

// The overall run time complexity should be O(log (m+n)).

// Example 1:
// Input: nums1 = [1,3], nums2 = [2]
// Output: 2.00000
// Explanation: merged array = [1,2,3] and median is 2.

// Example 2:
// Input: nums1 = [1,2], nums2 = [3,4]
// Output: 2.50000
// Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.

// Constraints:
// * nums1.length == m
// * nums2.length == n
// * 0 <= m <= 1000
// * 0 <= n <= 1000
// * 1 <= m + n <= 2000
// * -10^6 <= nums1[i], nums2[i] <= 10^6

class MedianOfTwoSortedArrays {

    // Explanation:
    // The median of a sorted array is defined as the middle element of the array.
    // FOr an odd number of elements, there will be one middle element, and for an even number of
    // elements, there will be two middle elements, and the median will be the average of those
    // two middle elements.

    // One approach to solve this problem is to merge the two sorted arrays into a single sorted array
    // and then find the median of the merged sorted array. However, the time complexity
    // of this approach will be O(m+n), which does not meet the requirement of O(log(m+n)).

    // Another approach to solve this problem is to use the binary search algorithm
    // to find the median of the two sorted arrays directly without merging them.
    // We can find the partition position fo the two arrays such that the elements on the left side
    // of the partition are smaller than the elements on the right side of the partition.
    // Then, the median of the merged sorted array will be the average of the maximum number
    // on the left side and the minimum number on the right side.
    // We can adjust the partition positions based on the values of the elements att the partition
    // positions until we find the correct partition positions.

    // Solution:
    // The code takes two sorted arrays nums1 and nums2 as input and returns the median
    // of the merged sorted array. If the length of nums1 is greater than the length of nums2,
    // the code swaps the two arrays to make nums1 the shorter array. Then, it uses binary search
    // to find the partition positions of the two arrays and adjust the partition positions
    // based on the values of the elements at the partitions positions until it find the
    // correct partitions positions.
    // Finally, it calculates and returns the median of the merged sorted array.

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        if (m > n) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int left = 0, right = m;
        while (left <= right) {
            int partition1 = (left + right) / 2;
            int partition2 = (m + n + 1) / 2 - partition1;
            int maxLeft1 = (partition1 == 0) ? Integer.MIN_VALUE : nums1[partition1 - 1];
            int minRight1 = (partition1 == m) ? Integer.MAX_VALUE : nums1[partition1];
            int maxLeft2 = (partition2 == 0) ? Integer.MIN_VALUE : nums2[partition2 - 1];
            int minRight2 = (partition2 == n) ? Integer.MAX_VALUE : nums2[partition2];
            if (maxLeft1 <= minRight2 && maxLeft2 <= minRight1) {
                if ((m + n) % 2 == 0) {
                    return (Math.max(maxLeft1, maxLeft2) + Math.min(minRight1, minRight2)) / 2.0;
                } else {
                    return Math.max(maxLeft1, maxLeft2);
                }
            } else if (maxLeft1 > minRight2) {
                right = partition1 - 1;
            } else {
                left = partition1 + 1;
            }
        }
        throw new IllegalArgumentException("Invalid input");
    }

    // Big O:
    // The time complexity of the above approach is O(log(min(m, n))),
    // which meets the requirement of O(log(m+n)).
    // This is because we are using binary search to find the partitions positions of the
    // two arrays, and the number of elements we need to search in each iteration is reduced by half.
    // The space complexity of the algorithms is O(1)
    // because we are not using any additional data structures that scale with the input size.
    // with the input size. We are only using a fixed number of variables to keep track
    // of the indices and values of the numbers in the input arrays.
    // Therefore, the space used by the algorithm is constant adn does not depend on the size of the input.




}
