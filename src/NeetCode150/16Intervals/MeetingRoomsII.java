//// 2023/08/28 // 10:06 //

//// 919. Meeting Rooms II // Medium //

// Description

// Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
// find the minimum number of conference rooms required.)

// (i) (0,8),(8,10) is not conflict at 8

// Example

// Example =1

// Input: intervals = [(0,30),(5,10),(15,20)]
// Output: 2
// Explanation:
// We need two meeting rooms
// room1: (0,30)
// room2: (5,10),(15,20)

// Example2
// Input: intervals = [(2,7)]
// Output: 1
// Explanation:
// Only need one meeting room

import java.lang.reflect.Array;
import java.util.*;


class MeetingRoomsII {

    // To find the minimum number of conference rooms required for a given
    // set of meeting time intervals, we can use the "sweep line" algorithm.
    // This algorithm involves sorting the start and end times of the intervals and
    // processing them in a specific order.

    // An explanation of the approach:
    // 1. Create two arrays: startTimes and endTimes. Iterate through the
    // intervals list and store the start times in startTimes and the end
    // times in endTimes.
    // 2. Sort both startTimes and endTimes in ascending order.
    // 3. Initialize two pointers: startPtr and endPtr at the beginning of
    // startTimes and endTimes, respectively.
    // 4. Initialize a variable rooms to keep track of the number of conference
    // rooms.
    // 5. Iterate until both startPtr and endPtr reach the end of their
    // respective arrays:
    // 8 If the current start time (startTimes[startPtr]) is less than the
    // current end time (endTimes[endPtr]), it means a new meeting is
    // starting before a previous meeting ends. Increment the rooms
    // count and move the startPtr forward.
    // * Otherwise, if the current start time is greater than or equal to the
    // current end time, it means a meeting has ended. Decrement the
    // rooms count and move the endPtr forward.
    // * Keep track of the maximum number of rooms needed during this process.
    // 6. Return the maximum number of rooms needed

    private class Interval {
        int start, end;
        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    /**
     * @param intervals: an array of meeting time intervals
     * @return the minimum number of conference rooms required
     */
    public int minMeetingRooms(List<Interval> intervals) {
        int[] startTimes = new int[intervals.size()];
        int[] endTimes = new int[intervals.size()];

        for (int i = 0; i < intervals.size(); i++) {
            startTimes[i] = intervals.get(i).start;
            endTimes[i] = intervals.get(i).end;
        }

        Arrays.sort(startTimes);
        Arrays.sort(endTimes);

        int startPtr = 0;
        int endPtr = 0;
        int rooms = 0;
        int maxRooms = 0;

        while (startPtr < intervals.size()) {
            if (startTimes[startPtr] < endTimes[endPtr]) {
                rooms++;
                maxRooms = Math.max(maxRooms, rooms);
                startPtr++;
            } else {
                rooms--;
                endPtr++;
            }
        }

        return maxRooms;
    }

    // The time complexity of this solution is O(nlogn), where n is the number of
    // intervals. The sorting step takes O(nlogn) time, and the subsequent
    // iteration through the sorted arrays takes O(n) time. Therefore, the overall
    // time complexity is dominated by the sorting step.

}
