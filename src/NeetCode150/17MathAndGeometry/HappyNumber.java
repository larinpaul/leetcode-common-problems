//// 2023/05/07 // 14:21 //

/// 202 //  Happy Number // Easy //

// Write an algorithm to determine if a number n is happy.

// A happy number is a number defined by the following process:

// * Starting with any positive integer, replace the number by the sum of the squares of its digits.

// * Repeat the process until the number equals 1 (where it will stay), or it loops
// endlessly in a cycle which does not include 1.

// * Those numbers for which this process ends in 1 are happy.

// Return true if n is a happy number, and false if not.

// Example 1:
// Input: n = 19
// Output: true
// Explanation:
// 1^2 + 9^2 = 82
// 8^2 + 2^2 = 68
// 6^2 + 8^2 = 100
// 1^2 + 0^2 + 0^2 = 1

// Example 2:
// Input: n = 2
// Output: false

// Constraints:
// * 1 <= n <= 2^31 - 1

import java.util.HashSet;

class HappyNumber {

    public boolean isHappy(int n) {
        // Use a HashSet to store the numbers that have been seen before
        HashSet<Integer> seen = new HashSet<>();
        // Loop until n is 1 or n is already in the set
        while (n != 1 && !seen.contains(n)) {
            // Add n to the set
            seen.add(n);
            // Calculate the next number by summing the squares of the digits of n
            int next = 0;
            while (n > 0) {
                int digit = n % 10;
                next += digit * digit;
                n /= 10;
            }
            // Update n to be the next number
            n = next;
        }
        // Return true if n is 1, false otherwise
        return n == 1;
    }
}

// The solution is based on the idea that if a number is not happy, it will eventually fall into a cycle
// of repeating numbers. Therefore, we can use a HashSet to keep track of the numbers that we
// have seen before and check if we encounter a repeated number. If we do, we return false. IF we
// reach 1, we return true.

// The time complexity of this solution is O(log n), since each iteration reduces n by approximately
// one digit. The space complexity is O(log n) as well, since the HashSet can store up to log n
// numbers.

