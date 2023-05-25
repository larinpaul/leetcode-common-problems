//// 2023/05/25 // 18:56 //

//// 875. Koko Eating Bananas // Medium //

// Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i]
// bananas. The guards have gone and will come back in h hours.

// Koko can decide her bananas-per-hour eating speed of k.
// Each hour, she chooses some pile of bananas and eats k bananas from that pile.
// If the pile has less than k bananas, she eats all of them instead
// and will not eat any more bananas during this hour.

// Koko likes to eat slowly but still wants to finish eating all the bananas
// before the guard returns.

// Return the minimum integer k such that she can eat all the bananas within h hours.

// Example 1:
// Input: piles = [3,6,7,11], h = 8
// Output: 4

// Example 2:
// Input: piles = [30,11,23,4,20], h = 5
// Output: 30

// Example 3:
// Input: piles = [30,11,23,4,20], h = 6
// Output: 23

// Constraints:
// * 1 <= piles.length <= 10^4
// * piles.length <= h <= 10^9
// 1 <= piles[i] <= 10^9

class KokoEatingBananas {

    // Explanation: The problem is to find the minimum eating speed k that allows
    // Koko to finish all the bananas in h hours. One way to approach this problem is to
    // use binary search. We can define a range of possible values for k, from 1 (the
    // minimum possible speed) to the maximum number of bananas in any pile (the
    // maximum possible speed). Then, we can check if a given k is valid or not by
    // simulating how many hours it would take Koko to eat all the bananas with that
    // speed. If it takes less than or equal to h hours, then k is valid.
    // Otherwise, it is invalid.
    // We can use binary search to find the smallest valid k in the range.

    // Solution:
    public int minEatingSpeed(int[] piles, int h) {
        // Find the maximum number of bananas in any pile
        int max = 0;
        for (int pile : piles) {
            max = Math.max(max, pile);
        }
        // Define the range of possible values for k
        int low = 1;
        int high = max;
        // Use binary search to find the smallest valid k
        while (low < high) {
            // Try the middle value as k
            int mid = low + (high - low) / 2;
            // Check if k is valid by simulating how many hours it takes to eat all the bananas
            int hours = 0;
            for (int pile : piles) {
                // If the pile has less than k bananas, eat all of them
                // Otherwise, eat k bananas and round up the remaining ones
                hours += (pile + mid - 1) / mid;
            }
            // If it takes less than or equal to h hours, k is valid
            // SO we can try smaller values for k
            if (hours <= h) {
                high = mid;
            } else {
                // Otherwise, k is invalid
                // So we can try larger values for k
                low = mid + 1;
            }
        }
        // Return the smallest valid k
        return low;
    }

    // Big O:
    // The time complexity of this solution is O(n log m), where n is the number
    // of piles and m is the maximum number of bananas in any pile.
    // This is because we use binary search on a range of size m,
    // and for each value we try, we need to iterate over all the piles and do some arithmetic operations.
    // The space complexity of this solution is O(1), as we only use constant extra space.

}
