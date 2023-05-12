//// 2023/05/12 // 10:20 //

//// 268. Missing Number // Easy //

// Given an array nums containing n distinct numbers in the range [o, n], return
// the only number in the range that is missing from the array.

// Example 1:
// Input: nums = [3,0,1]
// Output: 2
// Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3].
// 2 is the missing number in the range since it does not appear in nums.

// Example 2:
// Input: nums = [0,1]
// Output: 2
// Explanation: n = 2 since there are 2 numbers, so all numbers are in the range [0,2].
// 2 is the missing number in the range since it does not appear in nums.

// Example 3:
// Input: nums = [9,6,4,2,3,5,7,0,1]
// Output: 8
// Explanation: n = 9 since there are 9 numbers, so all numbers are in the range [0,9].
// 8 is the missing number in the range since it does not appear in nums.

// Constrains:
// * n == nums.length
// * 1 <= n <= 10^4
// * 0 <= nums[i] <= n
// * All the numbers of nums are unique.

// Follow up: Could you implement a solution using only O(1) extra space complexity
// and O(n) runtime complexity?

// Solutions:

class MissingNumber {

    // One way to solve this problem is to use the fact that the sum of the first n natural numbers
    // is n*(n+1)/2. If we subtract the sum of the given array from this value,
    // we will get the missing number.

    // Explanation: Let n be the length of the array nums. Then the sum of the numbers in the range [0, n]
    // is n*(n+1)/2. We can iterate over the array and subtract each element form this sum.
    // The remaining value after the loop is the missing number.

    public int missingNumber(int[] nums) {
        // initialize n as the length of nums
        int n = nums.length;
        // initialize sum as n*(n+1)/2
        int sum = n * (n + 1) / 2;
        // loop over the array
        for (int num : nums) {
            // subtract each element from sum
            sum -= num;
        }
        // return the remaining value as the missing number
        return sum;
    }

    // Big O: The time complexity of this solution is O(n) since we iterate over the array once.
    // The space complexity is O(1) since we only use a constant amount of extra space.

    // This solution is optimal in terms of time and space complexity. However, there is a potential
    // risk of integer overflow if n is very large. To avoid this, we can use a long variable instead of an
    // int for the sum. Alternatively, we can use another approach that does not involve calculating the sum
    // such as using a bit manipulation technique called XOR.


    // Explanation for the XOR solution:

    // The XOR solution works by using the fact that XORing a number with itself results in zero,
    // and XORing a number with zero result in the same number. Therefore, if we XOR all the numbers in
    // the range [0, n] and all the numbers in the array nums, the result will be the missing number.

    public int missingNumber(int[] nums) {
        // initialize n as the length of nums
        int n = nums.length;
        // initialize result as n
        int result = n;
        // loop over the array
        for (int i = 0; i < n; i++) {
            // XOR result with i and nums[i]
            result ^= i ^ nums[i];
        }
        // return result as the missing number
        return result;
    }

    // Both solutions have the same time and space complexity, so they are equally effective in terms
    // of performance. However, the sum solution may be easier to understand for some people, since
    // it is based on a simple mathematical formula. The XOR solution may require more familiarity
    // with bitwise operations and their properties.

}
