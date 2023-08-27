//// 2023/08/27 // 10:43 //

//// 312. Burst Balloons // Hard //

// You are given n balloons, indexed from 0 to n - 1. Each balloon is painted with a number on it
// represented by an array nums. You are asked to burst all the balloons.

// If you burst the ith balloon, you will get nums[i - 1] * nums[i] * nums[i + 1] coins. If i - 1 or i + 1
// goes out of bounds of the array, then treat it as if there is a balloon with a 1 painted on it.

// Return the maximum coins you can collect by bursting the balloons wisely.

// Example 1:
// Input: nums = [3,1,5,8]
// Output: 167
// Explanation:
// nums = [3,1,5,8] --> [3,5,8] --> [3,8] --> [8] --> []
// coins = 3*1*5 + 3*5*8 + 1*3*8 + 1*8*1 = 167

// Example 2:
// Input: nums = [1,5]
// Output: 10

// Constraints:
// * n == nums.length
// * 1 <= n <= 300
// * 0 <= nums[i] <= 100


class BurstBalloons {

    // Explanation
    // * The idea is to find the optimal order of bursting the balloons such that we maximize
    // the coins collected.
    // * However, it is hard to decide which balloon to burst first, since it will affect the
    // coins obtained by bursting the other balloons.
    // * Therefore, we use a reverse thinking: we consider which balloon to burst last in
    // each subproblem.
    // * By doing so, we can fix the value of nums[i - 1] and nums[i + 1] as they will not
    // change after bursting the last balloon.
    // * We can then use dynamic programming to store and reuse the optimal results for
    // smaller subproblems.
    // * We also add two extra balloons with value 1 to both ends of the array, so that we
    // don't have to worry about boundary cases.

    public int maxCoins(int[] nums) {
        // add 1 to both ends of the array
        int n = nums.length + 2;
        int[] newNums = new int[n];
        for (int i = 0; i < nums.length; i++) {
            newNums[i + 1] = nums[i];
        }
        newNums[0] = 1;
        newNums[n - 1] = 1;

        // create a memoization table to store the optimal results for subproblems
        int[][] memo = new int[n][n];

        // use a bottom-up approach to fill the table
        for (int len = 2; len < n; len++) { // length of the subproblem
            for (int left = 0; left < n - len; left++) { // left index of the subproblem
                int right = left + len; // right index of the subproblem
                // iterate over all possible last balloons to burst in the subproblem
                for (int i = left + 1; i < right; i++) {
                    // calculate the coins obtained by bursting the ith balloon
                    int coins = newNums[left] * newNums[i] * newNums[right];
                    // add the coins obtained by solving the left and right subproblems
                    coins += memo[left][i] + memo[i][right];
                    // update the memo table with the maximum coins
                    memo[left][right] = Math.max(memo[left][right], coins);
                }
            }
        }

        // return the optimal result for the whole problems
        return memo[0][n - 1];
    }

    // Big O:
    // * The time complexity is O(n^3), where n is the length of the array. This is because we
    // have three nested loops to fill the memo table.
    // * The space complexity is O(n^2), where n is the length of the array. This is because
    // we use a two-dimensional array to store the optimal results of subproblems.

}
