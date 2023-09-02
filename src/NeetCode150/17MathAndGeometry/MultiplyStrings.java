//// 2023/09/02 // 11:16 //

//// 43. Multiply Strings //

// Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and
// num2, also represented as a string.

// Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.

// Example 1:
// Input: num1 = "2", num2 = "3"
// Output: "6"

// Example 2:
// Input: num1 = "123", num2 = "456"
// Output: "56088"

// Constraints:
// * 1 <= num1.length, num2.length <= 200
// * num1 and num2 consist of digits only.
// * Both num1 and num2 do not contain any leading zero, except the number 0 itself.


class MultiplyStrings {

    // To multiply two numbers represented as strings, we can use the approach
    // similar to how we perform manual multiplication. We multiply each digit
    // of the first number with each digit of the second number and accumulate
    // the results at the appropriate positions in the final product.

    // Here's a step-by-step solution:
    // 1. First, we initialize an array result of size num1.length() + num2.length()
    // to store the resulting product as individual digits.
    // 2. We iterate through the digits of num1 from right to left (starting with
    // the least significant digit). For each digit, we iterate through the digits
    // of num2 from right to left as well.
    // 3. For each pair of digits, we calculate their product and add it to the
    // corresponding position in the result array. We need to consider the
    // carry from the previous position while performing the addition.
    // 4. After completing the multiplication, we remove any leading zeros
    // from the result array.
    // 5. Finally, we convert the result array to a string and return it as the
    // product of num1 and num2.

    // Here's the implementation of the multiply function:
    public String multiply(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        int[] result = new int[m + n]; // Array to store the resulting product

        for (int i = m - 1; i >= 0; i--) { // Iterate through digits of num1 from right to left
            for (int j = n - 1; j >= 0; j--) { // Iterate through digits of num2 from right to left
                int digit1 = num1.charAt(i) - '0'; // Get the current digit of num1
                int digit2 = num2.charAt(j) - '0'; // Get the current digit of num2
                int product = digit1 * digit2; // Calculate the product of the digits
                int pos1 = i + j; // Position of the carry from the previous position
                int pos2 = i + j + 1; // Position of the current sum
                int sum = product + result[pos2]; // Add the product to the current sum
                result[pos1] += sum / 10; // Add the carry to the next position
                result[pos2] = sum % 10; // Store the current digit in the result array
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int digit : result) { // Conver the result array to a string
            if (sb.length() != 0 || digit != 0) {
                sb.append(digit);
            }
        }

        return sb.length() == 0 ? "0" : sb.toString(); // Return the final product as a string
    }

    // The time complexity of this solution is O(m * n), where m and n are the
    // lengths of num1 and num2 respectively. Since we iterate through each
    // digit of both numbers, the time complexity is proportional to the product
    // of their lengths.

    // The space complexity is O(m + n) because we use an array of size m + n
    // to store the resulting product.

}
