//// 2023/08/23 // 11:06 //

//// 416. Partition Equal Subset Sum // Medium //

// Given an integer array nums, return true if you can partition the array into two subsets that the sum of
// the elements in both subsets is equal or false otherwise.

// Example 1:
// Input: nums = [1,5,11,5]
// Output: true
// Explanation: The array can be partitioned as [1, 5, 5] and [11].

// Example 2:
// Input: nums = [1,2,3,5]
// Output: false
// Explanation: The array cannot be partitioned into equal sum subsets.

// Constraints:
// * 1 <= nums.length <= 200
// * 1 <= nums[i] <= 100


class PartitionEqualSubsetSum {

    // Problem Explanation:
    // The problem asks us to determine whether an integer array nums can be
    // partitioned into two subsets that the sum of the elements in both
    // subsets is equal. In other words, we need to check if it is possible to
    // divide nums into two subarrays with the same sum.

    // For example, given nums = [1, 5, 11, 5], we can partition it into two
    // subsets: [1, 5, 5] and [11]. The sum of both subsets is 12, so the
    // function should return true.

    // Optimal Solution:
    // To solve this problem efficiently, we can use the dynamic programming
    // approach known as the "0/1 Knapsack" problem. Here's the approach:
    // 1. Calculate the total sum of all elements in the nums arrray. If the sum is
    // odd, it is not possible to divide the array into two subsets with equal
    // sum, so return false.
    // 2. Initialize a boolean array dp of size sum / 2 + 1, where sum is the
    // total sum of the nums array. Each element dp[i] will indicate whether
    // it is possible to achieve a sum of i using a subset of the nums array.
    // 3. Set dp[0] as true to represent an empty subset, which can always
    // achieve a sum of 0.
    // 4. Iterate through each element num in the nums array:
    // * Starting from the end of the dp array, check if dp[j - num] is
    // true (indicating that a sum of j - num can be achieved)
    // and if j - num is within the valid range.
    // If both conditions are satisfied, set dp[j] to true.
    // 5. Finally, return dp[sum / 2], which indicates whether it is possible to
    // achieve a sum of sum / 2 using a subset of the nums array.

    // Code:
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum % 2 != 0) {
            return false;
        }

        sum /= 2;
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;

        for (int num : nums) {
            for (int j = sum; j >= num; j--) {
                dp[j] |= dp[j - num];
            }
        }

        return dp[sum];
    }

    // Time Complexity:
    // The time complexity of this solution is O(n * sum), where n is the length
    // of the nums array and sum is the total sum of the elements in nums. The
    // nested loops iterate through all the elements in nums and all the possible
    // sums from 0 to sum, resulting in a overall time complexity of O(n * sum).

    // Space Complexity:
    // The space complexity of this solution is O(sum), where sum is the total
    // sum of the elements in the nums array. We use an additional boolean
    // array dp of size sum + 1 to store the intermediate results during the
    // dynamic programming process.

}
