//// 2023/04/29 // 10:36 //

//// 104. Maximum Depth of Binary Tree // Easy //

// Given the root of a binary tree, return its maximum depth.

// A binary tree's maximum depth is the number of nodes along the longest path
// from the root node down to the farthest leaf node.

// Example 1:
// PICTURE
// Input: root = [3,9,20,null,null,15,7]
// Output: 3

// Example 2:
// Input: root = [1,null,2]
// Output: 2

// Constraints:
// * The number of nodes in the tree is in the range [0, 10^4].
// * -100 <= Node.val <= 100

class MaximumDepthOfABinaryTree {

    /**
     * Definition for a binary tree node
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

    public class TreeNode {

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

    public int maxDepth(TreeNode root) {
        // Base case: if root is null, return 0
        if (root == null) {
            return 0;
        }
        // Recursive case: find max depth of left and right subtrees
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        // Return max of left and right depth plus 1
        return Math.max(leftDepth, rightDepth) + 1;

    }

    // The maximum depth of a binary tree is the number of nodes along the longest path from the
    // root node to a leaf node. A leaf node is a node that has no children. To find the maximum
    // depth of a binary tree, we can use a recursive algorithm that follows these steps:
    // * If the root node is null, return 0 as the depth.
    // * Otherwise, recursively find the maximum depth of the left subtree and the right subtree of
    // the root node.
    // * Return the maximum of the two depths plus 1 as the depth of the root node.
    // The time complexity of this algorithm is O(n), where n is the number of nodes in the tree
    // because we visit each node once. The space complexity is O(h), where hs is the height of the
    // tree, because of the recursive call stack.

}


















