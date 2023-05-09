//// 2023/05/09 //

//// 191. Number of 1 Bits // Easy //

// Write a function that takes the binary representation of an unsigned interger
// and returns the number of '1' bits its has (also known as the Hamming weight).

// Note:

// * Note that in some languages, such as Java, there is no unsigned integer type.
// In this case, the input will be given as a signed integer type.
// It should not affect your implementation, as integer's internal
// binary representation is tha same, whether it is signed or unsigned.

// * In Java, the compiler represents the signed integers using 2's complement notation.
// Therefore, in Example 3, the input represents the signed integer -3.

// Example 1:
// Input : n = 00000000000000000000000000001011
// Output: 3
// Explanation: The input binary string 00000000000000000000000000001011
// has a total of three '1' bits.

// Example 2:
// Input: n = 00000000000000000000000010000000
// Output: 1
// Explanation: The input binary string 00000000000000000000000010000000
// has a total of one '1' bit.

// Example 3:
// Input: n = 11111111111111111111111111111101
// Output: 31
// Explanation: The input binary string 11111111111111111111111111111101
// has a total of thirty-one '1' bits.

// Constraints:

// * The input must be a binary string of length 32.

// Follow up:
// If this function is called many times, how would you optimize it?

class NumberOf1Bits {

    // The problem asks us to write a function that counts the number of 1 bits in the binary
    // representation of an unsigned integer. For example, if the input is 11, which is 1011 in binary,
    // the output should be 3, because there are three 1 bits in 1011.

    // One possible way to solve this problem is to use a loop and a bit mask. A bit mask is a value
    // that we can use to isolate a specific bit in a number. For example, if we want to check the last
    // significant bit (the rightmost bit) of a number n, we can use a bit mask of 1, which is 0001 in
    // binary. We can use the bitwise AND operation (&) to compare n and the bit mask, and see if the
    // result is 0 or not. If the result is not 0, it means that the bit we are checking is 1, and we can
    // increment our count. If the result is 0, it means that the bit we are checking is 0, and we can
    // ignore it.

    // To check all the bits in n, we can use a loop that shifts the bit mask to the left by one position
    // each time, until the bit mask becomes 0. For example, if n is 11 (1011), we can use the
    // following bit masks: 0001, 0010, 0100, and 1000. Each time we compare n and the bit mask
    // with bitwise AND, and increment our count if the result is not 0.


    // You need to treat n as an unsigned value.
    public int hammingWeightSuboptimal(int n) {
        // initialize count to 0
        int count = 0;
        // initialize bit mask to 1
        int mask = 1;
        // loop through all the bits of n
        for (int i = 0; i < 32; i++) {
            // compare n and mask with bitwise AND
            if ((n & mask) != 0) {
                // if the result is not 0, increment count
                count++;
            }
            // shift mask to the left by one position
            mask <<= 1;
        }
        // return count
        return count;
    }

    // Big O:

    // The time complexity of this solution is O(1), because we always loop through a fixed number of
    // bits (32) regardless of the input value. The space complexity is also O(1), because we only use
    // constant extra space for variables.

    // However, that was a suboptimal solution, because it always loops through all the bits of n,
    // even if some of them are 0. A more optimal solution would be to use a trick that only loops
    // through the bits that are 1. The trick is to use the expression n & (n - 1),
    // which clears the least significant 1 bit in n.
    // For example, if n is 11 (1011), then n - 1 is 10 (1010), and n & (n - 1) is 10 (1010).
    // This clears the rightmost 1 bit in n. We can repeat this process until n becomes o,
    // and count how many times we do this.
    // This way, we only loop through the number of 1 bits in n, which can be much less than 32.

    // Here is the code for this optimal solution:

    public int hammingWeight(int n) {
        // initialize count to 0
        int count = 0;
        // loop until n becomes 0
        while (n != 0) {
            // increment count
            count++;
            // clear the least significant 1 bit in n
            n &= (n - 1);
        }
        // return count
        return count;
    }

    // The time complexity of this solution is still O(1), because in the worst case, n has all 1 bits and
    // we still loop through 32 times.
    // However, the average case is much better than the previous
    // solution, because we only loop through the number of 1 bits in n, which can be much less than 32.
    // The space complexity is also O(1), because we only use constant extra space for variables.

}










