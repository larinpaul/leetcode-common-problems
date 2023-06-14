//// 2023/06/14 // 8:27 //

//// 435. Non-overlapping Intervals

// Given an array of intervals intervals where intervals[i] = [starti, endi], return the
// minimum number of intervals you need to remove to make the rest of the intervals
// non-overlapping

// Example 1:
// Input: intervals = [[1,2],[2,3],[3,4],[1,3]]
// Output: 1
// Explanation: [1,3] can be removed and the rest of the intervals
// are non-overlapping.

// Example 2:
// Input: intervals = [[1,2],[1,2],[1,2]]
// Output: 2
// Explanation: You need to remove two [1,2] to make the rest of
// the intervals non-overlapping.

// Example 3:
// Input: intervals = [[1,2],[2,3]]
// Output: 0
// Explanation: You don't need to remove any of the intervals since
// they're already non-overlapping.

// Constraints:
// * 1 <= intervals.length <= 10^5
// * intervals[i].length == 2
// * -5 * 10^4 <= starti <= endi <= 5 * 10^4

import java.util.Arrays;

class NonOverlappingIntervals {

    // This is a problem of finding the maximum number of non-overlapping intervals,
    // which is equivalent to finding the maximum number of compatible activities
    // in the activity selection problem. We can use a greedy algorithm to solve
    // this problem is O(n log n), where n is
    // the number of intervals.

    // The idea is to sort the intervals by their ending times in ascending order, and
    // then iterate through them, keeping track of the last selected interval.
    // If the current interval overlaps with the last selected interval,
    // we increment the count of intervals to remove.
    // Otherwise, we update the last selected interval to the current one.

    // The code for this algorithm is:

    public int eraseOverlapIntervals(int[][] intervals) {
        // edge case: empty or single interval
        if (intervals == null || intervals.length <= 1) return 0;

        // sort the intervals by their ending times
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);

        // initialize the count of intervals to remove and the last selected interval
        int count = 0;
        int[] last = intervals[0];

        // iterate through the rest of the intervals
        for (int i = 1; i < intervals.length; i++) {
            // if the current interval overlaps with the last selected interval
            if (intervals[i][0] < last[1]) {
                // increment the count of intervals to remove
                count++;
            } else {
                // update the count of intervals to remove
                last = intervals[i];
            }
        }

        // return the count of intervals to remove
        return count;
    }

    // The time complexity of this algorithm is O(n log n), where n is the number of intervals.
    // This is because we need to sort the intervals first, which takes O(n log n) time.
    // The iteration through the intervals takes O(n) time.

    // The space complexity of this algorithm is O(1), since we only use constant extra space.

}































