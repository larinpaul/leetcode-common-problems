//// 2023/04/17 // 9:11 //

//// 70. Climbing Stairs // Easy

// You are climbing a staircase. It takes n steps to reach the top.

// Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb
// to the top?

// Example 1:
// Input: n = 2
// Output: 2
// Explanation: There are two ways to climb to teh top.
// 1. 1 step + 1 step
// 2. 2 steps

// Example 2:
// Input: n = 3
// Output: 3
// Explanation: There are three ways to climb to the top.
// 1. 1 step + 1 step + 1 step
// 2. 1 step + 2 steps
// 3. 2 steps + 1 step

// Constraints:
// 1 <= n <= 45

class ClimbingStairs {

    // The idea is to use dynamic programming to store the number of ways to climb to each
    // step. We can start from the base case where n = 0 or n = 1, and there is only one way to
    // climb to those steps. Then, for each step i from 2 to n, we can calculate the number of
    // ways to climb to it by adding the number of ways to climb to the previous two steps,
    // since we can only take 1 or 2 steps at a time.
    // This is similar to the Fibonacci sequence.

    // Here is the code in Java:
    public int climbStairs(int n) {
        // Create an array to store the number of ways for each step
        int[] dp = new int[n + 1];
        // Base case: there is only one way to climb to step 0 or 1
        dp[0] = 1;
        dp[1] = 1;
        // Loop from step 2 to n
        for (int i = 2; i <= n; i++) {
            // The number of ways to climb to step i
            // is the sum of the number of ways to climb to the previous two steps
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        // Return the number of ways to climb to the top
        return dp[n];
    }

}
