//// 2023/07/20 // 15:58 //

//// 295. Find Median from Data Stream // Hard //

// The median is the middle value in an ordered integer list. If the size of the list is even,
// there is no middle value, and the median is the mean of the two middle values.
// * For example, for arr = [2,3,4], the median is 3.
// * For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5.

// Implement the MedianFinder class:
// * MedianFinder() initializes the MedianFinder object.
// * void addNum(int num) adds the integer num from the data stream to the data structure.
// * double findMedian() returns the median of all elements so far. Answers within 10^-5
// of the actual answer will be accepted.

// Example 1:
// Input
// ["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"]
// [[], [1], [2], [], [3], []]
// Output
// [null, null, null, 1.5, null, 2.0]

// Explanation
// MedianFinder medianFinder = new MedianFinder();
// medianFinder.addNum(1); // arr = [1]
// medianFinder.addNum(2); // arr = [1, 2]
// medianFinder.findMedian(); // return 1.5 (i.e., (1 + 2) / 2)
// medianFinder.addNum(3); // arr[1, 2, 3]
// medianFinder.findMedian(); // return 2.0

// Constraints:
// * -10^5 <= num <= 10^5
// * There will be at least one element in the data structure before calling findMedian.
// * At most 5 * 10^4 calls will be made to addNum and findMedian.

// Follow up:
// * If all integer numbers from the stream are in the range [0, 100],
// how would you optimize your solution?

import java.util.Comparator;
import java.util.PriorityQueue;

class FindMedianFromDataStream {

    // Explanation
    // The problem requires us to design a data structure that supports
    // two operations: adding an integer to the data structure and finding
    // the median of all numbers added so far. The challenge lies in the
    // fact that the median depends on the ordering of the numbers, but
    // new numbers can be added at any time.

    // A simple approach would involve maintaining a sorted list of all
    // numbers added so far. Adding a number would then involve
    // inserting it into the correct position to maintain the sorted order,
    // which can be done in O(n) time by finding the correct position and
    // shifting all larger numbers to the right. Finding the median would
    // then be a constant-time operation, as it would just involve looking
    // at the middle element(s) of the list.

    // However, this approach can be improved by observing that we
    // don't actually need to maintain the full sorted order. We only need
    // to know the middle elements, and it doesn't matter what the order
    // of the numbers less than the median or greater than the median is.
    // This leads to a more efficient approach: we can maintain two
    // heaps, one max-heap for the numbers less than the median and
    // one min-heap for the numbers greater than the median. The heaps
    // allow us to efficiently add a number (in logarithmic time), and they
    // always give us access to the largest number in the max-heap and
    // the smallest number in the min-heap, allowing us to efficiently
    // compute the median.

    // Solution
    // Out solution will use two heaps:
    // 1. A max-heap lo to store the smaller half of the numbers.
    // 2. A min-heap hi to store the larger half of the numbers.

    // The max-heap lo is allowed to store one more element more than
    // the min-heap hi when the total number of integers is odd. The
    // heaps are balanced in such a way that the median is always at the
    // root of the max-heap lo (when the total number of integers is
    // odd) or can be calculated as the average of the roots of lo and hi
    // (when the total number of integers is even).

    // Code:

    PriorityQueue<Integer> lo;
    PriorityQueue<Integer> hi;

    public MedianFinder() {
        lo = new PriorityQueue<>(Comparator.reverseOrder());
        hi = new PriorityQueue<>();
    }

    public void addNum(int num) {
        lo.offer(num);
        hi.offer(lo.poll());
        if (lo.size() < hi.size()) {
            lo.offer(hi.poll());
        }
    }

    public double findMedian() {
        return lo.size() > hi.size() ? (double) lo.peek() : (lo.peek() + hi.peek()) * 0.5;
    }

    // Complexity Analysis
    // The addNum operation involves adding an element to lo, which
    // takes O(log n) time, and possible moving the maximum of lo to hi,
    // which also takes O(log n) time. Therefore, the time complexity
    // of addNum is O(log n), where n is the number of elements added so far.

    // The findMedian operation involves getting the maximum of lo
    // and possible the minimum of hi, which are both O(1) operations,
    // so the time complexity of findMedian is O(1).

    // The space complexity of the solution is O(n), since we store all
    // elements in the two heaps.

    // Follow-up Questions
    // 1. If all integer numbers form the stream are in the range [0, 100],
    // we can use a counting sort approach. We can maintain
    // an array of size 101 to keep track of the count of each
    // number. This would allow us to add a number in O(1) time and
    // find the median in O(1) time.
    // 2. If 99% of all integer numbers from the stream are in the range [0, 100],
    // we can still use the counting sort approach for
    // numbers in this range, and use the heap-based approach for
    // other numbers. This would optimize the common case of
    // adding a number in the range [0, 100] while still correctly
    // handling all possible inputs.

}
