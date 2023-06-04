//// 2023/06/04 // 15:45 //

//// 39. Combination Sum // Medium //

// Given an array of distinct integers candidates and a target integer target,
// return a list of all unique combinations of candidates where the chosen numbers
// sum to target. You may return the combinations in any order.

// The same number may be chosen from candidates an unlimited number of times.
// Two combinations are unique if the frequency of at least one of the chosen
// numbers is different.

// The test cases are generated such that the number of unique combinations that
// sum up to target is less than 150 combinations for the given input.

// Example 1:
// Input: candidates = [2,3,6,7], target = 7
// Output: [[2,2,3],[7]]
// Explanation:
// 2 and 3 are candidates, and 2 + 2 + 3 = 7.
// Note that 2 can be used multiple times.
// 7 is a candidate, and 7 = 7.
// These are only two combinations.

// Example 2:
// Input: candidates = [2,3,5], target = 8
// Output: [[2,2,2,2],[2,3,3],[3,5]]

// Example 3:
// Input: candidates = [2], target = 1
// Output: []

// Constraints;
// * 1 <= candidates.length <= 30
// * 2 <= candidates[i] <= 40
// * All elements of candidates are distinct
// * 1 <= target <= 40

import javax.naming.PartialResultException;
import javax.swing.undo.CannotUndoException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class CombinationSum {

    // We can use backtracking with pruning.
    // This approach improves efficiency by avoiding unnecessary recursive calls and pruning branches
    // that cannot lead to a valid combination sum.

    // Explanation:
    // To solve the "Combination Sum" problem optimally, we can use a backtracking
    // algorithm with pruning. The algorithm starts with an empty combination and
    // iteratively tries adding each candidate number to the combination. It backtracks
    // when the target sum is reached or exceeded, or if all candidates have been
    // considered. The pruning step involves stopping the exploration of a branch if the
    // sum of the current combination exceed the target. This avoids unnecessary
    // recursive calls and reduces the search space.

    // Code:
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> current, int[] candidates, int target, int start) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > target) {
                break; // Stop exploring further if the current candidate exceed the remaining target
            }
            current.add(candidates[i]);
            backtrack(result, current, candidates, target - candidates[i], i);
            current.remove(current.size() - 1);
        }
    }

    // The code above implement the backtracking algorithm with pruning. It sorts the
    // candidates array in ascending order to efficiently handle duplicates during
    // backtracking. The `backtrack` function is called recursively to explore all possible
    // combinations. It checks if the current combination sum is equal to the target and
    // adds the combination to the result list of so. If the current combination sum exceeds
    // the target, it stops exploring that branch. Otherwise, it iterates through the
    // remaining candidates, adds the current candidate to the combination, recursively
    // calls `backtrack` with the update target and the same index to allow reuse of
    // candidates, and then removes the last added candidate before proceeding to the
    // next candidate.

    // Complexity Analysis:
    // The time complexity of this solution is O(n^m), where n is the length of the
    // candidates array and m is the target value. In the worst case, the backtracking
    // algorithm explores all possible combinations, and for each candidate, there can be
    // up to M recursive calls. The space complexity is O(m) to store the current
    // combination during recursion

    // When return; is used without a value, it is typically used in methods
    // with a `void return type`
    // Overall, `return;` without a value is used to terminate the execution of a method
    // and indicate that it does not produce a specific return value.

}
