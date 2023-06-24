//// 2023/06/24 // 12:15 //

//// 199. Binary Tree Right Side View // Medium //

// Given the root of a binary tree, imagine yourself standing on the right side of it,
// return the values of the modes you can see ordered from top to bottom.

// Example 1:
// Picture
// Input: root = [1,2,3,null,5,null,4]
// Output: [1,3,4]

// Example 2:
// Input: root = [1,null,3]
// Output: [1,3]

// Example 3:
// Input: root = []
// Output: []

// Constraints:
// * The number of nodes in the tree is in the range [0, 100].
// * -100 <= Node.val <= 100

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class BinaryTreeRightSizeView {

    // Solution:
    // The idea is to use a breath-first search (BFS) to traverse the tree level by level,
    // and keep track of the last node in each level. The last node in each level is the one
    // that can be seen from the right side of the tree. We can use a queue to store the nodes
    // in each level, and a list to store the values of the last nodes.

    // Explanation:
    // Here is a step-by-step explanation of the algorithm:
    // * Initialize an empty list to store the result, and an empty queue to store the nodes in each level.
    // * If the root is null, return the empty list.
    // * Add the root to the queue, and start a while loop that runs until the queue is empty.
    // * Initialize a variable to store the size of the current level, and another variable
    // to store the value of the last node in the current level.
    // * Start a for loop that runs form 0 to the size of the current level, and do the following:
    //  // * Dequeue a node from the queue, and update the value of the last node with its value.
    //  // * If the node has a left child, add it to the queue.
    //  // * If the node has a right child, add it to the queue.
    // * After the for loop, add the value of the last node to the result list.
    // * After the while loop. return the result list.

    /**
     * Definition for a binary tree node.
     */
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // Code:
    public List<Integer> rightSideView(TreeNode root) {
        // Initialize an empty list to store the result
        List<Integer> result = new ArrayList<>();
        // Initialize an empty queue to store the nodes in each level
        Queue<TreeNode> queue = new LinkedList<>();
        // If the root is null, return the empty list
        if (root == null) return result;
        // Add the root to the queue
        queue.offer(root);
        // Start a while loop that runs until the queue is empty
        while (!queue.isEmpty()) {
            // Initialize a variable to store the size of the current level
            int size = queue.size();
            // Initialize a variable to store the value of the last node in the current level
            int last = 0;
            // Start a for loop that runs from 0 to the size of the current level
            for (int i = 0; i < size; i++) {
                // Dequeue a node from the queue
                TreeNode node = queue.poll();
                // Update the value of the last node with its value
                last = node.val;
                // If the node has a left child, add it to the queue
                if (node.left != null) queue.offer(node.left);
                // If the node has a right child, add it to the queue
                if (node.right != null) queue.offer(node.right);
            }
            // After the for loop, add the value of the last node to the result list
            result.add(last);
        }
        // After the while loop, return the result list
        return result;
    }

    // Big O:
    // The time complexity of this algorithm is O(n), where n is the number of nodes in the tree,
    // because we visit each node once.
    // The space complexity is O(n), because we use a queue that can
    // store up to n nodes in the worst case (when all nodes are on one side of the tree).

}
