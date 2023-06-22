//// 2023/06/21 // 9:44 //

//// 146. LRU Cache // Medium //

// Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.

// Implement the LRUCache class:
// * LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
// * int get(int key) Return the value of the key if the key exists, otherwise return -1.
// * void put(int key, int value) Update the value of teh key if the key exists.
// Otherwise, add the key-value pair to the cache. If the number of keys exceeds the
// capacity from this operation, evict the least recently used key.

// The functions get and put must each run in O(1) average time complexity

// Example 1:
// Input
// ["LRUCache", "put", "put, "get", "put", "get", "put", "get", "get", "get"]
// [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
// Output
// [null, null, null, 1, null, -1, null, -1, 3, 4]

// Explanation
// LRUCache lRUCache = new LRUCache(2);
// lRUCache.put(1, 1); // cache is {1=1}
// lRUCache.put(2, 2); // cache is {1=1, 2=2}
// lRUCache.get(1); // return 1
// lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
// lRUCache.get(2); // return -1 (not found)
// lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
// lRUCache.get(1); // return -1 (not found)
// lRUCache.get(3); // return 3
// lRUCache.get(4); // return 4

// Constraints:
// * 1 <= capacity <= 3000
// * 0 <= key <= 10^4
// * 0 <= value <= 10^5
// * At most 2 * 10^5 calls will be made to get and put.

import java.util.HashMap;

class LRUCache {

    // Explanation:

    // A LRU cache is a data structure that stores key-value pairs in a way that the least recently
    // used pair is removed when the cache reaches its capacity. This ensures that the cache
    // always contains the most frequently accessed items.

    // To implement a LRU cache, we need two data structures: a hash map and a doubly linked list.
    // The hash map stores the key and a reference to the corresponding node in the list.
    // The list stores the key-value pairs in the order of their recency of use.
    // The most recently used pair is at the head of the list,
    // and the least recently used pair is at the tail of the list.

    // The get operation involves looking up the key in the hash map, and returning the value of the
    // node if it exists. If the node exists, we also need to move it to the head of the list, since it is
    // now the most recently used pair. This can be done in O(1) time by updating the pointers of
    // the previous and next nodes of the current node, and then inserting it at the head of the list.

    // The put operation involves adding a new key-value pair to the cache, or updating the value
    // of an existing key. If the key already exists in the hash map, we need to update its value and
    // move it to the head of the list, similar to the get operation. If the key does not exists in the
    // hash map, we need to create a new node and insert it at the head of the list. We also need
    // to add it to the hash map. However, if the cache is full, we need to evict the last recently
    // used pair from the cache, which is at the tail of the list. We need to remove it from both the
    // list and the hash map. This can also be done in O(1) time by updating the pointers of the
    // last node and its previous node, adn then deleting it form both data structures.

    // Node class for doubply linked list
    private class Node {
        int key;
        int value;
        Node prev;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }



    // Hash map for storing key and node reference
    private HashMap<Integer, Node> map;
    // Doubly linked list for storing key-value pairs
    private Node head;
    private Node tail;
    // Capacity of cache
    private int capacity;
    // Current size of cache
    private int size;

    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.head = null;
        this.tail = null;
        this.capacity = capacity;
        this.size = 0;
    }

    public int get(int key) {
        // Check if key exists in hash map
        if (map.containsKey(key)) {
            // Get node from hash map
            Node node = map.get(key);
            // Move node to head of list
            moveToHead(node);
            // Return value of node
            return node.value;
        } else {
            // Key not found, return -1
            return -1;
        }
    }

    public void put(int key, int value) {
        // Check if key exists in hash map
        if (map.containsKey(key)) {
            // Get node from hash map
            Node node = map.get(key);
            // Update value of node
            node.value = value;
            // Move node to head of list
            moveToHead(node);
        } else {
            // Create new node with key-value pair
            Node node = new Node(key, value);
            // Add node to head of list
            addToHead(node);
            // Add node to hash map
            map.put(key, node);
            // Increment size of cache
            size++;
            // Check if cache is full
            if (size > capacity) {
                // Remove least recently used node from tail of list
                Node lru = removeTail();
                // Remove node from hash map
                map.remove(lru.key);
                // Decrement size of cache
                size--;
            }
        }
    }

    // Helper function to move a node to head of list
    private void moveToHead(Node node) {
        // Check if node is already at head
        if (node == head) {
            return;
        }
        // Remove node from its current position
        removeNode(node);
        // Add node to head of list
        addToHead(node);
    }

    // Helper method to add a node to head of list
    private void addToHead(Node node) {
        // Check if list is empty
        if (head == null) {
            // Set both head and tail to node
            head = node;
            tail = node;
        } else {
            // Set node as new head
            node.next = head;
            head.prev = node;
            head = node;
        }
    }

    // Helper method to remove a node from its current position
    private void removeNode(Node node) {
        // Check if node is at head
        if (node == head) {
            // Set new head to next node
            head = head.next;
        }
        // Check if node is at tail
        if (node == tail) {
            // Set new tail to previous node
            tail = tail.prev;
        }
        // Update pointers of previous and next nodes of current node
        Node prev = node.prev;
        Node next = node.next;
        if (prev != null) {
            prev.next = next;
        }
        if (next != null) {
            next.prev = prev;
        }
    }

    // Helper method to remove the least recently used node from tail of list
    private Node removeTail() {
        // Get the last node
        Node lru = tail;
        // Remove it from its current position
        removeNode(lru);
        // Return it
        return lru;
    }

    /**
     * Your LRUCache object will be instantiated and called as such:
     * LRUCache obj = new LRUCache(capacity);
     * int param_1 = obj.get(key);
     * obj.put(key,value);
     */

    // Big O:
    // * The get and put operations both run in O(1) average time complexity, since they involve
    // constant time operations on the hash map and the doubly linked list.
    // * The space complexity is O(capacity), since we store at most capacity key-value pairs in the cache

}
