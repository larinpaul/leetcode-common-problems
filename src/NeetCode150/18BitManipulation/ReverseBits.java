//// 2023/05/11 // 23:18 //

//// 190. Reverse Bits //

// Reverse bits of a given 32 bits unsigned integer.

// Note:

// * Note that in some languages, such as Java, there is no unsigned integer type.
// In this case, both input and output will be given as a signed integer type.
// They should not affect your implementation, as the integer's internal binary representation
// is the same, whether it is signed or unsigned.

// * In Java, the compiler represents the signed integers using 2's complement notation.
// Therefore, in Example 2 above, the input represents the signed integer -3
// and the output represents the signed integer -1073741825.

// Example 1:
// Input: n = 00000010100101000001111010011100
// Output:    964176192 (00111001011110000010100101000000)
// Explanation: The input binary string 00000010100101000001111010011100
// represents the unsigned integer 43261596,
// so return 964176192 which its binary representation is 00111001011110000010100101000000.

// Example 2:
// Input: n = 11111111111111111111111111111101
// Output:   3221225471 (10111111111111111111111111111111)
// Explanation: The input binary string 11111111111111111111111111111101
// represents the unsigned integer 4294967293,
// so return 3221225471 which its binary representation is 10111111111111111111111111111111.

// Constraints:
// * The input must be a binary string of length 32

// Follow up: If this function is called many times, how would you optimize it?


// Solution:
// To reverse the bits of a given 32 bits unsigned integer, we can use bitwise operations
// to manipulate each bit individually. We can iterate over the 32 bits of the input integer from right
// to left, and append each bit to a new integer that will store the reversed bits. To get the
// rightmost bit of the input integer, we can use the bitwise AND operation with 1, which will return
// 1 if the bit is 1 and 0 if the bit is 0. To append a bit to the new integer, we can use the bitwise
// left shift operation to make space for the new bit, and then use the bitwise OR operation to set
// the new bit. To move to the next bit of the input integer, we can use the bitwise right shift
// operation to discard the rightmost bit.

// Explanation: Here is an example of how the algorithm works
// for n = 00000010100101000001111010011100:\
// Initialize a new integer result = 0
// Loop from i = 0 to i = 31
// Get the rightmost bit of n by doing n & 1.
// For example, when i = 0, n & 1 = 00000010100101000001111010011100 & 00000000000000000000000000000001 = 0
// Left shift result by one bit to make space for the new bit.
// For example, when i = 0, result << 1 = 0 << 1 = 0
// Set the new bit of result by doing result | (n & 1).
// For example, when i = 0, result | (n & 1) = 0 | 0 = 0
// Right shift n by one bit to discard the rightmost bit.
// For example, when i = 0, n >> 1 = 00000010100101000001111010011100 >> 1 = 00000001010010100000111101001110
// Return result

public class ReverseBits {

    // You need to treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0; // initialize a new integer to store the reversed bits
        for (int i = 0; i < 32; i++) { // loop over the 32 bits of n
            result <<= 1; // left shift result by one bit to make space for the new bit
            result |= (n & 1); // set teh new bit of result by doing bitwise OR with the rightmost bit of n
            n >>>= 1; // right shift n by one bit (use unsigned right shift to avoid sign extension)
        }
        return result; // return the reversed bits
    }

    // Big O:
    // The time complexity of this algorithm is O(1), since we only iterate over a fixed number of bits (32).
    // The space complexity is also O(1), since we only use a constant amount of extra space (result).



}









