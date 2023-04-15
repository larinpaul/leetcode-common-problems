//// 2023/04/14 // 23:30 //

//// 217. Contains Duplicate
// https://leetcode.com/problems/contains-duplicate/description/

// Given an integer array nums, return true is any value
// appears at least twice in the array, and then return false if every element is distinct

// Example 1:
// Input: nums = [1,2,3,1]
// Output: true

// Example 2:
// Input: nums = [1,2,3,4]
// Output: false

// Example 3:
// Input: nums = [1,1,1,3,3,4,3,2,4,2]
// Output: true

// Constraints:
// 1 <= nums.length <= 10^5
// -10^9 <= nums[i] <= 10^9

import java.util.HashSet;
import java.util.Set;

class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        // Create a new HashSet to store unique values
        Set<Integer> uniques = new HashSet<>();
        // Loop through the input array nums
        for (int i = 0; i < nums.length; i++) {
            // Check if the current element already exists in the HashSet
            if (uniques.contains(nums[i])) {
                // If it does, then we have found a duplicate, so return true
                return true;
            }
            // Otherwise, add the current element to the HashSet
            uniques.add(nums[i]);
            // If we have looped through the entire array and haven't found a duplicate, return false
        }
        return false;
    }
}
