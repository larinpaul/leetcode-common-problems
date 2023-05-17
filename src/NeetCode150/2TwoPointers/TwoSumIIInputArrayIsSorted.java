//// 2023/05/17 // 11:32 //

//// 167. To Sum II - Input Array Is Sorted // Medium //

// Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order,
// find two numbers such that they add up to a specific target number.
// Let these two numbers be numbers[index1] and numbers[index2]
// where 1 <= index1 < index2 <= numbers.length.

// Return the indices of the two numbers, index1 and index2, added by one
// as an integer array [index1, index2] of length 2.

// The tests are generated such that there is exactly one solution.
// You may not use the same element twice.

// Your solution must use only constant extra space.

// Example 1:
// Input: numbers = [2,7,11,15], target = 9
// Output: [1,2]
// Explanation: The sum of 2 and 7 is 9.
// Therefore, index1 = 1, index2 = 2.
// We return [1, 2].

// Example 2:
// Input: numbers = [2,3,4], target = 6
// Output: [1,3]
// Explanation: The sum of 2 and 4 is 6.
// Therefore, index1 = 1, index2 = 3.
// We return [1, 3].

// Example 3:
// Input: numbers = [-1,0], target = [-1]
// Output: [1,2]
// Explanation: The sum of -1 and 0 is -1.
// Therefore, index1 = 1, index2 = 2. We return [1, 2].

// Constraints:
// * 2 <= numbers.length <= 3 * 10^4
// * -1000 <= numbers[i] <= 1000
// * numbers is sorted in non-descending order.
// * -1000 <= target <= 1000
// * The tests are generated such that there is exactly one solution.

class TwoSumIIInputArrayIsSorted {

    // Solution: We can use two pointers to scan the array from both ends.
    // We initialize a pointer i to the leftmost element and a pointer j to the rightmost element.
    // Then we compare the sum of numbers[i] and numbers[j] with the target.
    // If the sum is equal to the target, we return [i+1,j+1] as the answer.
    // If the sum is less than the target, we increment i to move to a larger element.
    // If the sum is greater than the target, we decrement j to move to a smaller element.
    // We repeat this process until we find the answer or i and j cross each other.

    // Explanation:
    // The reason why this algorithm works, is because the array is sorted in non-decreasing order.
    // This means that if we move it to the right, the sum will increase,
    // and if we move j to the left, the sum will decrease.
    // Therefore, by adjusting i and j based on the comparison with the target,
    // we can narrow the search space and find the answer in linear time:

    public int[] twoSum(int[] numbers, int target) {
        // Initialize two pointers
        int i = 0; // Left pointer
        int j = numbers.length - 1; // Right pointer
        // Loop until i and j cross each other
        while (i < j) {
            // Calculate the sum of numbers[i] and numbers[j]
            int sum = numbers[i] + numbers[j];
            // Compare with the target
            if (sum == target) {
                // Return []{i + 1, j + 1};
            } else if (sum < target) {
                // Increment i to move to a larger element
                i++;
            } else {
                // decrement j to move to a smaller element
                j--;
            }
        }
        // Return an empty array if no answer is found
        return new int[]{};
    }

    // Big O:
    // The time complexity of this algorithm is O(n), where n is the length of the array.
    // This is because we scan the array once using two pointers.
    // The space complexity of this algorithm is O(1),
    // because we only use constant extra space for storing the pointers and the sum.

}
