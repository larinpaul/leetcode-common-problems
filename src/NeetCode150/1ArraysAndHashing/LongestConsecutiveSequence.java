//// 2023/05/16 // 10:11 //

//// 128. Longest Consecutive Sequence // Medium (Used to be Hard) //

// Given an unsorted array of integers nums, return the length of the longest
// consecutive elements sequence.

// You must write an algorithm that runs in O(n) time.

// Example 1:
// Input: nums = [100,4,200,1,3,2]
// Output: 4
// Explanation: The longest consecutive elements sequence is [1,2,3,4].
// Therefore its length is 4.

// Example 2:
// Input: nums = [0,3,7,2,5,8,4,6,0,1]
// Output: 9

// Constraints:
// * <= nums.length <= 10^5
// * -10^9 <= nums[i] <= 10^9

import java.util.HashSet;
import java.util.Set;

class LongestConsecutiveSequence {

    // Solution:
    // The idea is to use a hash set to store all the numbers in the array, and then iterate
    // through the array and check for each number if it is the start of a consecutive sequence.
    // If it is, we use another loop to find the end of the sequence and update the longest length.
    // If it is not, we skip it and move on to the next number.

    // The hash set allows us to check if a number exists in the array in O(1) time.
    // By checking if a number minus one exists in the set, we can determine if it is the start
    // of a sequence or not. For example, if we have 4 in the array, and 3 is not in the set,
    // then 4 is the start of a sequence. If 3 is in the set, then 4 is not the start of a sequence.
    // By doing this for every number in the array, we can find all the sequences and their lengths.

    public int longestConsecutive(int[] nums) {
        // Edge case: empty array
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // Create a hash set to store all the numbers
        Set<Integer> set = new HashSet<>();
        for (int num  : nums) {
            set.add(num);
        }

        // Initialize the longest length
        int longest = 0;

        // Iterate through the array
        for (int num : nums) {
            // Check if num is the start of a sequence
            if (!set.contains(num - 1)) {
                // Initialize the current length and the end of the sequence
                int current = 1;
                int end = num + 1;

                // Loop until we reach the end of the sequence of the set is empty
                while (set.contains(end) && !set.isEmpty()) {
                    // Increment the current length and remove the end from the set
                    current++;
                    set.remove(end);
                    // Update the end to the next number
                    end++;
                }

                // Update the longest length if needed
                longest = Math.max(longest, current);
            }
        }

        // Return the longest length
        return longest;
    }

    // Big O:
    // The time complexity of this algorithm is O(n), where n is the length of the array.
    // This is because we iterate through the array once, and for each number we check if it is
    // in the set in O(1) time. The space complexity is also O(n),
    // because we use a hash set to store all the numbers in the array.

    // The big O is O(n) because the inner loop only runs for each number that is the start of a sequence,
    // and each number can be the start of a sequence at most once. Therefore, the
    // total number of iterations of the inner loop is at most n. For example, if the array is [1,2,3,4],
    // the inner loop will run for 1, but not for 2, 3, or 4.
    // If the array if [4, 3, 2, 1], the inner loop will run for 4, but not for 3, 2, or 1.
    // So the overall time complexity is O(n) + O(n) = O(n).

}
