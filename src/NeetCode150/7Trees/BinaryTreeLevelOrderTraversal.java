//// 2023/06/23 // 17:05 //

//// 102. Binary Tree Level Order Traversal // Medium //

// Given the root of a binary tree, return the level order traversal of its nodes' values.
// (i.e., from left to right, level by level).

// Example 1:
// Picture
// Input: root = [3,9,20,null,null,15,7]
// Output: [[3],[9,20],[15,7]]

// Example 2:
// Input: root = [1]
// Output: [[1]]

// Example 3:
// Input: root = []
// Output: []

// Constraints:
// * The number of nodes in the tree is in the range [0, 2000].
// * -1000 <= Node.val <= 1000

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class BinaryTreeLevelOrderTraversal {

    // Solution:
    // The idea is to use a queue to store the nodes of each level, and then dequeue them one by
    // one and add their values to a list. Then, enqueue their left and right children if they exist,
    // and repeat the process until the queue is empty.
    // This way, we can traverse the tree level by level from left to right.

    // Explanation:
    // We create an empty list of lists to store the final result, and an empty queue to store the
    // nodes of each level. We also create a variable to keep track of the size of the queue, which
    // represents the number of nodes in the current level. We initialize the queue
    // by adding the root node if it is not null, and set the size to 1.
    // Then, we enter a while loop that runs until the queue is empty.
    // Inside the loop, we create an empty list to store the values of the current level,
    // and use a for loop to iterate through the size of the queue.
    // For each iteration, we dequeue a node form the queue and add its value to the list.
    // Then, we enqueue its left and right children if they are not null.
    // After the for loop, we add the list to the result list, and update the size
    // to the new size of the queue.
    // We repeat this process until the queue is empty, and then return the result list.

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
    public List<List<Integer>> levelOrder(TreeNode root) {
        // create an empty list of lists to store the final result
        List<List<Integer>> result = new ArrayList<>();
        // create an empty queue to store the nodes of each level
        Queue<TreeNode> queue = new LinkedList<>();
        // create a variable to keep track of the size of the queue
        int size = 0;
        // initialize the queue by adding the root node if it is not null
        if (root != null) {
            queue.offer(root);
            size = 1;
        }
        // enter a while loop that runs until the queue is empty
        while (!queue.isEmpty()) {
            // create an empty list to store the values of the current level
            List<Integer> level = new ArrayList<>();
            // use a for loop to iterate through the size of the queue
            for (int i = 0; i < size; i++) {
                // dequeue a node from the queue and add its value to the list
                TreeNode node = queue.poll();
                level.add(node.val);
                // enqueue its left and right children if they are not null
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            // add the list to the result list
            result.add(level);
            // update the size to the new size of the queue
            size = queue.size();
        }
        // return the result list
        return result;
    }

    // Big O:
    // The time complexity of this solution is O(n), where n is the number of nodes in the tree,
    // because we visit each node once and add it to a list or a dequeue.
    // The space complexity is O(n), because we use a queue that can hold up to n nodes at most,
    // and a list of lists that can also hold up to n values at most.

}
