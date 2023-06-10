//// 2023/06/10 // 18:36 //

//// 198. House Robber // Used to be Easy, now Medium //

// You are a professional robber planning to rob houses along a street. Each house
// has a certain amount of money stashed, the only constraints stopping you from
// robbing each of them is that adjacent houses have security systems connected
// and it will automatically contact the police if two adjacent houses were
// broken into on the same night.

// Given an integer array nums representing the amount of money of each house,
// return the maximum amount of money you can rob tonight without alerting the
// police.

// Example 1:
// Input: nums = [1,2,3,1]
// Output: 4
// Explanation:
// Rob house 1 (money = 1) and then rob house 3 (money = 3)
// Total amount you can rob = 1 + 3 = 4.

// Example 2:
// Input: nums = [2,7,9,3,1]
// Output: 12
// Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
// Total amount you can rob = 2 + 9 + 1 = 12.

// Constraints:
// * 1 <= nums.length <= 100
// * 0 <= nums[i] <= 400

class HouseRobber {

    // Solution:
    // The idea is to use dynamic programming to store the maximum amount of money
    // that can be robbed up to each house. We can define an array dp such that dp[i] represents
    // the maximum amount of money that can be robbed up to house i.
    // Then we have two cases:
    // * If we rob house i, then we cannot rob house i-1, so the maximum amount we can get is dp[i-2] + nums[i].
    // * If we do not rob house i, then we can rob house i-1, so teh maximum amount we can get is dp[i-1].

    // Therefore, we have the recurrence relation: dp[i] = max(dp[i-2] + nums[i], dp[i-1]).
    // The base cases are dp[0] = nums[0] and dp[1] = max(nums[0], nums[1]).
    // The final answer is dp[n-12], where n is the length of nums.

    // Explanation:
    // To illustrate the idea, let's take an example with nums = [2,7,9,3,1].
    // We can build the dp array as follows:
    // dp[0] = 2
    // rob the first house dp[1] = max(2,7) = 7
    // choose between the first and second house dp[2] = max(2 + 9, 7) = 11
    // choose between robbing the first and third house or the second house dp[3] = max(2 + 9, 7)
    // choose between robbing the second and fourth house or the first and third house dp[4] = max(11 + 1, 11) = 12
    // choose between robbing the first and third and fifth house or the second and fourth house
    // The final answer is dp[4] = 12.

    // Code:
    public int robUnoptimized(int[] nums) {
        // edge case: empty array
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // edge case: one element array
        if (nums.length == 1) {
            return nums[0];
        }
        //initialize dp array
        int n = nums.length;
        int[] dp = new int[n];
        // base cases
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        // loop through the rest of the array
        for (int i = 2; i < n; i++) {
            // update dp[i] using recurrence relation
            dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]);
        }
        // return the final answer
        return dp[n-1];
    }

    // Big O:
    // The time complexity of this solution is O(n), where n is the length of nums,
    // since we loop through the array once and do constant work for each element.
    // The space complexity is also O(n), since we use an extra array of size n to store the dp values.
    // However, we can optimize the space complexity to O(1),
    // by using two variables to store the previous two dp values instead of an array.

    // Here is the optimized code:
    public int rob(int[] nums) {
        // edge case: empty array
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // edge case: one element array
        if (nums.length == 1) {
            return nums[0];
        }
        // initialize two variables to store previous two dp values
        int prev1 = nums[0]; // dp[0]
        int prev2 = Math.max(nums[0], nums[1]); // dp[1]
        // loop through the rest of the array
        for (int i = 2; i < nums.length; i++) {
            // update current dp value using recurrence relation
            int curr = Math.max(prev1 + nums[i], prev2);
            // update previous two values for next iteration
            prev1 = prev2;
            prev2 = curr;
        }
        // return the final answer
        return prev2;
    }
}
