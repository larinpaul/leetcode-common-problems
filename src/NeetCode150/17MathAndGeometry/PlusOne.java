//// 2023/05/08 // 13:35 //

//// 66. Plus One // Easy //

// You are given a large integer represented as an integer array digits, where each
// digits[i] is the ith digit of the integer. The digits are ordered from most
// significant to the least significant in left-to-right order. The large integer does not
// contain any leading o's.

// Increment the large integer by one and return the resulting array of digits.

// Example 1:
// Input: digits = [1,2,3]
// Output: [1,2,4]
// Explanation: The array represents the integer 123.
// Incrementing by one gives 123 + 1 = 124.
// Thus, the result should be [1,2,4].

// Example 2:
// Input: digits = [4,3,2,1]
// Output: [4,3,2,2]
// Explanation: The array represents the integer 4321.
// Incrementing by one gives 4321 + 1 = 4322.
// Thus, the result should be [4,3,2,2].

// Example 3:
// Input: digits = [9]
// Output: [1,0]
// Explanation: The array represents the integer 9.
// Incrementing by one gives 9 + 1 = 10.
// Thus, the result should be [1,0].

// Constraints:
// * 1 <= digits.length <= 100
// * 0 <= digits[i] <= 9
// digits does not contain any leading 0's

import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;

class PlusOne {

    public static void main(String[] args) {

        class Solution {
            public static int[] plusOne(int[] digits) {
                // initialize a variable to store the carry over
                int carry = 1;
                // loop from the rightmost digit to the leftmost digit
                for (int i = digits.length - 1; i >= 0; i--) {
                    // add the carry over to the current digit
                    int sum = digits[i] + carry;
                    // update the current digit with the last digit of the sum
                    digits[i] = sum % 10;
                    // update the carry over with the first digit of the sum
                    carry = sum / 10;
                    // if there is no carry over, we can return the modified array
                    if (carry == 0) {
                        return digits;
                    }
                }
                // if we still have a carry over after reaching the leftmost digit,
                // we need to create a new array with one extra element at the beginning
                int[] newDigits = new int[digits.length + 1];
                // assign the first element to one
                newDigits[0] = 1;
                // copy the rest of the elements from the original array
                for (int i = 1; i < newDigits.length; i++) {
                    newDigits[i] = digits[i - 1];
                }
                // return the new array
                return newDigits;
            }

        }
        int[] digits = {1, 2, 3};
        int[] solution = Solution.plusOne(digits);
        System.out.println(Arrays.toString(solution));

        int[] digitsToo = {9};
        int[] solutionToo = Solution.plusOne(digits);
        System.out.println(Arrays.toString(solutionToo));

        // Output:
        // Input: digits = [1,2,3] Output: [1,2,4]
        // Input: digits = [4,3,2,1] Output: [4,3,2,2]
        // Input: digits = [9] Output: [1,0]

        // The time complexity is O(n),
        // where n is the length of the input array. This is because we need to iterate
        // through the array once in the worst case, and creating a new array takes O(n) time as well.


    }


}





