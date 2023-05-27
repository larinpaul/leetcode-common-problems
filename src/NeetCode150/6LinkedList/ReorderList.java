//// 2023/05/27 // 21:15 //

//// 143. Reorder List // Medium //

// You are given the head of a singly linked-list.

// The list can be represented as:
// L0 -> L1 -> ... Ln-1 -> Ln

// Reorder the list to be on the following form:
// L0 -> Ln -> L1 -> Ln-1 -> L2 -> Ln-2 -> ...

// You may not modify the values in the list's nodes.
// Only nodes themselves may be changed.

// Example 1:
// 1 -> 2 -> 3 -> 4
//       vvv
// 1 -> 4 -> 2 -> 3
// Input: head = [1,2,3,4]
// Output: [1,4,2,3]

// Example 2:
// 1 -> 2 -> 3 -> 4 -> 5
//          vvv
// 1 -> 5 -> 2 -> 4 -> 3
// Input: head = [1,2,3,4,5]
// Output: [1,5,2,4,3]

// Constraints:
// * The number of nodes in the list is in the range [1, 5 * 10^4].
// * 1 <= Node.val <= 1000

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

class ReorderList {

    private class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    // Explanation: To reorder the list, we need to do three steps:
    // 1. Find the middle node of the list using a slow and fast pointer technique.
    // 2. Reverse the second half of the list starting from the middle node.
    // 3. Merge the two halves of the list by alternating nodes form each half.

    // Solution;
    // * Initialize two pointers, slow and fast, both pointing to the head of the list.
    // * Move slow one step at a time and fast two steps at a time
    // until fast reaches the end or the last node of the list.
    // This way, slow will point to the middle node of the list.
    // * Cut the list into two halves by setting slow.next to null.
    // * Reverse the second half of the list using a prev, curr and next pointer technique.
    // Set prev to null, curr to the head of the second half, adn next to curr.next.
    // Then, in a loop, set curr.next to prev, prev to curr, curr to next and next to curr.next
    // until curr becomes bull.
    // The new head of the reversed second half is prev.
    // * Merge the two halves of the list by alternating nodes from each half.
    // Initialize two pointers, p1 and p2, pointing to the head of the first and second half respectively.
    // In a loop, set p1.next to p2, p2.next to p1.next, p1 to p1.next and p2 to p2.next until p2 becomes null.
    // This way, we will interleave nodes from each half and get the reordered list.

    // COde:
    public void reorderList(ListNode head) {
        // edge case: empty or single node list
        if (head == null || head.next == null) return;

        // find the middle node of the list
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // cut the list into two halves
        ListNode head2 = slow.next;
        slow.next = null;

        // reverse the second half of the list
        ListNode prev = null;
        ListNode curr = head2;
        ListNode next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head2 = prev;

        // merge the two halves of the list
        ListNode p1 = head;
        ListNode p2 = head2;
        while (p2 != null) {
            next = p1.next;
            p1.next = p2;
            p2 = p2.next;
            p1.next.next = next;
            p1 = next;
        }
    }

    // Big O:
    // The time complexity of this solution is O(n), where n is the number of nodes in the list.
    // This is because we traverse the list three times:
    // once to find the middle node, once to reverse the second half, and once to merge the two halves.
    // The space complexity is O(1), as we only use constant extra space for pointers.

}
