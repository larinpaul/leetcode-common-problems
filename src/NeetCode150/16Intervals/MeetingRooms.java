//// 2023/05/07 // 13:59 //

//// 920 // Meeting Rooms //
//// https://www.lintcode.com/problem/920/

// Given an array of meeting time intervals consisting
// of start and end times [[s1,e1],[s2,e2],...] (si < ei),
// determine if a person could attend all meetings.

// (i) // (0,8),(8,10) is not conflict at 8

// Example //

// Example1
// Input: intervals = [(0,30),(5,10),(15,20)]
// Output: false
// Explanation:
// (0,30), (5,10) and (0,30),(15,20) will conflict

// Example2
// Input: intervals = [(5,8),(9,15)]
// Output: true
// Explanation:
// Two times will not conflict

// Tags //
// Sort

// Related problems:
// 156 * Merge intervals // Easy //
// 919 * Meeting Rooms II // Medium //

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Definition of Interval:
 * public class Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

public class MeetingRooms {

    class Interval {
        int start, end;
        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    // Explanation:
    // To determine if a person could attend all meetings, we need to check if there is
    // any overlap between any two intervals. A simple way to do this is to sort the intervals by their
    // start times, and then iterate through them, and compare the end time of the current interval with
    // the start time of the next interval. If the end time is greater than the start time, it means there is
    // an overlap and the person cannot attend all meetings. Otherwise, we continue to check the next
    // pair of intervals until we reach the end of the list.

    /**
     * @param intervals: an array of meeting time intervals
     * @return: if a person could attend all meetings
     */
    public boolean canAttendMeetings(List<Interval> intervals) {
        // Edge case: empty list or single interval
        if (intervals == null || intervals.size() <= 1) {
            return true;
        }
        // Sort the intervals by their start times
        Collections.sort(intervals, new Comparator<>() {
           @Override
           public int compare(Interval a, Interval b) {
               return a.start - b.start;
           }
        });
        // Iterate through the intervals and check for overlap
        for (int i = 0; i < intervals.size() - 1; i++) {
            // If the end time of the current interval is greater than the start time of the next interval,
            // there is an overlap
            if (intervals.get(i).end > intervals.get(i + 1).start) {
                return false;
            }
        }
        // No overlap found, return true
        return true;
    }

    // O complexity: The time complexity of this solution is O(nlogn), where n is the number of
    // intervals. This is because we need to sort the intervals first, which takes O(nlogn) time on
    // average. The space complexity is O(1), since we only use constant extra space.



}







