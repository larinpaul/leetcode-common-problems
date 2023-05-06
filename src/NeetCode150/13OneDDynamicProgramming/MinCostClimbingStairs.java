//// 2023/05/06 // 11:35 //

//// 746. Min Cost Climbing Stairs

// You are given an integer array cost where cost[i] is the cost of ith step on a
// startcase. Once you pay the cost, you can either climb one or two steps.

// You can either start from the step with index 0, or the step with index 1.

// Return the minimum cost to reach the top of the floor.

// Example 1:
// Input: cost = [10,15,20]
// Output: 15
// Explanation: You will start at index 1.
// - Pay 15 and climb two steps to reach the top.
// The total cost is 15.

// Example 2:
// Input: cost = [1,100,1,1,1,100,1,1,100,1]
// Output: 6
// Explanation: You will start at index 0.
// - Pay 1 and climb two steps to reach index 2.
// - Pay 1 and climb two steps to reach index 4.
// - Pay 1 and climb two steps to reach index 6.
// - Pay 1 and climb one step to reach index 7.
// - Pay 1 and climb two steps to reach index 9.
// - Pay 1 and climb one step to reach the top.
// The total cost is 6.

// Constraints:
// * 2 <= cost.length <= 1000
// * 0 <= cost[i] <= 999

class UnoptimizedSolution {

    public int minCostClimbingStrais(int [] cost) {
        // create an array to store the minimum cost at each step
        int[] dp = new int[cost.length];
        // base cases: the minimum cost at the first and second step is the cost itself
        dp[0] = cost[0];
        dp[1] = cost[1];
        // iterate from the third step to the top
        for (int i = 2; i < cost.length; i++) {
            // the minimum cost at each step is the cost plus the minimum of the previous two steps
            dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
        }
        // Return the minimum of the last two steps as the final answer
        return Math.min(dp[cost.length - 1], dp[cost.length - 2]);
    }

    // The explanation is as follows:

    // * We use dynamic programming to solve this problem. We define dp[i] as the minimum cost to reach
    // the ith step.

    // * The base cases are dp[0] = cost[0] and dp[1] = cost[1], since we can start from either the first or
    // second step.

    // * For each subsequent step, we have two choices: either climb one step from the previous step, or
    // climb two steps from the second last step. We choose the option that has the lower cost, and add it
    // to the current cost. This gives us the recurrence relation: dp[i] = cost[i] + min(dp[i - 1], dp[i - 2]).

    // * After iterating through all the steps, we return the minimum of the last two steps as the final answer,
    // since we can reach the top from either of them.

    // The time complexity of this solution is O(n), where n is the length of the cost array, since we only need
    // to iterate through it once. The space complexity is also O(n), since we need an extra array to store the
    // dp values. However, we can optimize the space complexity to O(1) by using two variables to store the
    // previous two steps instead of an array. This would make the code look like this:
    class MinCostClimbingStairs {
        public int minCostClimbingStairs(int[] cost) {
            // initialize two variables to store the previous two steps
            int prev = cost[0];
            int curr = cost[1];
            // iterate from the third step to the top
            for (int i = 2; i < cost.length; i++) {
                // update the next step as the cost plus the minimum of the previous two steps
                int next = cost[i] + Math.min(prev, curr);
                // update the previous two steps
                prev = curr;
                curr = next;
            }
            // return the minimum of the last two steps as the final answer
            return Math.min(prev, curr);
        }


    }

}




















