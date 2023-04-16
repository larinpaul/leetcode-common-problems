//// 2023/04/16 // 16:41 //

//// 226. Invert Binary Tree // Easy

// Given the root of a binary tree, invert the tree, and return its root.

// Example 1:
// IMAGE
// Input: root = [4,2,7,1,3,6,9]
// Output: [4,7,2,9,6,3,1]

// Example 2:
// IMAGE
// Input: root = [2,1,3]
// Output: [2,3,1]

// Example 3:
// Input: root = []
// Output: []

// Constraints:
// The number of nodes in the tree is in the range [0, 100].
// -100 <= Node.val <= 100

// To invert a binary tree, we need to swap the left and right subtrees of each node
// recursively. We can use a helper function that takes a node as a parameter
// and returns the inverted node.
// If the node is null, we return null. Otherwise, we swap the left and right
// children of the node, and then recursively invert the left and right subtrees. The base
// case is when the node is a leaf, in which case we just return the node. Here is one
// possible solution in Java:

/**
 * Definition for a binary tree node
 * public class TreeNode.java {
 *     int val;
 *     TreeNode.java left;
 *     TreeNode.java right;
 *     TreeNode.java() {}
 *     TreeNode.java(int val) { this.val = val; }
 *     TreeNode.java(int val, TreeNode.java left, TreeNode.java right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
///// USING A HELPER METHOD
//class InvertBianryTree {
//
//    public TreeNode invertTree(TreeNode root) {
//        // Call the helper function on the root
//        return invert(root);
//    }
//
//    private TreeNode invert(TreeNode) {
//        // If the node is null, return null
//        if (node == null) {
//            return null;
//        }
//        // If the node is a leaf, return the node
//        if (node.left == null && node.rigth == null) {
//            return node;
//        }
//        // Swap the left and right children of the node
//        TreeNode temp = node.left;
//        node.left = node.right;
//        node.right = temp;
//        // Recursively invert the left and right subtrees
//        node.left = invert(node.left);
//        node.right = invert(node.right);
//        // Return the inverted node
//        return node;
//    }
//
//
//}

/// NOT USING A HELPER METHOD:
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { thiva.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode invertTree(TreeNode root) {
        // If the root is null or a leaf, return the root
        if (root == null || (root.left == null && root.right == null)) {
            return root;
        }
        // Swap the left and right children of the root
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        // Recursively invert the left and right subtrees
        root.left = invertTree(root.right);
        root.right = invertTree(root.right);
        // Return the inverted root
        return root;
    }
}
