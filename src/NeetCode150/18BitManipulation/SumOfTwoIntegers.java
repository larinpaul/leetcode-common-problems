//// 2023/06/18 // 12:58 //

//// 371. Sum of Two Integers // Medium //

// Given two integers a and b, return the sum of the
// two integers without using the operators + and -.

// Example 1:
// Input: a = 1, b = 2
// Output: 3

// Example 2:
// Input: a = 2, b = 3
// Output: 5

class SumOfTwoIntegers {

    // The problem requires us to find the sum of two integers without
    // using the standard arithmetic operators. One possible approach is
    // to use bitwise operations like XOR and AND, and bit shifting to
    // simulate the addition process.

    // The XOR operator can be used to simulate the addition of two bits
    // without carry. The AND operator can be used to simulate the carry
    // that needs to be propagated to the next bit. The bit shifting
    // operation is used to move the carry to the next bit position.

    // The steps to perform the addition are as follows:
    // 1. Calculate the sum of a and b without carrying by using the XOR operator
    // 2. Calculate the carry by using the AND operator and shifting the result by one bit to the left
    // 3. Add the carry to the sum recursively until the carry becomes zero.

    public int getSum(int a, int b){
        while (b != 0) {
            int sum = a ^ b; // calculate sum without carrying
            int carry = (a & b) << 1; // calculate carry
            a = sum;
            b = carry;
        }
        return a;
    }

    // The time complexity of this approach is O(n) (or O(1) ),
    // where n is the number of bits in the input integers. Since the input integers are
    // bounded by -1000 and 1000, the number of bits is at most 11 (log2(1000) = 10.96),
    // so the time complexity is constant for this problem

}
