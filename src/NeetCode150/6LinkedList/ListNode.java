//// Definition for singly-linked list.
//public class ListNode {
//    int val;
//    ListNode next;
//
//    ListNode() {
//    }
//
//    ListNode(int val) {
//        this.val = val;
//    }
//
//    ListNode(int val, ListNode next) {
//        this.val = val;
//        this.next = next;
//    }
//
//}
//
//

// Define a class that represents a node of a linked list
class ListNode {
    // Define the data and next fields
    int data;
    ListNode next;
    // Define a constructor that takes the data as an argument
    ListNode(int data) {
        this.data = data;
        this.next = null;
    }
}

// The explanation is based on using three pointers: prev, curr, and next
// to reverse the links between the nodes. The idea is to start form the head
// of the list and make each node point to its previous node.
// To do this, we need to save the next node of curr before chaining its pointer.
// We also need to update prev and curr for each iteration. At the end of the loop,
// curr will be null and prev will be the last node of the original list.
// Therefore, prev is also the new head of the reversed list.

// The time complexity of this solution is O(n), where n is the number of nodes in the list.
// The space complexity is O(1), as we only use constant extra space.

