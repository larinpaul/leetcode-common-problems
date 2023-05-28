//// 2023/05/28 // 19:24 //

//// 19. Remove Nth Node From End of List // Medium //

// Given the head of a linked list, remove the nth node from the end of the list and return its head.

// Example 1:
// Picture
// Input: head = [1,2,3,4,5], n = 2
// Output: [1,2,3,5]

// Example 2:
// Input: head = [1], n = 1
// Output: []

// Example 3:
// Input: head = [1,2], n = 1
// Output: [1]

// Constraints:
// * The number of nodes in the list is sz.
// * 1 <= sz <= 30
// * 0 <= Node.val <= 100
// 1 <= n <= sz

// Follow up: Could you do this on one pass?

class RemoveNthNodeFromEndOfList {

    // Explanation:
    // The problem asks us to remove the nth node form the end of a linked list and return the
    // modified list. A linked list is a data structure that consists of nodes that have a value and a pointer to
    // the next node. To remove a node from a linked list, we need to find the previous node and make its next
    // pointer point to the node after the one we want to remove. To find the nth node from the end, we can
    // use two pointers: one that moves n steps ahead of the other, and then both move at the same pace until
    // the first one reaches the end. Then, the second pointer will be at the previous node of the target node.

    // Solution:
    // We can use a dummy node to simplify the edge cases where we need to remove the head of
    // the tail of the list. We create a dummy node with value 0 and make its next pointer point to the head of the list.
    // Then, we create two pointers: fast and slow, both pointing to the dummy node. We move the
    // fast pointer n steps ahead of the slow pointer by using a for loop. Then, we check if the fast pointer is
    // null, which means we need to remove the head of the list. In that case, we make the dummy node's next
    // pointer point to the head's next node and return dummy.next as the new head. Otherwise, we move both
    // pointers at the same pace until fast.next is null, which means fast is at the last node of the list.
    // Then, slow will be at the previous node of the target node. We make slow.next point to slow.next.next,
    // which effectively removes the target node from the list.
    // Finally, we return dummy.next as the new head.

    // Code:
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // create a dummy node with value 0
        ListNode dummy = new ListNode(0);
        // make dummy's next pointer point to head
        dummy.next = head;
        // create two pointers: fast and slow
        ListNode fast = dummy;
        ListNode slow = dummy;
        // move fast n steps ahead of slow
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        // check if fast is null, which means we need to remove head
        if (fast == null) {
            // make dummy's next pointer point to head's next node
            dummy.next = head.next;
            // return dummy.next as new head
            return dummy.next;
        }
        // move both pointers at same pace utill fast.next is null
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        // make slow.next point to slow.next.next
        slow.next = slow.next.next;
        // return dummy.next as new head
        return dummy.next;
    }

    // Big O:
    // The time complexity of this solution is O(n), where n is the number of nodes in the list,
    // because we need to traverse the list once with two pointers. The space complexity is O(1), because
    // we only use constant extra space for the dummy node and two pointers.

}
