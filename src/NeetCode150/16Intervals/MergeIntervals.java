//// 2023/06/13 // 11:10 //

////  56. Merge Intervals // Medium //

// Given an array of intervals where intervals[i] = [starti, endi], merge all
// overlapping intervals, and return an array of the non-overlapping intervals that cover all the
// intervals in the input.

// Example 1:
// Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
// Output: [[1,6],[8,10],[15,18]]
// Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].

// Example 2:
// Input: intervals = [[1,4],[4,5]]
// Output: [[1,5]]
// Explanation: Intervals [1,4] and [4,5] are considered overlapping.

// Constraints:
// * 1 <= intervals.length <= 10^4
// * intervals[i].length == 2
// * 0 <= starti <= endi <= 10^4

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class MergeIntervals {

    // Solution:
    // The idea is to sort the intervals by their start time, and then iterate over them.
    // For each interval, we check if it overlaps with the previous one. If it does, we merge them by
    // updating the end time of the previous interval to the maximum of the two end items. If it
    // does not, we add the current interval to the output list. At the end, we return the output list
    // as the merged intervals.

    // Explanation:
    // Sorting the intervals by their start time ensures that we only need to compare adjacent intervals
    // for overlapping. This simplifies the logic and reduces the number of comparisons.
    // To check if two intervals overlap, we can compare their start and end times.
    // Two intervals [a,b] and [c,d] overlap if and only if a <= d and c <= b.
    // To merge two overlapping intervals, we can take the minimum of their start times
    // and the maximum of their end times as the new interval.

    // Code:
    public int[][] merge(int[][] intervals) {
        // Sort the intervals by their start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        // Initialize an output list
        List<int[]> output = new ArrayList<>();

        // Iterate over the intervals
        for (int[] interval : intervals) {
            // If the output list is empty or the current interval does not overlap with the previous one
            if (output.isEmpty() || output.get(output.size() - 1)[1] < interval[0]) {
                // Add the current interval to the output list
                output.add(interval);
            } else {
                // Otherwise, merge the current interval with the previous one by updating its end time
                output.get(output.size() - 1)[1] = Math.max(output.get(output.size() - 1)[1], interval[1]);
            }
        }

        // Return the output list as an array
        return output.toArray(new int[output.size()][]);
    }

    // Big O:

    // The time complexity of this algorithm is O(n log n), where n is the number of
    // intervals. This is because we need to sort the intervals first, which takes O(n log n) time.
    // The iteration over the intervals takes O(n) time, so the total time complexity is O(n log n).

    // The space complexity of this algorithm is O(n), where n is the number of intervals. This is
    // because we need to store the output list, which can have up to n elements in the worst case.

}