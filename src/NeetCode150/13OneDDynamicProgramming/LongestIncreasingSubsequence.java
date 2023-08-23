//// 2023/08/22 // 21:01 //

//// 300. Longest Increasing Subsequence // Medium //

// Given an integer array nums, return the length of the longest strictly
// increasing subsequence.

// Example 1:
// Input: nums = [10,9,2,5,3,7,101,18]
// Output: 4
// Explanation: The longest increasing subsequence is [2,3,7,101],
// therefore the length of 4.

// Example 2:
// Input: nums = [0,1,0,3,2,3]
// Output: 4

// Example 3:
// Input: nums = [7,7,7,7,7,7,7]
// Output: 1

// Constraints:
// * 1 <= nums.length <= 2500
// * -10^4 <= nums[i] <= 10^4

// Follow up: Can you come up with an algorithm
// that runs in O(n log(n)) time complexity?


class LongestIncreasingSubsequence {

    // Problem Explanation:
    // The problem asks us to find the length of the longest strictly increasing
    // subsequence in an integer array nums. A subsequence is a sequence that
    // can be derived from the array by deleting some or no elements, without
    // changing the order of the remaining elements. The subsequence should
    // be strictly increasing, meaning that each element is greater than the
    // previous element.

    // For example, given nums = [10, 9, 2, 5, 3, 7, 101, 18],
    // the longest increasing subsequence is [2, 3, 7, 101],
    // so the length of the longest increasing subsequence is 4.

    // Optimal Solution:
    // To solve this problem efficiently, we can use dynamic programming
    // approach with an optimization technique known as the "patience sorting"
    // algorithm. Here's the approach:
    // 1. Initialize an empty array tais to store the smallest tail elements of
    // all increasing subsequences found so far. The length of tails
    // represents the current length of the longest increasing subsequence.
    // 2. Iterate through each element num in the input array nums:
    // * Perform a binary search on the tails array to find the smallest
    // index i such that tails[i] is greater than or equal to num. If
    // such an index i is found, update tails[i] to num. If not found,
    // append num to the tails array.
    // 3. After processing all elements in nums, the length of the longest
    // increasing subsequence is equal to the length of the tails array.

    // Code:
    public int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        int len = 0;

        for (int num : nums) {
            int left = 0;
            int right = len;

            while (left < right) {
                int mid = left + (right - left) / 2;
                if (tails[mid] < num) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            tails[left] = num;
            if (left == len) {
                len++;
            }
        }

        return len;
    }

    // Time Complexity:
    // The time complexity of this solution is O(n log n), where n is the length of
    // the input array nums. The algorithm performs a binary search for each
    // element in nums, resulting in a time complexity of O(log n) for each
    // element. Since there are n elements in nums, the overall time complexity
    // is O(n log n).

    // Space Complexity:
    // The space complexity of this solution is O(n), where n is the length of the
    // input array nums. We use an additional array tails to store the smallest
    // tail elements of all increasing subsequences found so far. The length of
    // the tails array is at most n.

}
