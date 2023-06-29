//// 2023/06/29 // 22:59 //

//// 213. House Robber II // Medium //

// You are a professional robber planning to rob houses along a street.
// Each house has a certain amount of money stashed.
// All houses at this place are arranged in a circle.
// This means the first house is the neighbor of the last one.
// Meanwhile, adjacent houses have a security system connected,
// and it will automatically contact the police if two adjacent houses were broken into on the same night.

// Given an integer array nums representing the amount of money of each house,
// return the maximum amount of money you can rob tonight without alerting the police.

// Example 1:
// Input: nums = [2,3,2]
// Output: 3
// Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2),
// because they are adjacent houses.

// Example 2:
// Input: nums = [1,2,3,1]
// Output: 4
// Explanation: Tob house 1 (money = 1) and then rob house 3 (money = 3).
// Total amount you can rob = 1 + 3 = 4.

// Example 3:
// Input: nums = [1,2,3]
// Output: 3

// Constraints:
// * 1 <= nums.length <= 100
// * 0 <= nums[i] <= 1000

class HouseRobberII {

    // The idea is to split the problem into two subproblems:
    // one where we rob the first house and skip the last one, and another where we skip the
    // first house and rob the last one. Then we take the maximum of the two subproblems
    // as the first answer.

    // To solve each subproblem, we can use a similar approach as in the original House Robber problem.
    // We use an aray dp to store the maximum amount of money we can rob up to each house.
    // For each house i, we have two options: either rob it or skip it. If we rob it, we add nums[i]
    // to the previous maximum amount of money we can rob without robbing the adjacent house,
    // which is dp[i-2]. If we skip it, we just take the previous maximum amount of money we can rob,
    // which is dp[i-1]. We take the maximum of these two options as dp[i].

    public int rob(int[] nums) {
        // edge case: if there is only one house, return its value
        if (nums.length == 1) return nums[0];

        // subproblem 1: rob from house 0 to house n-2
        int max1 = robRange(nums, 0, nums.length - 2);

        // subproblem 2: rob form house 1 to house n-1
        int max2 = robRange(nums, 1, nums.length - 1);

        // return the maximum of the two subproblems
        return Math.max(max1, max2);
    }

    // helper method to solve the subproblem of robbing a range of houses
    private int robRange(int[] nums, int start, int end) {
        // initialize the dp array with length equal to the number of houses in the range
        int[] dp = new int[end - start + 1];

        // base case: if there is only one house in the range, return its value
        if (start == end) return nums[start];

        // base case: if there are two houses in the range, return the maximum of their values
        if (start + 1 == end) return Math.max(nums[start], nums[end]);

        // fill in the dp array from left to right
        dp[0] = nums[start]; // the first house in the range
        dp[1] = Math.max(nums[start], nums[start + 1]); // the second house in the range
        for (int i = 2; i < dp.length; i++) {
            // for each house i in the range, we have two options: rob it or skip it
            // if we rob it, we add nums[start + i] to the previous maximum amount of money
            // we can rob without robbing the adjacent house, which is dp[i-2]
            // if we skip it, we jut take the previous maximum amount of money we can rob,
            // which is dp[i-1]
            // we take the maximum of these two options as dp[i]
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[start + i]);
        }

        // return the last element of the dp array,
        // which is the maximum amount of money we can rob in the range
        return dp[dp.length - 1];
    }

    // Big O:

    // The time complexity of this solution is O(n), where n is the length of nums.

    // The space complexity is O(n), since we use an extra array dp to store intermediate results.
    // We can optimize the space complexity to O(1) by using two variables
    // to store only the previous two elements of dp.

}
