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

class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {

        Set<Integer> uniques = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (uniques.contains(nums[i])) {
                return true;
            }
            uniques.add(nums[i]);
        }
        return false;
    }
}
