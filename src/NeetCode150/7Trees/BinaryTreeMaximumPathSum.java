//// 2023/07/16 // 15:33 //

//// 124. Binary Tree Maximum Path Sum // Hard //

// A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the
// sequence has an edge connecting them. A node can only appear in the sequence at most once.
// Note that the path does not need to pass through the root.

// The path sum of a path is the sum of the node's values in the path.

// Given the root of a binary tree, return the maximum path sum of any non-empty path.

// Example 1:
// Image
// Input: root = [1,2,3]
// Output: 6
// Explanation: The optimal path is 2 -> 1 -> 3 with a path sum of 2 + 1 + 3 = 6.

// Example 2:
// Image
// Input: root = [-10,9,20,null,null,15,7]
// Output: 42
// Explanation: The optimal path is 15 -> 20 -> 7 with a path sum of 15 + 20 + 7 = 42.

// Constraints:
// * The number of nodes in the tree is in the range [1, 3 * 10^4].
// * -1000 <= Node.val <= 1000

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class BinaryTreeMaximumPathSum {

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

    // Explanation:
    // The problem asks to find the maximum path sum in a binary tree.
    // The path can start and end at any node, and it does not need to pass through the root.

    // To solve this problem we can use a recursive approach.
    // The idea is to calculate the maximum path sum for each node in the tree,
    // considering the node itself, the left subtree, and the right subtree.

    // For each node, we have two cases to consider for the maximum path sum:
    // 1. The maximum path sum including the current node and one of its children (left or right).
    // 2. The maximum path sum that passes through the current node and includes both its left and right children.

    // We can calculate these values recursively and update the global maximum path sum at each step.

    // Solution:
    // 1. Initialize a global variable maxSum to keep track of the maximum path sum.
    // 2. Define a helper function maxGain(node) that takes a node as input and returns the maximum path
    // that can be obtained by including the node in the path.
    // 3. In the maxGain(node) function, return 0 if the input node is null.
    // 4. Recursively call maxGain(node.left) and maxGain(node.right)
    // to get the maximum gain for the left and right children.
    // 5. Update the global maxSum with the maximum path sum that passes through the current node
    // and includes both its left and right children.
    // 6. Return the maximum gain that can be obtained by including the current node in the path.
    // 7. Call maxGain(root) and return the final maxSum.

    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    private int maxGain(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftGain = Math.max(maxGain(node.left), 0);
        int rightGain = Math.max(maxGain(node.right), 0);

        int newPathSum = node.val + leftGain + rightGain;
        maxSum = Math.max(maxSum, newPathSum);

        return node.val + Math.max(leftGain, rightGain);
    }

    // Big O:
    // * Time Complexity: O(n), where n is the number of nodes in the tree.
    // We visit each node once.
    // * Space Complexity: O(h), where h is the height of the tree.
    // This is because of the recursion stack.
    // In the worst case, the tree is completely unbalanced, and the height is equal to the number of nodes (n).
    // In the best case, the tree is completely balanced, and the height is log(n).

}
