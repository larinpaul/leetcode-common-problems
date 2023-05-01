//// 2023/05/01 // 11:47 //

//// 543. Diameter of Binary Tree // Easy //

// Given the root of a binary tree, return the length of the diameter of the tree.

// The diameter of a binary tree is the length of the longest path between any two nodes in a
// tree. This path may or may not pass through the root.

// The length of a path between two nodes is represented by the number of edges
// between them.

// Example 1:
// PICTURE
// Input: root = [1,2,3,4,5]
// Output: 3
// Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].

// Example 2:
// Input: root = [1,2]
// Output: 1

// Constraints:
// * The number of nodes in the tree is in the range [1, 10^4].
// * -100 <= Node.val <= 100

import javax.swing.tree.TreeNode;

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
class DiameterOfABinaryTree {

    // The diameter of a binary tree is the maximum value
    // of the sum of the heights of the left and right subtree sof any node in the tree.
    // To find this value, we can use a recursive function
    // that returns the height of a subtree and also updates a global variable
    // that stores the current diameter.
    // The height of a subtree is the maximum of the heights
    // of its left and right children plus one.
    // The diameter of a subtree is the maximum of the diameters of its left and right children
    // and the sum of the heights of its left and right children.
    // We can initialize the global variable to zero and update it
    // whenever we find a larger diameter.
    // The final answer will be the value of the global variable after traversing the whole tree.

    // A global variable to store the current diameter
    int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        // Call the recursive function on the root
        height(root);
        // Return the final answer
        return diameter;
    }

    // A recursive function that returns the height of a subtree and updates the diameter
    public int height(TreeNode node) {
        // Base case: if node is null, return 0
        if (node == null) return 0;
        // Recursively find the heights of left and right subtrees
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        // Update the diameter if the sum of left and right heights is larger than current diameter
        diameter = Math.max(diameter, leftHeight + rightHeight);
        // Return the height of this subtree as max of left and right heights plus one
        return Math.max(leftHeight, rightHeight) + 1;
    }
}

// The time complexity of this solution is O(n) where n is the number of nodes in the tree,
// because we visit each node once and calculate its height in constant time.

// The space complexity is O(h), where h is the height of the tree, because of the recursive
// call stack.
