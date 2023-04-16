//// 2023/04/16 // 17:27 //

//// 703. Kth Largest Element in a Stream // Easy

// Design a class to find the kth largest element in a stream.
// Note that it is the kth largest element in the sorted order,
// not the kth distinct element.

// Implement KthLargest class:
// * KthLargest(int k, int[] nums) Initializes the object with the integer k
// and the stream of integers nums.
// * int add(int val) Appends the integer val to the stream and returns the element
// representing the kth largest element in the stream.

// Example 1:
// Input
// ["KthLargest", "add", "add", 'add", "add", "add"]
// [[3], [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
// Output:
// [null, 4, 5, 5, 8, 8]

// Explanation:
// KthLargest kthLargest = new KthLargest(3, [4, 5, 8, 2]);
// kthLargest.add(3); // return 4
// kthLargest.add(5); // return 5
// kthLargest.add(10); // return 5
// kthLargest.add(9); // return 8
// kthLargest.add(4); // return 8

// Constraints:
// 1 <= k <= 10^4
// 0 <= nums.length <= 10^4
// -10^4 <= nums[i] <= 10^4
// -10^4 <= val <= 10^4
// At most 10^4 calls will be made to add.
// It is guaranteed that there will be at least k elements in the array
// when you search for the kth element.

// To find the kth largest element in a stream, we can use a min-heap data structure
// that maintains the k largest elements seen so fat. A min-heap is a binary tree where each
// node is smaller than or equal to its children.
// The root of the min-heap is the smallest element in the heap

// We can initialize the min-heap with the first k elements of the stream, or fill it
// with -infinity if the stream has less than k elements. Then, for each new element
// in the stream, we compare it with the root of the min-heap. If the new element
// is larger than the root, we remove the root and insert the new element into the min-heap.
// Otherwise, we ignore the new element. This way, the min-heap always contains
// the k largest elements seen so far, and the root is the kth largest element.

// To implement the min-heap, we can use a priority queue in Java that supports insertion
// and removal in O(log k) time, where k is the size of the heap.
// Here is one possible solution in Java:

import java.util.PriorityQueue;

class KthLargest {

    // Declare a priority queue to store the min-heap
    private PriorityQueue<Integer> pq;
    // Declare an integer to store the value of k
    private int k;

    public KthLargest(int k, int[] nums) {
        // Initialize the priority queue with a custom comparator
        // that orders elements in ascending order
        pq = new PriorityQueue<>((a, b) -> a - b);
        // Initialize k
        this.k = k;
        // loop through the nums array
        for (int num : nums) {
            // Call the add a method on each element
            add(num);
        }
    }

    public int add(int val) {
        // If the heap size is less than k, add val to the heap
        if (pq.size() < k) {
            pq.offer(val);
        } else {
            // Otherwise, compare val with the root of the heap
            int min = pq.peek();
            // If val is larger than the root, remove the root and add val to the heap
            if (val > min) {
                pq.poll();
                pq.offer(val);
            }
        }
        // Return the root of the heap, which is the kth largest element
        return pq.peek();
    }


}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */



