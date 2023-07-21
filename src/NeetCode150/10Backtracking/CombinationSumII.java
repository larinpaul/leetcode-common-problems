//// 2023/07/21 // 19:01 //

//// 40. Combination Sum II // Medium //

// Given a collection of candidate numbers (candidates) and a target number (target),
// find all unique combinations in candidates where the candidate numbers sum to
// target.

// Each number in candidates may only be used once in the combination.

// Note: The solution set must not contain duplicate combinations.

// Example 1:
// Input: candidates = [10,1,2,7,6,1,5], target = 8
// Output:
//[
//[1,1,6],
//[1,2,5],
//[1,7],
//[2,6]
//]

// Example 2:
// Input: candidates = [2,5,2,1,2], target = 5
// Output:
//[
//[1,2,2],
//[5]
//]

// Constraints:
// * 1 <= candidates.length <= 100
// * 1 <= candidates[i] <= 50
// * 1 <= target <= 30

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class CombinationSumII {

    // Explanation
    // This problem can be solved using a technique called backtracking.
    // The idea is that we iterate over the array of candidates and try to
    // subtract each candidate from the target. If the target becomes
    // zero, we add the current combination to our answer. If the target
    // becomes less than zero, we stop and backtrack.

    // Here are the steps for the solution:
    // 1. Sort the candidates array. Sorting is important because the
    // problem requires that the solution set should not contain
    // duplicate combinations. Sorting will bring all the duplicates
    // together, which makes it easier to skip over them.
    // 2. Call the recursive helper function with the target and an empty
    // combination to start with.
    // 3. In the recursive helper function:
    // * If the target is zero, we have found a valid combination. Add it to the result list.
    // * If the target is less than zero, return because we cannot find any valid combinations.
    // * For each candidate, subtract it from the target and call the helper function with the new target.
    // * To avoid duplicates, if a candidate is the same as the previous one, skip it.

    // Code:
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        findCombinations(candidates, 0, target, new ArrayList<Integer>(), result);
        return result;
    }

    private void findCombinations(
            int[] candidates, int index, int target, List<Integer> current, List<List<Integer>> result
    ) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        if (target < 0) {
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (i == index || candidates[i] != candidates[i - 1]) {
                current.add(candidates[i]);
                findCombinations(candidates, i + 1, target - candidates[i], current, result);
                current.remove(current.size() - 1);
            }
        }
    }

    // Big O
    // Time and Space Complexity

    // The time complexity of this algorithm is O(2^n), where n is the length of the 'candidates' array.
    // This is because in the worst case scenario, we may explore each subset of the array.

    // The space complexity is O(n), where n is the length of the 'candidates' array.
    // This is due to the space needed for the recursion call stack in the worst case scenario.

}
