//// 2023/07/10 // 9:44 //

//// 23. Merge K Sorted Lists // Hard //

// You are given an array of k linked-list lists, each linked-list is sorted in ascending order.

// Merge all the linked-lists into one sorted linked-list and return it.

// Example 1:
// Input: lists = [[1,4,5],[1,3,4],[2,6]]
// Output: [1,1,2,3,4,4,5,6]
// Explanation: The linked-lists are:
// [
//     1->4->5,
//     1->3->4,
//     2->6
// ]
// merging them into one sorted list:
// 1->1->2->3->4->4->5->6

// Example 2:
// Input: lists = []
// Output: []

// Example 3:
// Input: lists = [[]]
// Output: []

// Constraints:
// * k == lists.length
// * 0 <= k <= 10^4
// * 0 <= lists[i].length <= 500
// * -10^4 <= lists[i][j] <= 10^4
// * lists[i] is sorted in ascending order.
// * The sum of lists[i].length will not exceed 10^4.

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class MergeKSortedLists {

    private class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    // Explanation:
    // We are given an array of k linked lists, where each linked list is sorted in ascending order.
    // We need to merge all the linked lists into one sorted linked list and return it.
    // We can solve this problem using the concept of merging two linked lists at a time.
    // We can start by merging the first two linked lists, then merge the result
    // with the third linked list and so on until we merge all the linked lists.

    // We can use a min-heap to keep track of the minimum element among the heads of all the linked lists.
    // We can then add the minimum element to the result linked list and move the corresponding head
    // to its next element. We can repeat this process until all the linked lists are empty.

    // Solution:
    // We can solve this problem using the min-heap approach. We can create a min-heap and add the heads
    // of all the linked lists to it. We can then remove the minimum element form the heap,
    // add it to the result linked list, and move the corresponding head to its next element.
    // We can repeat this process until all the linked lists are empty.

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode l1, ListNode l2) {
                return l1.val - l2.val;
            }
        });

        for (ListNode head : lists) {
            if (head != null) {
                minHeap.offer(head);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (!minHeap.isEmpty()) {
            ListNode node = minHeap.poll();
            tail.next = node;
            tail = tail.next;

            if (node.next != null) {
                minHeap.offer(node.next);
            }
        }

        return dummy.next;
    }

    // Big O:
    // Time Complexity: The time complexity of this algorithm is O(N log k),
    // where N is the total number of elements in all the linked lists and k is the number of linked lists.
    // The min-heap operators take O(log k) time, and we perform a total of N such operations.
    // Space Complexity: The space complexity of this algorithm is O(k),
    // which is the space required to store the min-heap.

}
