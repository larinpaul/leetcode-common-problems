//// 2023/05/05 // 10:20 //
//// 1046. Last Stone Weight // Easy //

// You are given an array of integers stones where stores[i] is the weight o the
// ith stone.

// We are playing a game with the stones. On each turn, we choose the heaviest two
// stones and smash them together. Suppose the heaviest two stones have weights x
// and y with x <= y. The result of this smash is:

// * If x == y, both stones are destroyed, and
// * If x != y, the stone of weight x is destroyed, and the stone of weight y has
// new weight y - x.

// At the end of the game, there is at most one stone left.

// Return the weight of the last remaining stone. If there are no stones left, return 0.

// Example 1:
// Input: stones = [2,7,4,1,8,1]
// Output: 1
// Explanation:
// We combine 7 and 8 to get 1 so the array converts to
// [2,4,1,1,1] then,
// we combine 2 and 4 to get 2 so the array converts to
// [2,1,1,1] then,
// we combine 2 and 1 to get 1 so the array converts to
// [1,1,1] then,
// we combine 1 and 1 to get 0 so the array converts to [1]
// then that's the value of the last stone.

// Example 2:
// Input: stones = [1]
// Output: 1

// Constraints:
// * 1 <= stones.length <= 30
// * 1 <= stones[i] <= 1000

import java.util.PriorityQueue;

class Solution {

    // Explanation:

    // * The idea is to use a priority queue to store the stones in descending order of weight,
    // so that we can always get the heaviest two stones easily.

    // * We add all the stones to the queue and then loop until there is only one or zero stones left.

    // * In each iteration, we poll the heaviest two stones from the queue and compare them. If they are
    // equal, we discard them. If they are different, we subtract the lighter one from the heavier one and
    // add the result back to the queue.

    // * At the end, we return the weight of the last remaining stone or 0 if there is none.


    // Big O:

    // * Time complexity: O(n log n), where n is the number of stones. We need to iterate over all the stones
    // and add them to the queue, which takes O(n log n) time. Then we need to perform at most n - 1
    // iterations of smashing, each of which takes O(log n) time to poll and offer from the queue. So the
    // total time complexity is O(n log n + (n-1) log n) = O(n log n).

    // * Space complexity: O(n), where n is the number of stones. We need to store all the stones in the
    // queue, which takes O(n) space.

    public int lastStoneWeight(int[] stones) {

        // Create a priority queue to store the stones in descending order of weight
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        // Add all the stones to the queue
        for (int stone : stones) {
            pq.offer(stone);
        }
        // While there are more than one stones in the queue
        while (pq.size() > 1) {
            // Poll the heaviest two stones
            int x = pq.poll(); // poll() is a method of the Queue interface in Java.
            int y = pq.poll(); // It is used to remove and return the element at the front of the queue
            // If they are equal, both are destroyed
            if (x == y) {
                continue;
            }
            // If they are different, the lighter one is destroyed and the heavier one has new weight
            else {                  // offer() is a method of the Queue interface in Java.
                pq.offer(x - y); // It is used to insert a particular element into the queue
            }                       // if it is possible to do so immediately without violating capacity restrictions
        }                           // It returns true if the element is successfully inserted
        // Return the weight of the last remaining stone or 0 if none
        return pq.isEmpty() ? 0 : pq.peek();
    }

    // A priority queue is an abstract data type that defines a collection of elements with priorities, and allows
    // operations such as inserting an element with a given priority, and removing the element with the highest
    // or lowest priority. A heap is a concrete data structure that can be used to implement a priority queue
    // efficiently. A heap is a binary tree that satisfies the heap property: every node is greater than or equal to
    // its children (in a mx-heap) or less than or equal to its children (in a min-heap). A priority queue can be
    // implemented using either a max-heap or a min-heap, depending on whether we want to remove the
    // maximum or minimum element. In Java, the PriorityQueue class uses a min-heap by default, but we can
    // provide a custom operation to reverse the order

    // The poll() method is a method of the Queue interface in Java. It is used to remove and return the
    // element at the front of the queue. It deletes the element from the queue. The method returns null when
    // the queue is empty. For example, in the code I wrote for you, I used poll() to get the heaviest two
    // stones form the priority queue and smash them together.

    // The offer() method is a method of the Queue interface in Java. It is used to insert a particular element
    // into the queue if it is possible to do so immediately without violating capacity restrictions. It returns true
    // if the element is successfully inserted, or false otherwise. It does not throw an exception if the queue is
    // full, unlike the add() method. It is preferable to use offer() when the queue has a fixed capacity. For
    // example, in the code, we used offer() to add the stones to the priority queue.

    // The peek() method in Java is used to retrieve but not remove the element at the front of a queue or a
    // stack. It returns the element or null if the queue or stack is empty.

}






