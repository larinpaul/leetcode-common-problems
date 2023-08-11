//// 2023/08/11 // 10:06 //

//// 518. Coin Change II // Medium //

// You ae given an integer array coins representing coins of different denominations and an
// integer amount representing a total amount of money.

// Return the number of combinations that makes up that amount. If that amount of money
// cannot be made up by any combination of the coins, return 0.

// You may assume that you have an infinite number of each kind of coin.

// The answer is guaranteed to fit into a signed 32-bit integer.

// Example 1:
// Input: amount = 5, coins = [1,2,5]
// Output: 4
// Explanation: there are four ways to make up the amount:
// 5=5
// 5=2+2+1
// 5=2+1+1+1
// 5=1+1+1+1+1

// Example 2:
// Input: amount = 3, coins [2]
// Output: 0
// Explanation: the amount of 3 cannot be made up just with coins of 2.

// Example 3:
// Input: amount = 10, coins = [10]
// Output: 1

// Constraints:
// * 1 <= coins.length <= 300
// * 1 <= coins[i] <= 5000
// * All the values of coins are unique.
// * 0 <= amount <= 5000


class CoinChangeII {

    // Explanation

    // This problem can be solved using a dynamic programming approach,
    // The main idea is to create a table dp[amount+1] where each index
    // from 0 to amount represents the current amount we want to make up.
    // Each value at dp[i] is the number of combinations that make up the
    // amount i.

    // We initialize the dp table with 0, except dp[0] which is 1 because
    // there's only one way to make up amount 0, which is to choose no
    // coins.

    // Then, we iterate through each coin in the coins array. For each coin,
    // we update the dp table from the coin value to the amount. For each
    // dp[i], we add dp[i - coin] to it. This means for each amount i, we're
    // adding the number of combinations that can make up the amount i - coin,
    // because we're considering that we've just picked this coin.

    // Finally, we return dp[amount] as the number of combinations that
    // make up the amount.

    // Optimal Solution

    // The optimal solution has a time complexity of O(amount * n) where n
    // is the number of coins, and a space complexity of O(amount), as we
    // need to keep track of the number of combinations for all amounts up
    // to the input amount.

    // Code
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }

        return dp[amount];
    }

    // Big O

    // The time complexity of this solution is O(amount * n), where n is the
    // number of coins. This is because for each coin, we iterate through the
    // dp array up to the amount.

    // The space complexity is O(amount), which is the space required for the
    // dp array.

    // This analysis assumes that basic mathematical and array operations
    // take constant time.

}
