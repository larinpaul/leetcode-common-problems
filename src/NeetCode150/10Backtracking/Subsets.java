//// 2023/04/18 // 9:16 //

//// 78. Subsets // Medium

// Given an integer array nums of unique elements, return all possible subsets (the power set).
// The solution set MUST NOT contain duplicate subsets. Return the solution in any order.

// Example 1:
// Input: nums = [1,2,3]
// Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]

// Example 2:
// Input: nums = [0]
// Output: [[],[0]]

// Constraints:
// 1 <= nums.length <= 10
// -10 <= nums[i] <= 10
// All the numbers of nums are unique

import java.util.ArrayList;
import java.util.List;

class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        // Create a list to store the result
        List<List<Integer>> result = new ArrayList<>();
        // Call a helper method to generate subsets recursively
        generateSubsets(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private void generateSubsets(int[] nums, int index, List<Integer> current, List<List<Integer>> result) {
        // Base case: if index reaches the end of the array, add the current list ot the result and return
        if (index == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }
        // Recursive case: for each element in the array, we have two choices:
        // include it or exclude it
        // First, we exclude the element at index and recurse on the next index
        generateSubsets(nums, index + 1, current, result);
        // Then, we include the element at index and recurse on the next index
        current.add(nums[index]);
        generateSubsets(nums, index + 1, current, result);
        // Finally, we backtrack and remove the element at index from the current list
        current.remove(current.size() - 1);
    }

    // The idea is to use recursion and backtracking to generate all possible subsets.
    // For each element in the array, we have two choices: include it or exclude it in the current subset.
    // We start from an empty subset and explore both choices for each element. When we
    // reach the end of the array, we add the current subset to the result list. We also use
    // backtracing to undo our choice and explore other possibilities

    // The time complexity of this solution is O(2^n * n), where n is the length of the array.
    // This is because there are 2^n possible subsets and each subset takes O(n) time to copy to
    // the result list. The space complexity is O(n),
    // which is the maximum depth of the recursion stack.

}








