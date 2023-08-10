//// 2023/08/10 // 10:58 //

//// 309. Best Time to Buy and Sell Stock with Cooldown // Medium //

// You are given an array prices where prices[i] is the price of
// a given stock on the ith day.

// Find the maximum profit you can achieve. You may complete as
// many transactions as you like (i.e., buy one and sell one share of
// the stock multiple times) with the following restrictions:
// * After you sell your stock, you cannot buy stock on the next
// day (i.e., cooldown one day).

// Note: You may not engage in multiple transactions
// simultaneously (i.e., you must sell the stock before you buy
// again).

// Example 1:
// Input: prices = [1,2,3,0,2]
// Output: 3
// Explanation: transactions = [buy, sell, cooldown, buy, sell]

// Example 2:
// Input: prices = [1]
// Output: 0

// Constraints:
// * 1 <= prices.length <= 5000
// * 0 <= pries[i] <= 1000

class BestTimeToBuyAndSellStockWithCooldown {

    // Problem Explanation:
    // You are given an array prices where prices[i] represents the price
    // of a stock on the ith day. Your goal is to find the maximum profit that
    // can be achieved by buying and selling the stock, subject to the
    // following restrictions:
    // 1. After selling a stock, you cannot buy another stock on the next
    // day (cooldown period of one day).
    // 2. You cannot engage in multiple transactions simultaneously
    // (i.e., you must sell the stock before buying again).

    // Solution:
    // To solve this problem you can use dynamic programming.
    // Let's define two arrays, buy and sell, where buy[i] represents the maximum
    // profit that can be achieved on the ith day with the last action being a
    // buy, and sell[i] represents the maximum profit that can be
    // achieved on the ith day with the last action being a sell.

    // For each day i, the maximum profit with the last action being a buy
    // can be calculated as follows:
    // 1. If the previous day was a cooldown day (i.e., no buy or sell), then
    // buy[i] = sell[i-1] - prices[i].
    // 2. If the previous day was a buy day, then buy[i] remains the same
    // as buy[i-1].

    // For each day i, the maximum profit with the last action being a sell
    // can be calculated as follows:
    // 1. If the previous day was a buy day, then sell[i] = buy[i-1] + prices[i].
    // 2. If the previous day was a sell day, then sell[i] remains the same as sell[i-1].

    // Finally, the maximum profit that can be achieved will be in sell[prices.length - 1]
    // because selling on the last day will give the maximum overall profit.

    // Optimal Code (Java):
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }

        int[] buy = new int[prices.length];
        int[] sell = new int[prices.length];

        buy[0] = -prices[0];
        sell[0] = 0;

        for (int i = 1; i < prices.length; i++) {
            buy[i] = Math.max((i >= 2 ? sell[i-2] : 0) - prices[i], buy[i-1]);
            sell[i] = Math.max(buy[i-1] + prices[i], sell[i-1]);
        }

        return sell[prices.length - 1];
    }

    // In the code above, we initialize buy[0] as -prices[0] because we
    // are buying on the first day, and sell[0] as 0 because we cannot sell
    // on the first day.

    // The time complexity of this solution is O(n), where n is the length of
    // the prices array, because we iterate through the array once.

    // The space complexity is O(n) as well because we use two arrays of size n to store
    // the buy and sell values.

}
