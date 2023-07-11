//// 2023/07/11 // 11:04 //

//// 25. Reverse Nodes in k-Group // Hard //

// Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.

// k is a positive integer and is less than or equal to the length of the linked list.
// If the number of nodes in not a multiple of k then left-out nodes, in the end, should remain as it is.

// You may not alter the values in the list's nodes, only nodes themselves may be changed.

// Example 1:
// Image
// Input: head = [1,2,3,4,5], k = 2
// Output: [2,1,4,3,5]

// Example 2:
// Image
// Input: head = [1,2,3,4,5], k =3
// Output: [3,2,1,4,5]

// Constraints:
// * The number of nodes in the list is n.
// * 1 <= k <= n <= 5000
// * 0 <= Node.val <= 1000

// Follow-up: Can you solve this problem is O(1) extra memory space?


/**
 * Definition for a singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class ReverseNodesInKGroup {

    private class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    // Explanation:
    // The problem requires us to reverse nodes in groups of size k.
    // We can solve this problem by iterating through the linked list in groups of k nodes at a time,
    // and reversing each group as we go.
    // The key idea is to use a helper function to reverse a group of k nodes and connect the
    // reversed group to the previous group.
    // We can repeat this process until we reach the end of the list.

    // Solution:
    // We can implement the solution using a while loop to iterate through the linked list
    // in groups of k nodes at a time.
    // Inside the loop, we can use a helper function to reverse the current group of k nodes
    // and connect it to the previous group.
    // If there are less than k nodes left at the end of the list,
    // we can leave them as they are.

    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = head;
        int count = 0;
        while (curr != null) {
            count++;
            if (count % k == 0) {
                prev = reverse(prev, curr.next);
                curr = prev.next;
            } else {
                curr = curr.next;
            }
        }
        return dummy.next;
    }

    private ListNode reverse(ListNode prev, ListNode next) {
        ListNode last = prev.next;
        ListNode curr = last.next;
        while (curr != next) {
            last.next = curr.next;
            curr.next = prev.next;
            prev.next = curr;
            curr = last.next;
        }
        return last;
    }

    // Big O:
    // Time complexity:
    // O(n), where n is the number of nodes in the linked list.
    // We iterate through each node once.
    // Space complexity:
    // O(1). We only use constant extra memory space.

}
