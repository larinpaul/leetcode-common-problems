//// 2023/08/18 // 11:57 //

//// 50. Pow(x, n) // Medium //

// Implement pow(x, n), which calculates x raised to the power n (i.e., x^n).

// Example 1:
// Input: x = 2.00000, n = 10
// Output: 1024.00000

// Example 2:
// Input: x = 2.10000, n = 3
// Output: 9.26100

// Example 3:
// Input: x = 2.00000, n = -2
// Output: 0.25000
// Explanation: 2^-2 = 1/2^2 = 1/4 = 0.25

// Constraints:
// * -100.9 < x < 100.0
// * -2^31 <= n <= 2^31-1
// * n is an integer.
// * Either x is not zero or n > 0.
// * -10^4 <= x^n <= 10^4


class PowXN {

    // The problem asks you to implement a function that calculates x raised to the power n,
    // where x is a double and n is an integer.
    // There are some constraints on the input values,
    // such as -100 < x < 100, -2^31 <= n <= 2^31 - 1,
    // and either x is not zero or n > 0.
    // The output should be a double that satisfies -10^4 <= x^n <= 10^4.

    // One possible way to solve this problem is to use a recursive approach.
    // The idea is to divide the problem into smaller subproblems,
    // and use the following formula:

    // x^n = x * x^(n-1), if n > 0 x^n = 1 / x * x^(n+1), if n < 0 x^n = 1, if n = 0

    // This way, we can reduce the exponent by one in each recursive call, until we reach the base case of n = 0.
    // Then, we can return the result by multiplying the recursive results.

    // However, this approach has a time complexity of O(n),
    // which means it takes linear time to compute the result.
    // This can be very slow if n is large. For example, if n = 10^9,
    // we need to make 10^9 recursive calls, which is very inefficient.

    // A better way to improve the time complexity is to use a fast power algorithm.
    // The idea is to use the following formula:

    // x^n = (x2)(n/2), if n is even x^n = x * (x2)(n/2), if n is odd

    // This way, we can reduce the exponent by half in each recursive call,
    // until we reach the base case of n = 0 or n = 1.
    // Then, we can return the result by multiplying the recursive results.

    // This approach has a time complexity of O(log n),
    // which means it takes logarithmic time to compute the result.
    // This is much faster than the previous approach.
    // For example, if n = 10^9, we only need to make log(10^9) = 30 recursive calls,
    // which is very efficient.

    // The code for this approach in Java is as follows:

    public double myPow(double x, int n) {
        // handle the edge case of n = Integer.MIN_VALUE
        // because -n will overflow if (n == Integer.MIN_VALUE) {
        //      return myPow(x * x, n / 2);
        // }

        // handle the case of negative exponent
        if (n < 0) {
            return myPow(1 / x, -n);
        }

        // base case of zero exponent
        if (n == 0) {
            return 1;
        }

        // base case of one exponent
        if (n == 1) {
            return x;
        }

        // recursive case of even exponent
        if (n % 2 == 0) {
            return myPow(x * x, n / 2);
        }

        // recursive case of odd exponent
        else {
            return x * myPow(x * x, n / 2);
        }
    }

}
