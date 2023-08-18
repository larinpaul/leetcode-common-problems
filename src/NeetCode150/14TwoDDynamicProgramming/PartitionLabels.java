//// 2023/08/17 // 22:46 //

//// 763. Partition Labels // Medium //

// You are given a string s. We want to partition the string into as
// many parts as possible so that each letter appears in at most one part.

// Note that the partition is done so that after concatenating all the
// parents in order, the resultant string should be s.

// Return a list of integers representing the size of these parts.

// Example 1:
// Input: s = "ababcbacadefegdehijhklij"
// Output: [9,7,8]
// Explanation:
// The partition is "ababcbaca", "defegde", "hijhklij".
// This is a partition so that each letter appears in at most one part.
// A partition like "ababcbacadefegde", "hijhklij" is incorrect, because
// it splits s into less parts.

// Example 2:
// Input: s = "eccbbbbdec"
// Output: [10]

// Constraints:
// * 1 <= s.length <= 500
// * s consists of lowercase English letters.


import java.util.ArrayList;
import java.util.List;

class PartitionLabels {

    // Problem Explanation:

    // Given a string s, we need to partition it into as many parts as possible
    // such that each letter appears in at most one part. The goal is to return a
    // list of integers representing the size of these parts.

    // For example, if the input string is "ababcbacadefegdehijhklij", the output
    // would be [9, 7, 8]. The string can be partitioned into "ababcabaca",
    // "defegde", and "hijhklij", satisfying the condition that each letter appears
    // in at most one part.

    // Optimal Solution:
    // To solve this problem, we can use a two-pass approach.

    // In the first pass, we can iterate through the string s and keep track of the
    // last occurrence index of each character in a map or an array. This way, we
    // know the rightmost position where each character appears.

    // In the second pass, we can iterate through the string again. For each
    // character, we keep track of the maximum rightmost index encountered so
    // far. When the current index is equal to the maximum rightmost index, it
    // indicates that we have reached the end of a partition. We can calculate
    // the size of the partition by subtracting the starting index of the partition
    // from the current index and adding 1. Then, we update the starting index
    // to the next index.

    // Finally, we return the list of partition sizes.

    // Pseudocode:
    // 1. Initialize an array lastIndex to store the last occurrence index of
    // each character in s.
    // 2. Iterate through s and update lastIndex with the rightmost position
    // of each character.
    // 3. Initialize variables start and end to keep track of the current
    // partition's starting and ending indices.
    // 4. Initialize an empty list partitions to store the partition sizes.
    // 5. Iterate through s again:
    // * Update end to the maximum of end and lastIndex[s.charAt(i)].
    // * If i is equal to end, it means we have reached the end of a partition:
    // ** Calculate the partition size by subtracting start from end and adding 1.
    // ** Add the partition size to partitions.
    // ** Update start to i + 1.
    // 6. Return partitions.

    // Java Code:
    public List<Integer> partitionLabels(String s) {
        int[] lastIndex = new int[26];
        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }

        int start = 0;
        int end = 0;
        List<Integer> partitions = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            end = Math.max(end, lastIndex[s.charAt(i) - 'a']);

            if (i == end) {
                partitions.add(end - start + 1);
                start = i + 1;
            }
        }

        return partitions;
    }

    // Time Complexity Analysis:
    // The solution performs two passes through the string s. In each pass, we
    // iterate through the entire string once. Therefore, the time complexity of
    // the solution is O(n), where n is the length of the string s.

    // Space Complexity Analysis:
    // The solution uses additional space to store the lastIndex array and the
    // partitions list, both of which can have a maximum length of 26 (for
    // lowercase English letters) or a constant size. Therefore, the space
    // complexity of the solution is O(1).

}
