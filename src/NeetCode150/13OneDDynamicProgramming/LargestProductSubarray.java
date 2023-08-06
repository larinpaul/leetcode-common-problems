//// 2023/08/06 // 9:14 //

//// 152. Maximum Product Subarray // Medium //

// Given an integer array nums, find a subarray that has the largest product, and return the product.

// The test cases are generated so that the answer will fit in a 32-bit integer.

// Example 1:
// Input: nums = [2,3,-2,4]
// Output: 6
// Explanation: [2,3] has the largest product 6.

// Example 2:
// Input: nums = [-2,0,-1]
// Output: 0
// Explanation: The result cannot be 2, because [-2,-1] is not a subarray.

// Constraints:
// * 1<= nums.length <= 2 * 10^4
// * -10 <= nums[i] <= 10
// * The product of any prefix or suffix of nums is guaranteed to fit in 32-bit integer.

class LargestProductSubarray {

    // A subarray is a contiguous part of an array. For example, if the array is [2,3,-2,4], then
    // some possible subarrays are [2], [3,-2], [2,3,-2,4], etc. The product of a subarray is the
    // result of multiplying all its elements together. For example, the product of [2,3,-2] is -12.

    // The problem asks us to find a subarray that has the largest product among all possible
    // subarrays, and return that product. For example, in the first test case, the subarray [2,3]
    // has the largest product 6, so we return 6.

    // To solve this problem we can use a dynamic programming approach. Dynamic
    // programming is a technique that breaks down a complex problem into smaller and
    // simpler subproblems, and stores the results of these subproblems in a table or an array,
    // so that we can reuse them later without recomputing them.

    // In this case, we can use two arrays to store the maximum and minimum products ending
    // at each index of the input array. We call them maxProd and minProd. For example,
    // maxProd[i] is the maximum product of any subarray that ends at index i, and minProd[i]
    // is the maximum product of any subarray that ends at index i.

    // We can initialize maxProd[0] and minProd[0] to be nums[0], since the only subarray
    // ending at index 0 is [nums[0]]. Then, we can iterate through the input array from index 1
    // to n-1, where n is the length of the input array. At each index i, we have three choices for
    // the subarray ending at i:
    // * We can extend the previous subarray ending at i-1 by multiplying nums[i] with it. This
    // gives us maxProd[i-1] * nums[i] or minProd[i-1] * nums[i], depending on whether
    // nums[i] is positive or negative.
    // * We can start a new subarray with only nums[i]. This gives us nums[i].
    // * We can skip nums[i] and end the subarray at i-1. This gives us maxProd[i-1] or
    // minProd[i-1], depending on whether we want the maximum or minimum product.

    // We can compare these three choices and take the maximum for maxProd[i] and the
    // minimum for minProd[i]. This way, we can handle both positive and negative numbers in
    // the input array. For example, if nums[i] is negative, then multiplying it with minProd[i-1]
    // might give us a larger product than multiplying it with maxProd[i-1].

    // After we fill up the maxProd and minProd array, we can scan through them and find the
    // maximum value among them. This will be our answer for the maximum product subarray.

    // The time complexity of such a solution would be O(n), where n is the length of the input array,
    // since we only iterate through it once and do constant work at each index. The space
    // complexity is also O(n), since we use two auxiliary arrays of size n to store the
    // intermediate results.
    // OPTIMIZATION
    // However, we can optimize the space complexity to O(1) by using
    // two variables instead of two arrays to keep track of the current maximum and minimum
    // products ending at each index.

    // Code:
    public int maxProduct(int[] nums) {
        // edge case: empty array
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // initialize the current and global maximum and minimum products
        int currMax = nums[0];
        int currMin = nums[0];
        int globalMax = nums[0];

        // iterate through the input array from index 1 to n-1
        for (int i = 1; i < nums.length; i++) {
            // three choices for the subarray endingat i
            int choice1 = currMax * nums[i];
            int choice2 = currMin * nums[i];
            int choice3 = nums[i];

            // update the current maximum and minimum products
            currMax = Math.max(Math.max(choice1, choice2), choice3);
            currMin = Math.min(Math.min(choice1, choice2), choice3);

            // update the global maximum product
            globalMax = Math.max(globalMax, currMax);
        }

        // return the answer
        return globalMax;
    }

}
