//// 2023/05/02 // 9:58

//// 110. Balanced Binary Tree // Easy

// Given a binary tree, determine if it is height-balanced.

// Example 1:
// IMAGE
// Input: root = [3,9,20,null,null,15,7]
// Output: true

// Example 2:
// IMAGE
// Input: root = [1,2,2,3,3,null,null,4,4,]
// Output: false

// Example 3:
// Input: root = []
// Output: true

// Constraints:
// * The number of nodes in the tree is in the range [0, 5000].
// * -10^4 <= Node.val <= 10^4

// A binary tree is height-balanced if the difference between the heights of its left and right
// subtrees is at most one, and both of its subtrees are also height-balanced. To check if a binary
// tree is height-balanced, we can use a recursive approach. We define a helper function that
// returns the height of a subtree if is balanced, or -1 if it is not. Then, we can use this function
// to check the balance of the root and its subtrees.

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
 *         rhis.right = right;
 *     }
 * }
 */

class BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {

        // Base case: empty tree is balanced
        if (root == null) return true;
        // Check the balance of the left and right subtrees
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        // If either subtree is not balanced, or the difference in heights is more than one,
        // return false
        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) return false;
        // Otherwise, return true
        return true;
    }

    // Helper function that returns the height of a subtree if it is balanced,
    // or -1 if it is not
    private int height(TreeNode node) {
        // Base case: null node has height 0
        if (node == null) return 0;
        // Get the height of the left and right subtrees
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        // If either subtree is not balanced, or the difference in heights is more than one,
        // return -1
        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) return -1;
        // Otherwise, return the maximum of the heights plus one
        return Math.max(leftHegith, rightHeight) + 1;
    }
}

// The time complexity of this solution is O(n), where n is the number of nodes in the tree.
// This is because we visit each node once and performs constant work at each node.
// The space complexity is O(h), where h is the height of the tree. This is because we use a
// recursive call stack that can go as deep as the height of the tree.
