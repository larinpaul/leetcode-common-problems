//// 2023/05/18 // 17:47 //

//// 15. 3Sum // Medium //

// Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
// such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

// Notice that the solution set must not contain duplicate triples

// Example 1:
// Input: nums = [-1,0,1,2,-1,-4]
// Output: [[-1,-1,2],[-1,0,1]]
// Explanation:
// nums[0] + nums[1] + nums[2] = (-1) + 0 = 1 = 0.
// nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
// nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
// The distinct triplets are [-1,0,1] and [-1,-1,2].
// Notice that the order of the output and the order of the triplets does not matter.

// Example 2:
// Input: nums = [0,1,1]
// Output: []
// Explanation: The only possible triplet does not sum up to 0.

// Example 3:
// Input: nums = [0,0,0]
// Output: [[0,0,0]]
// Explanation: The only possible triplet sums up to 0.

// Constraints:
// * 3 <= nums.length <= 3000
// * -10^5 <= nums[i] <= 10^5

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ThreeSum {

    // Explanation:
    // One way to solve this problem is to sort the array first, and then use two pointers
    // to scan the array for each element. For each element nums[i], we can use two
    // pointers left and right to point to the elements after nums[i],
    // and check if nums[i] + nums[left] + nums[right] == 0.
    // If yes, we add the triplet to the result list adn move both pointers.
    // If not, we move the left pointer if the sum is too small,
    // or move the right pointer if the sum is too large.
    // To avoid duplicate triplets, we can skip the elements that are equal to the previous ones.

    public List<List<Integer>> threeSum(int[] nums) {
        // Sort the array
        Arrays.sort(nums);
        // Initialize the result list
        List<List<Integer>> result = new ArrayList<>();
        // Loop through the array
        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicate elements
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            // Use two pointers to scan the rest of the array
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                // Calculate the sum of three elements
                int sum = nums[i] + nums[left] + nums[right];
                // Check if the sum is zero
                if (sum == 0) {
                    // Add the triplet to the result list
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // Move both pointers and skip duplicate elements
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1]) left++;
                    while (left < right && nums[right] == nums[right + 1]) right--;
                } else if (sum < 0) {
                    // Move the left pointer if the sum is too small
                    left++;
                } else {
                    // Move the right pointer if the sum is too large
                    right--;
                }
            }
        }
        // Return the result list
        return result;
    }

    // Big O: The time complexity of this solution is O(n^2), where n is the length of the array,
    // because we loop through the array once and use two pointers to scan the rest of the array
    // for each element. The space complexity is O(n), where n is the length of the array, because
    // we need to sort the array and store the result list.

}
