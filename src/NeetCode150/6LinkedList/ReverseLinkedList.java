//// 2023/04/15 // 12:52 //

//// 206. Reverse Linked List // Easy

// Given the head of a singly linked list, reverse the list,
// and return the reversed list.

// Example 1:
// Input: head = [1,2,3,4,5]
// Output: [5,4,3,2,1]

// Example 2:
// Input: head = [1,2]
// Output: [2,1]

// Example 3:
// Input: head = []
// Output: []

// Constraints:
// The number of nodes in the list is the range [0, 5000].
// -5000 <= Node.val <= 5000

// Follow up: A linked list can be reversed either iteratively or recursively.
// Could you implement both:

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class ReverseLinkedList {

    // Define a method that takes the head of a linked list
    // and returns the head of the reversed list
    public ListNode reverseList(ListNode head) {
        // Initialize three pointers: prev, curr, and next
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;
        // Loop until curr reaches the end of the list
        while (curr != null) {
            // Save the next node of curr
            next = curr.next;
            // Make curr point to prev
            curr.next = prev;
            // Move prev and curr one step forward
            prev = curr;
            curr = next;
        }
        // Return prev as the new head of the reversed list
        return prev;
    }

    public static void main(String[] args) {
        System.out.println(new ReverseLinkedList().reverseList(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))))); // 5 -> 4 -> 3 -> 2 -> 1
        System.out.println(new ReverseLinkedList().reverseList(new ListNode(1, new ListNode(2)))); // 2 -> 1
        System.out.println(new ReverseLinkedList().reverseList(null)); // null
    }

}








