//// 2023/05/14 // 18:55 //

// 238. Product of Array Except Self // Medium //

// Given an integer array nums, return an array answer such that answer[i]
// is equal to the product of all the elements of nums except nums[i].

// The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

// You must write an algorithm that runs in O(n) time and without using the division operation

// Example 1:
// Input: nums = [1,2,3,4]
// Output: [24,12,8,6]

// Example 2:
// Input: nums = [-1,1,0,-3,3]
// Output: [0,0,9,0,0]

// Constraints:
// * 2 <= nums.length <= 10^5
// * -30 <= nums[i] <= 30
// * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

// Follow up: Can you solve the problem in O(1) extra space complexity?
// (The output array does not count as extra space for space complexity analysis.)

class ProductOfArrayExceptSelf {

    // This is a common coding problem that can be solved in different ways. One possible solution is to use
    // two arrays to store the prefix and suffix products of the input array, and then multiply them to get the
    // asnwer array. Another possible solution is to use only one array to store the prefix products, and then
    // use a variable to keep track of te suffix products while updating the answer array. Both solutions have
    // O(n) time complexity and O(1) extra space complexity (excluding the output array).
    // Here is a possible code for the second solution in Java:

    public int[] productExceptSelf(int[] nums) {
        // Initialize an array to store the answer
        int[] ans = new int[nums.length];
        // Initialize a variable to store the prefix product
        int prefix = 1;
        // Loop through the input array from left to right
        for (int i = 0; i < nums.length; i++) {
            // Update the answer array with the prefix product
            ans[i] = prefix;
            // Update the prefix product with the current element
            prefix *= nums[i];
        }
        // Initialize a variable to store the suffix product
        int suffix = 1;
        // Loop through the input array from right to left
        for (int i = nums.length - 1; i >= 0; i--) {
            // Update the answer array with the product of prefix and suffix
            ans[i] *= suffix;
            // Update the suffix product with the current element
            suffix *= nums[i];
        }
        // Return the answer array
        return ans;
    }

    // The big O notation for this solution is O(n) for time and O(1) for space.

}
