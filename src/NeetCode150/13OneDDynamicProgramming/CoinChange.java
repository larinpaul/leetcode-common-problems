//// 2023/08/05 // 9:45 //

//// 332. Coin Change // Medium //

// You are given an integer array coins representing coins of different denominations and an integer amount
// representing a total amount of money.

// Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be
// made up by any combination of the coins, return -1.

// You may assume that you have an infinite number of each kind of coin.

// Example 1:
// Input: coins = [1,2,5], amount = 11
// Output: 3
// Explanation: 11 = 5 + 5 + 1

// Example 2:
// Input: coins = [2], amount = 3
// Output: -1

// Example 3:
// Input: coins = [1], amount = 0
// Output: 0

// Constraints:
// * 1 <= coins.length <= 12
// * 1 <= coins[i] <= 2^32 - 1
// * 0 <= amount <= 10^4

import java.util.Arrays;

class CoinChange {

    // The coin change problem is a classic example of dynamic programming, which is a
    // technique of breaking down a complex problem into smaller subproblems and solving
    // them optimally. The idea is to use a one-dimensional array dp of size amount + 1, where
    // dp[i] represents the minimum number of coins needed to make up the amount i. We
    // initialize dp[0] to 0, since no coins are needed to make up 0, and the rest of the elements
    // to a large value, such as amount + 1, to indicate infinity.

    // We then iterate over each coin value c in the coins array, and for each amount i from c to amount,
    // we update dp[i] by taking the minimum of its current value and dp[i-c] + 1.
    // This means that we can either use the current coin c to make up the amount i, or not use it
    // and keep the previous optimal solution. By doing this, we are essentially trying all
    // possible combinations of coins to find the optimal one.

    // The final answer will be dp[amount], unless it is equal to amount + 1, which means that
    // no combination of coins can make up the amount, and we return - 1.

    public int coinChange(int[] coins, int amount) {
        // Initialize an array of size amount + 1
        int[] dp = new int[amount + 1];
        // Fill the array with a large value
        Arrays.fill(dp, amount + 1);
        // Base case: no coins are needed to make up 0
        dp[0] = 0;
        // Loop over each coin value
        for (int c : coins) {
            // Loop over each amount from c to amount
            for (int i = c; i <= amount; i++) {
                // Update the minimum number o coins by comparing the current value and the previous optimal solution
                dp[i] = Math.min(dp[i], dp[i - c] + 1);
            }
        }
        // Return the final answer or -1 if no solution exists
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

    // Big O:

    // The time complexity of this solution is O(n * m), where n is the length of the coins array
    // and m is the amount.

    // The space complexity is O(m), since we only use one array of size m.

}
