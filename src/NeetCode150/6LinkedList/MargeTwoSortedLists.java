//// 2023/04/23

//// 21. Merge Two Sorted Lists // Easy //

// You are given the heads of two sorted linked lists list1 and list2.

// Merge the two lists in a one sorted list. The list should be made by splicing together
// the nodes of the first two lists.

// Return the head of the merged linked list.

// Example 1:
// PICTURE
// Input: list1 = [1,2,4], list2 = [1,3,4]
// Output: [1,1,2,3,4,4]

// Example 2:
// Input: list1 = [], list2 = []
// Output: []

// Example 3:
// Input: list1 = [], list2 = [0]
// Output: [0]

// Constraints:
// * The number of nodes in both lists is in the range [0, 50].
// * -100 <= Node.val <= 100
// * Both list1 and list2 are sorted in non-descending order.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) {
 *         this.val = val;
 *         this.next = next;
 *     }
 * }
 */
class MergeTwoSortedLists {

    // This is a common problem that can be solved using the merge algorithm of merge sort.
    // The idea is to compare the values of the nodes of the two lists and pappend the smaller one to the
    // result list.

    // THe time complexity of this algorithm is O(M + N), where M and N are the lengths of the two
    // lists. The space complexity is O(1), since we only use a few pointers and no extra space.


    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Create a dummy node to hold the result
        ListNode dummy = new ListNode(0);
        // Create a pointer to track the current node
        ListNode curr = dummy;
        // Loop until both lists are exhausted
        while (list1 != null && list2 != null) {
            // Compare the values of the nodes and append the smaller one
            if (list1.val < list2.val) {
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }
            // Move the current pointer to the next node
            curr = curr.next;
        }
        // Append the remaining nodes of either list
        if (list1 != null) {
            curr.next = list1;
        }
        if (list2 != null) {
            curr.next = list2;
        }
        // Return the head of the merged list
        return dummy.next;
    }

}
