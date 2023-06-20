//// 2023/06/20 // 12:33 //

//// 287. Find the Duplicate Number // Medium //

// Given an array of integers nums containing n + 1 integers where each integer is in the
// range [1, n] inclusive.

// There is only one repeated number in nums, return this repeated number.

// You must solve the problem without modifying the array nums and uses only constant extra space.

// Example 1:
// Input: nums = [1,3,4,2,2]
// Output: 2

// Example 2:
// Input: nums = [3,1,3,4,2]
// Output: 3

// Constraints:
// * 1 <= n <= 10^5
// * nums.length == n + 1
// * 1 <= nums[i] <= n
// * All the integers in nums appear only once except for precisely one integer which
// appears two or more times.

// Follow up:
// * How can we prove that at least one duplicate number must exist in nums?
// * Can you solve the problem in linear runtime complexity?

class FindTheDuplicateNumber {

    // Solution:
    // The idea is to use the fact that the array contains numbers in the range [1, n] and
    // treat the array as a linked list, where each element points to the next element at the index
    // equal to its value. For example, nums = [3,1,3,4,2] can be seen as 3 -> 4 -> 2 -> 3 -> -> ...
    // This means there must be a cycle in the linked list, and the duplicate number is the entry
    // point of the cycle. To find the entry point, we can use the Floyd's algorithm (also known as
    // the tortoise and hare algorithm), which uses two pointers with different speeds to detect
    // and locate a cycle in the linked list.

    // Explanation:
    // First, we initialize two pointers, slow and fast, to point to the first element of
    // the array. Then we move them one step at a time, where slow moves to nums[slow] and fast
    // moves to nums[nums[fast]]. We repeat this until slow adn fast meet at some point in the
    // cycle. This point is not necessarily the entry point of the cycle, but it is some distance k
    // away from it, where k is a multiple of the length of the cycle. To find the entry point, we reset
    // one of the pointers (say slow) to point to the first element again, and keep the other pointer
    // (fast) at the meeting point. Then we move both pointers one step at a time until they meet
    // again. This time, they will meet at the entry point of the cycle, which is algo the duplicate
    // number.

    public int findDuplicate(int[] nums) {
        // initialize two pointers
        int slow = nums[0];
        int fast = nums[0];
        // move them until they meet
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        // reset one pointer
        slow = nums[0];
        // move them until they meet again
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        // return the duplicate number
        return slow;
    }

    // Big O:
    // The time complexity of this algorithm is O(n), where n is the length of the array.
    // This is because both pointers will traverse at most n elements before they meet.
    // The space complexity is O(1), since we only use two pointers and no extra space.

}
