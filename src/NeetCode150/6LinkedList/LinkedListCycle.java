//// 2023/04/28 // 10:11 //

//// 141. Linked List Cycle // Easy //

// Given head, the head of a linked list, determine if the linked list has a cycle in it.

// There is a cycle in a linked list if there is some node in the list that can be reached again by
// continuously following the next pointer. Internally, pos is used to denote the index of the node
// that tail's next pointer is connected to. Note that pos is not passed as a parameter.

// Return true if there is a cycle in the linked list. Otherwise, return false.

// Example 1:
// PICTURE...
// Input: head = [3,2,0,-1], pos = 1
// Output: true
// Explanation: There is a cycle in the Linked List, where the tail connect
// to the last 1st node (0-indexed).

// Example 2:
// PICTURE...
// Input: head = [1,2], pos = 0
// Output: true
// Explanation: There is a cycle in the linked list, where the tail connects
// to the 0th node.

// Example 3:
// Input: head = [1], pos = -1
// Output: false
// Explanation: There is no cycle in the linked list.

// Constraints:
// * The number of the nodes in the list is in the range [0, 10^4].
// * -10^5 <= Node.val <= 10^5
// * pos is -1 or a valid index in the linked-list.

// Follow up: Can you solve it using O(1) (i.e. constant) memory?

public class LinkedListCycle {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }

    }

    // One possible solution is to use two pointers, one slow and one fast, to traverse the linked list.
    // The slow pointer moves one node at a time, while the fast pointer moves two nodes at a time.
    // If there is a cycle in the list, the fast pointer will eventually catch up with the slow pointer.
    // If there is no cycle, the fast pointer will reach the end of the list.
    // This solution uses O(1) memory and O(n) time, where n is the number of nodes in the list.

    public boolean hasCycle(ListNode head) {
        // Edge case: an empty list or a single node
        if (head == null || head.next == null) {
            return false;
        }

        // Initialize two pointers
        ListNode slow = head;
        ListNode fast = head.next;

        // Loop until fast reaches the end or meets slow
        while (fast != null && fast.next != null) {
            // If fast and slow are equal, there is a cycle
            if (fast == slow) {
                return true;
            }
            // Move slow one node and fast two nodes
            slow = slow.next;
            fast = fast.next.next;
        }
        // If fast reaches the end, there is no cycle
        return false;
    }


}




