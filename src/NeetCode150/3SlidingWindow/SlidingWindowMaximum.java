//// 2023/07/01 // 20:20 //

//// 239. Sliding Window Maximum // Hard //

// You are given an array of integers nums, there is a sliding window of size k which is moving
// from the very left of the array to the very right. You can only see the k numbers in the
// window. Each time the sliding window moves right by one position.

// Return the max sliding window.

// Example 1:
// Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
// Output: [3,3,5,5,6,7]
// Explanation:
//        Window position                Max
//        ---------------               -----
//        [1  3  -1] -3  5  3  6  7       3
//        1 [3  -1  -3] 5  3  6  7       3
//        1  3 [-1  -3  5] 3  6  7       5
//        1  3  -1 [-3  5  3] 6  7       5
//        1  3  -1  -3 [5  3  6] 7       6
//        1  3  -1  -3  5 [3  6  7]      7

// Example 2:
// Input: nums = [1], k = 1
// Output: [1]

// Constraints:
// * 1 <= nums.length <= 10^5
// * -10^4 <= nums[i] <= 10^4
// * l <= k <= nums.length

import java.util.Deque;
import java.util.LinkedList;

class SlidingWindowMaximum {

    // Solution:
    // We can use a dequeue (double-ended queue) to store the indices of the elements in the sliding
    // window, such that the deque always contains the index of the maximum element at the front, and the
    // indices of the smaller elements in decreasing order at the back. We can maintain this invariant by
    // popping out the indices that are out of the window range, and passing out the indices that are smaller
    // than the current element from the back of the deque. Then we can append the current index to the
    // back of the deque, and add the front element of the deque to the result array.

    // Explanation:
    // The dequeue allows us to access both ends of the queue in constant time, which is useful
    // for sliding window problems. By storing the indices instead of the values, we can easily check if an
    // element is still in the window range or not. By keeping the dequeue in decreasing order of values,
    // we can ensure that the front element is always the maximum in the window,
    // and we can remove any smaller elements that are no longer useful for future windows.

    public int[] maxSlidingWindow(int[] nums, int k) {
        // edge case: empty array or window size 1
        if (nums == null || nums.length == 0) return new int[0];
        if (k == 1) return nums;

        // initialize a deque to store indices
        Deque<Integer> deque = new LinkedList<>();
        // initialize a result array to store max values
        int[] result = new int[nums.length - k + 1];
        // loop through the array
        for (int i = 0; i < nums.length; i++) {
            // pop out any indices that are out of window range from front
            while (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            // pop out any indices that are smaller than current element from back
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            // append current index to back
            deque.offerLast(i);
            // if winodw is full, add front element to result
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }
        // return result array
        return result;
    }

    // Big O:

    // The time complexity is O(n), where n is the length of the array, since we iterate through each
    // element once and each index is added and removed from the deque at most once.

    // The space complexity is O(k), where k is the size of the window,
    // since we store at most k indices in the deque.

}
