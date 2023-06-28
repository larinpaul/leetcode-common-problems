//// 2023/06/28 // 15:30 //

//// Subsets II // Medium //

// Given an integer array nums that may contain duplicates, return all possible subsets (the power set).

// The solution must not contain duplicate subsets. Return the solution in any order.

// Example 1:
// Input: nums = [1,2,2]
// Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]

// Example 2:
// Input: nums = [0]
// Output: [[],[0]]

// Constraints:
// * 1 <= nums.length <= 10
// * -10 <= nums[i] <= 10

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class SubsetsII {

    // Solution:
    // The idea is to use backtracking to generate all possible subsets of the given array.
    // We sort the array first to avoid duplicates. Then we use a helper function that takes the current index,
    // the current subset and the result list as parameters. We add the current subset to the result list at
    // each recursive call. Then we iterate from the current index to the end of the array, adn for each element,
    // we add it to the current subset and call the helper function with the next index. We also skip
    // the elements that are equal to the previous one to avoid duplicates. After the loop, we remove
    // the last element form the current subset to backtrack.

    // Explanation:
    // Here are the main steps of the algorithm:
    // 1. Sort the input array so that duplicate elements are adjacent.
    // 2. Initialize an empty list to store the current susbset, and another list to store the final result.
    // 3. Define a helper function that takes the current index, the input array,
    // the current subset, adn the final result as parameters.
    // 4. In the helper function, check if the current index is out of bounds.
    // If so, return from the function
    // 5. Add the current subset to the final result.
    // 6. Loop from the current index to the end of the array, and for each element:
    // * If the element is equal to the previous element (except for the first element),
    // skip it to avoid duplicates.
    // * Add the element to the current subset.
    // * Recursively call the helper function with the next index, passing the same array, subset, and result.
    // * Remove the last element form the current subset to backtrack.
    // 7. Call the helper function with index 0, passing the sorted array, the empty subset, and the empty result.

    // Code:
    public List<List<Integer>> subsetsWithDup(int[] nums) {

        // Sort the array
        Arrays.sort(nums);
        // Initialize an empty list for the current subset
        List<Integer> subset = new ArrayList<>();
        // Initialize an empty list for the final result
        List<List<Integer>> result = new ArrayList<>();
        // Call the helper function with index 0
        helper(0, nums, subset, result);
        // Return the result
        return result;

    }

    private void helper(int index, int[] nums, List<Integer> subset, List<List<Integer>> result) {

        // Check if index is out of bounds
        if (index > nums.length) {
            // Return from the function
            return;
        }

        // Add the current subset to the result
        result.add(new ArrayList<>(subset));
        // Loop from index to the end of the array
        for (int i = index; i < nums.length; i++) {
            // If the element is equal to the previous element (except for the first element), skip it
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            // Add the element to the current subset
            subset.add(nums[i]);
            // Recursively call the helper function with the next index
            helper(i + 1, nums, subset, result);
            // Remove the last element form the current subset to backtrack
            subset.remove(subset.size() - 1);
        }
    }

    // Big O:

    // The time complexity of the solution is O(n * 2^n), where n is the length of the input array.
    // This is because there are 2^n possible subsets to generate, and each one takes O(n) time to copy
    // into the result list.

    // The space complexity is also O(n * 2^n),
    // since we need to store all the subsets in the result list.

}
