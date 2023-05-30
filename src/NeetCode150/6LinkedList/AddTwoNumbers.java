//// 2023/05/30 // 17:51 //

//// 2. Add Two Numbers // Medium //

// You are given two non-empty linked lists representing two non-negative integers.
// The digits are stored in reverse order, and each of their nodes contains a single digit.
// Add the two numbers and return the sum as a linked list.

// You may assume the two numbers do not contain any leading zero,
// except the number 0 itself.

// Example 1:
// Picture
// Input: l1 = [2,4,3], l2 = [5,6,4]
// Output: [7,0,8]
// Explanation: 342 + 465 = 807.

// Example 2:
// Input: l1 = [0], l2 = [0]
// Output: [0]

// Example 3:
// Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
// Output: [8,9,9,9,0,0,0,1]

// Constraints:
// * THe number of nodes in each linked list is in the range [1, 100].
// * 0 <= Node.val <= 9
// * It is guaranteed that the list represents a number that does not have leading zeros.

import javax.swing.plaf.SeparatorUI;

class AddTwoNumbers {

    // This is a common problem that tests the understanding of linked lists and arithmetic operations.

    // Explanation:
    // * The idea is to traverse both linked lists from start to end
    // and add the corresponding digits of each node.
    // * If the sum of two digits is greater than 9, then we need to carry over 1 to the next digit
    // and store the remainder in the current node.
    // * If one of the lists has more nodes that the other, we can assume that the missing digits are 0.
    // * We also need to handle the case when there is a carry over after adding the last digits of both lists.

    // Solution:
    // * We can use a dummy node to store the head of the result list and a pointer to keep track of the current node.
    // * We can also use a variable to store the carry value and initialize it to 0.
    // * We can use a while loop to iterate over both lists until they are both null or the carry is non-zero.
    // * Inside the loop, we can get the values of the current nodes of both lists or 0 if they are null.
    // * We can add these values with the carry and update the carry and the sum accordingly.
    // * We can create a new node with the sum value and append it to the result list.
    // * We can also update the current nodes of both lists and the result list.
    // * After the loop, we can return the next node of teh dummy node as the head of the result list.

    // Code:
    // Definition for singly-linked list.
    private class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // create a dummy node to store the head of the result list
        ListNode dummy = new ListNode(0);
        // create a pointer to keep track of the current node
        ListNode curr = dummy;
        // create a variable to store the carry value
        int carry = 0;
        // loop until both lists are null or carry is non-zero
        while (l1 != null || l2 != null || carry != 0) {
            // get the values of the current nodes or 0 if null
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;
            // add these values with carry and update carry and sum
            int sum = val1 + val2 + carry;
            carry = sum / 10;
            sum = sum % 10;
            // create a new node with sum value and append it to result list
            curr.next = new ListNode(sum);
            curr = curr.next;
            // update the current nodes of both lists
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        // return the next node of dummy as head of result list
        return dummy.next;
    }

    // Big O:
    // * Time complexity is O(n): O(max(m,n)), where m and n are the lengths of thw two lists.
    // We need to traverse both lists once and perform constant operations at each node.
    // * Space complexity is O(n): O(max(m,n)), where m and n are the lengths of the two lists.
    // We need to create a new list that has at most max(m,n) + 1 nodes

}
