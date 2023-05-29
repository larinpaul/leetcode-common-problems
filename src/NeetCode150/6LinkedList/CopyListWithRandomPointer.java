//// 2023/05/29 // 17:38 //

//// 138. Copy List with Random Pointer // Medium //

// A linked list of length n is given such that each node contains an additional random pointer,
// which could point ot any node in the list, or null.

// Construct a deep copy of the list. The deep copy should consist of exactly n brand new nodes,
// where each new node has its value set to the value of its values set to the value of its corresponding
// original node. Both the next and random pointer of the new nodes should point to new nodes in the
// copied list such that the pointers in the original list and copied list represent the same list state.
// None of the pointers in the new list should point to nodes in the original list.

// For example, if there are two nodes X and Y in the original list, where X.random --> Y,
// then for the corresponding two nodes x and y in the copied list, x.random --> y.

// Return the head of the copied linked list.

// The linked list is represented in the input/output as a list of n nodes. Each node is
// represented as a pair of [val, random_index] where:
// * val: an integer representing Node.val
// * random_index: the index of the node (range from 0 to n-1) that the random pointer
// points to, or null if it does not point to any node.

// Your code will only be given the head of the original linked list.

// Example 1:
// Picture
// Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
// Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]

// Example 2:
// Input: head = [[1,1],[2,1]]
// Output: [[1,1],[2,1]]

// Example 3:
// Input: head = [[3,null],[3,0],[3,null]]
// Output: [[3,null],[3,0],[3,null]]

// Constraints:
// * 0 <= n <= 1000
// * -10^4 <= Node.val <= 10^4
// * Node.random is null or is pointing to some node in the linked list.

import java.util.HashMap;

class CopyListWithRandomPointer {

    // Definition for a Node.
    class Node {
        int val;
        Node next;
        Node random;
    }

    // This is a problem of creating a deep copy of a linked list with random pointers.
    // A deep copy means that every node in the new list is a new object, not a reference
    // to the original node. The challenge is to copy the random pointers correctly,
    // since they can point to any node in the list or null.

    // One possible solution is to use a hash map to store the mapping between the original nodes and the
    // copied nodes. The hash map can help us find the corresponding node for the random pointer in
    // constant time. The algorithm is as follows:
    // * Create a hash map that maps each original node to its copy node.
    // * Iterate through the original list and create a new node for each original node.
    // Store the mapping in the hash map.
    // * Iterate through the original list and create a new node for each original node.
    // Store the mapping in the hash map.
    // * Iterate through the original list again and assign the next and random pointers
    // for each copied node using the hash map.
    // * Return the head of the copied list.

    // The code for this solution is:
    public Node copyRandomListBigONN(Node head) {
        // edge case: empty list
        if (head == null) return null;

        // create a hash map to store the mapping between original nodes and copied nodes
        HashMap<Node, Node> map = new HashMap<>();

        // iterate through the original list and create a new node for each original node
        Node cur = head;
        while (cur != null) {
            // create a new node with the same value as the original node
            Node copy = new Node(cur.val);
            // store the mapping in the hash map
            map.put(cur, copy);
            // move to the next node
            cur = cur.next;
        }

        // iterate through the original list again and assign the next and random pointers for each copied node
        cur = head;
        while (cur != null) {
            // get the copied node from the hash map
            Node copy = map.get(cur);
            // assign the next pointer using the hash map
            copy.next = map.get(cur.next);
            // assign the random pointer using the hash map
            copy.random = map.get(cur.random);
            // move to the next node
            cur = cur.next;
        }

        // return the head of the copied list
        return map.get(head);
    }

    // The time complexity of this solution is O(n), where n is the number of nodes in the list,
    // since we iterate through the list twice. The space complexity is also O(n),
    // since we use a hash map to store n mappings.


    // Another possible solution is to use a three-step approach without extra space.
    // The idea is to insert a new node behind each original node, then assign the random pointers
    // for the new nodes, and finally disconnect the list into two.
    // The algorithm is as follows:
    // * Iterate through the original list and insert an ew node behind each original node.
    // For example, if we have A -> B -> C -> null, we will have A -> A' -> B -> B' -> C -> C' -> null,
    // where A', B' and C' are new nodes with same values as A, B and C.
    // * Iterate through the modified list and assign values to the random pointers of new nodes.
    // For each new node, its random pointer should point to the next node of its original node's
    // random pointer. For example, if A.random points to C, then A'.random should point to C'.
    // This can be done by using cur.next.random = cur.random.next.
    // * Iterate through the modified list again and disconnect it into two lists.
    // For each original node, its next pointer should point to its next.next node.
    // For each new node, its next pointer should point to its next.next node if it exists,
    // or null otherwise. For example, A.next should point to B, A'. next should
    // point to B', B.next should point to C, B'.next should point to C',
    // C.next should point to null,
    // C'.next should point to null.
    // * Return the head of the copied list

    // The code for this solution is:
    public Node copyRandomList(Node head) {
        // edge case: empty list
        if (head == null) return null;

        // iterate through the original list and insert a new node behind each original node
        Node cur = head;
        while (cur != null) {
            // create a new node with same value as current node
            Node copy = new Node(cur.val);
            // insert it between current node and next node
            copy.next = cur.next;
            cur.next = copy;
            // move to next pair of nodes
            cur = cur.next.next;
        }

        // iterate through the modified list and assign values to random pointers of new nodes
        cur = head;
        while (cur != null) {
            // if current node has a random pointer, assign its next node's random pointer accordingly
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
            // move to next pair of nodes
            cur = cur.next.next;
        }

        // iterate through modified list again and disconnect it into two lists
        cur = head;
        Node copyHead = head.next; // save head of copied list
        while (cur != null) {
            // get current pair of nodes
            Node orig = cur;
            Node copy = cur.next;

            // update orig's next pointer to skip copy
            orig.next = orig.next.next;

            // update copy's next pointer to skip orig if possible
            if (copy.next != null) {
                copy.next = copy.next.next;
            }

            // move to next pair of nodes
            cur = orig.next;
        }
        // return head of copied list
        return copyHead;
    }

    // The time complexity of this solution is also O(n), where n is then number of nodes in the list,
    // since we iterate through it three times.
    // The space complexity is O(1), since we do not use any extra space.

}
















