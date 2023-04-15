//// 2023/04/15 // 11:59 //

//// 121. Best Time to Buy and Sell Stock // Easy

// You are given an array prices where prices[i]
// is the price of a given stock on the ith day.

// You want to maximize your profit by choosing a single day to buy one stock
// and choosing a different day in the future to sell that stock.

// Return the maximum profit you can achieve from this transaction.
// If you cannot achieve any profit, return 0.

// Example 1:
// Input: prices = [7,1,5,3,6,4]
// Output: 5
// Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6),
// profit = 6-1 = 5.
// Note that buying on day 2 and selling on day 1 is not allowed
// because you must buy before you sell.

// Example 2:
// Input: prices = [7,6,4,3,1]
// Output: 0
// Explanation: In this case, no transactions are done
// and the max profit = 0.

// Constraints:
// 1 <= prices.length <= 10^5
// 0 <= prices[i] <= 10^4

class BestTimeToBuyAndSellStock {
    // Define a method that takes an array of prices and returns the maximum profit
    public static int maxProfit(int[] prices) {
        // Initialize a variable to store the minimum price seen so far
        int minPrice = Integer.MAX_VALUE;
        // Initialize a variable to store the maximum profit seen so far
        int maxProfit = 0;
        // Loop through the prices array
        for (int price : prices) {
            // If the current price is lower than the minimum price,
            // update the minimum price
            if (price < minPrice) {
                minPrice = price;
            }
            // If the current price minus the minimum price
            // is greater than the maximum profit, update the maximum profit
            else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice;
            }
        }
        // Return the maximum profit
        return maxProfit;
    }

    public static void main(String[] args) {
        // Test some examples
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6 ,4})); // 5
        System.out.println(maxProfit(new int[]{7, 6, 4, 3, 1})); //  0
    }

}


