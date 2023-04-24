//// 2023/04/24 // 9:32 //

//// 57. Insert Interval // Medium

// You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi]
// represent the start and the end of the ith interval and intervals is sorted in ascending order
// by starti. You are also given an interval newInterval = [start, end] that represents the start and
// end of another interval.

// Insert new Interval into intervals such that intervals is still sorted in ascending order by
// starti and intervals still does not have any overlapping intervals (merge overlapping intervals
// if necessary).

// Return intervals after the insertion.

// Example 1:
// Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
// Output: [[1,5],[6,9]]

// Example 2:
// Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
// Output: [[1,2],[3,10],[12,16]]
// Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].

// Constraints:
// 0 <= intervals.length <= 10^4
// intervals[i].length == 2
// 0 <= starti <= endi <= 10^5
// intervals is sorted by starti in ascending order.
// newInterval.length == 2
// 0 <= start <= end <= 10^5

import java.util.ArrayList;
import java.util.List;

class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        // create a list to store the merged intervals
        List<int[]> merged = new ArrayList<>();
        // initialize a variable to track the current interval index
        int i = 0;
        // loop through the intervals until we reach the end or find an overlap with newInterval
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            // add the non-overlapping interval to the merged list
            merged.add(intervals[i]);
            // increment the index
            i++;
        }
        // loop through the intervals until we reach the end or find a gap with newInterval
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            // update the newInterval's start and end to cover the overlapping interval
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            // increment the index
            i++;
        }
        // add the newInterval to the merged list
        merged.add(newInterval);
        // loop through the remaining intervals and add them to the merged list
        while (i < intervals.length) {
            merged.add(intervals[i]);
            i++;
        }
        // convert the list to an array and return it
        return merged.toArray(new int[merged.size()][]);
    }
}

// The idea is to use a two-pointer approach to scan through the intervals array and find the
// position of the newInterval. We can divide the intervals into three parts: those that are before
// the newInterval and do not overlap with it, those that overlap with the newInterval and need
// to be merged with it, and those that are after the newInterval and do not overlap with it.

// We can use a list to store the merged intervals and add them one by one. For the first part,
// we simply add the intervals that are before and do not overlap with the newInterval. For the
// second part, we update the newInterval's start and end to cover all the overlapping intervals.
// For the third part, we add the remaining intervals that are after and do not overlap with the
// newInterval.

// The time complexity of this algorithm is O(n), where n is the number of intervals in the input
// array. This is because we scan through each interval at most once and perform constant
// time operations on them. The space complexity is O(n), where n is the number of intervals in
// the output array. This is because we use a List to store the merged intervals and convert it to
// an array at the end.
