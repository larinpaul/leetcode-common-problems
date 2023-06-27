//// 2023/06/27 // 12:08 //

//// 46. Permutations // Medium //

// Given an array nums of distinct integers, return all the possible permutations.
// You can return the answer in any order.

// Example 1:
// Input: nums = [1,2,3]
// Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

// Example 2:
// Input: nums = [0,1]
// Output: [[0,1],[1,0]]

// Example 3:
// Input: nums = [1]
// Output: [[1]]

// Constraints:
// * 1 <= nums.length <= 6
// * -10 <= nums[i] <= 10
// * All the integers of nums are unique.

import java.util.ArrayList;
import java.util.List;

class Permutations {

    // Solution:
    // To generate all the possible permutations of an array of distinct integers, we can use a
    // recursive approach. We start start with an empty list to store the permutations,
    // and a boolean array to mark which elements are used. Then, we iterate through the array
    // and for each element that is not used, we add it to temporary list and mark it as used.
    // Then, we recursively call the same function with the updated list and boolean array.
    // When the temporary list has the same size as the original array, we
    // have function a permutation and we add it to the result. Finally, backtrack by removing
    // the last element from the temporary list and unmarking it as used.

    // Explanation:
    // The idea is to use backtracking to explore all the possible choices for each position
    // in the permutation. For example, if the input array is [1,2,3], we can start with 1
    // and them choose 2 or 3 for the second position. Then, we can choose the remaining element
    // for the third position. This gives us two permutations: [1,2,3] and [1,3,2].
    // Then, we backtrack to the previous choice and try another option.
    // We can start with 2 and then choose 1 or 3 for the second position.
    // This gives us two more permutations: [2,1,3] and [2,3,1].
    // We repeat this process until we have exhausted all the choices for each position.

    // Code:
    public List<List<Integer>> permute(int[] nums) {
        // create an empty list to store the permutations
        List<List<Integer>> result = new ArrayList<>();
        // create a boolean array to mark which elements are used
        boolean[] used = new boolean[nums.length];
        // call the helper function цшер фт уьзен дшые
        helper(nums, result, new ArrayList<>(), used);
        // return the result list
        return result;
    }

    private void helper(int[] nums, List<List<Integer>> result, List<Integer> temp, boolean[] used) {
        // base case: if the temporary list has the same size as the original array
        if (temp.size() == nums.length) {
            // add a copy of the temporary list to the result list
            result.add(new ArrayList<>(temp));
            // return from the recursive call
            return;
        }
        // loop through the array
        for (int i = 0; i < nums.length; i++) {
            // if the element is not used
            if (!used[i]) {
                // add it to the temporary list
                temp.add(nums[i]);
                // mark it as used
                used[i] = true;
                // recursively call the helper function with the updated list and boolean array
                helper(nums, result, temp, used);
                // backtrack by removing the last element from the temporary list
                temp.remove(temp.size() - 1);
                /// unmark it as used
                used[i] = false;
            }
        }
    }

    // Big O:

    // The time complexity of this solution is O(n! * n), where n is the length of the input array.
    // This is because there are n! possible permutations, and for each permutation we need
    // to copy n elements to a new list.
    // The space complexity is O(n * n), where n is the length
    // of the input array. This is because we need to store n! permutation, each of which has n elements.
    // We also need O(n) extra space for the recursive call stack and the boolean array.

}
