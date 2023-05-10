//// 2023/05/10 // 11:15 //

//// 338. Counting Bits // Easy //

// Given an integer n, return an array ans of length n + 1
// such that for each i (0 <= i <= n), ans[i] is
// the number of 1's in the binary represenation of i.

// Example 1:
// Input: n = 2
// Output: [0,1,1]
// Explanation:
// 0 --> 0
// 1 --> 1
// 2 --> 10

// Example 2:
// Input: n = 5
// Output: [0,1,1,2,1,2]
// Explanation:
// 0 --> 0
// 1 --> 1
// 2 --> 10
// 3 --> 11
// 4 --> 100
// 5 --> 101

// Constraints:
// * 0 <= n <= 10^5

// Follow up:
// * It is very easy to come up with a solution with a runtime of O(n log n).
// Can you do it in linear time O(n) and possible in a single pass?
// * Can you do it without using any built-in function
// (i.e., like __builtin_popcount in C++)?

class CountingBits {

    // The idea is to use dynamic programming to store the number of 1's in the binary representation
    // of previous numbers and use them to calculate the current number. For example, if we know
    // that ans[i] is then umber of 1's in i, then ans[i+1] is either ans[i] + 1 (if i is even) or ans[i] (if i is
    // odd). This is because adding 1 to an even number will flip the rightmost 0 bit to 1, while adding
    // 1 to an odd number will flip all the trailing 1 bits to 0 and the rightmost 0 bit to 1.
    // Therefore, we can use a simple formula:

    // ans[i] = ans[i/2] + i % 2

    // This way, we can flip up the array ans from 0 to n in linear time. The code is as follows:
    public int[] countBits(int n) {
        // create an array of size n + 1
        int[] ans = new int[n + 1];
        // initialize the first element to 0
        ans[0] = 0;
        // loop from 1 to n
        for (int i = 1; i <= n; i++) {
            // use the formula to calculate the number of 1's
            ans[i] = ans[i / 2] + i % 2;
        }
        // return the array
        return ans;
    }



    // The time complexity of this solution is O(n), since we only loop through the array once.
    // The space complexity is also O(n), since we need to store the array of size n + 1.

}










