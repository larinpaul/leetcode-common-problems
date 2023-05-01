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

    // The diameter of a binary tree is the length of the longest path between any two nodes in the
    // tree. This path may or may not pass through the root. The length of a path between two nodes
    // is represented by the number of edges between them.

    // To find the diameter of a binary tree, we can use the following idea:
    // * For each node, we can calculate the height of its left subtree and right subtree.
    // * The diameter of the tree passsing through that node is the sum of the heights of its left and
    // right subtrees plus one (for the node itself).
    // * We can compare the diameters of all nodes and return the maximum one as the answer.

    public int diameterOfBinaryTree(TreeNode root) {
        // Base case: empty tree has zero diameter
        if (root == null) return 0;

        // Initialize a global variable to store the maximum diameter
        int maxDiameter = 0;

        // Define a helper function to calculate the height of a subtree
        int height(TreeNode node) {
            // Base case: bull node has zero height
            if (node == null) return 0;

            // Recursively calculate the height of left and right subtrees
            int leftHeight = height(node.left);
            int rightHeight = height(node.right);

            // Update the maximum diameter with the current node's diameter
            maxDiameter = Math.max(maxDiameter, leftHeight + rightHeight + 1);

            // Return the height of the current node
            return Math.max(leftHeight, rightHeight) + 1;
        }

        // Cal the helper function on the root node
        height(root);

        // Return the maximum diameter
        return maxDiamter - 1; // Subtract one to get the number of edges
    }
}

// The time complexity of this solution is O(n) where n is the number of nodes in the tree,
// because we visit each node once and calculate its height in constant time.

// The space complexity is O(h), where h is the height of the tree, because of the recursive
// call stack.
